package com.example.landing.service;

import com.example.landing.entity.FirstStep;
import com.example.landing.repository.FirstStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class FirstStepService {
    @Autowired
    private FirstStepRepository firstStepRepository;

    public Long newFirstStep(int cid, String country, String tariff) {
        FirstStep firstStep = new FirstStep();
        firstStep.setIdCampaing(cid);
        firstStep.setCountryIso(country);
        firstStep.setTariff(tariff);
        firstStep.setFecha(new Date(System.currentTimeMillis()).toString());
        firstStep.setHora(new Timestamp(System.currentTimeMillis()).toString());

        return firstStepRepository.save(firstStep).getId();
    }

    public String setFirstStep(int id, String msisdn, int carrier) {
        Optional<FirstStep> firstStep = firstStepRepository.findById((long) id);

        if (firstStep.isPresent()) {
            msisdn = aislarMsisdn(msisdn);

            if (!msisdn.equals("error")) {
                firstStep.get().setMsisdn(msisdn);
                firstStep.get().setCarrier(carrier);
                firstStep.get().setPin((int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000));

                firstStepRepository.save(firstStep.get());
                return "correcto";
            }
        }
        return "error";
    }

    public boolean tryPin(int id, int pin) {
        Optional<FirstStep> firstStep = firstStepRepository.findById((long) id);

        return firstStep.filter(step -> step.getPin() == pin).isPresent();
    }

    private boolean comprobarMsisdn(String msisdn) {
        Pattern movil = Pattern.compile("(\\+34|034|34|0|00)?[ -]*([67])[ -]*([0-9][ -]*){8}");
        return movil.matcher(msisdn).matches();
    }

    private String aislarMsisdn(String msisdn) {
        if (comprobarMsisdn(msisdn)) {
            return msisdn.replace("-", "").replaceAll("\\s", "").substring(msisdn.length() - 9);
        }
        return "error";
    }
}
