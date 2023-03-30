package com.example.landing.controller;

import com.example.landing.entity.FirstStepDTO;
import com.example.landing.service.FirstStepService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;

@RestController
@RequestMapping("/{country}/{pagePath}")
@Slf4j
public class PageController {
    @Autowired
    private FirstStepService firstStepService;

    @GetMapping("")
    public RedirectView redirect(
            RedirectAttributes attributes,
            @PathVariable String country,
            @PathVariable String pagePath,
            @RequestParam int cid,
            @RequestParam(defaultValue = "") String msisdn
    ) {
        attributes.addAttribute("url", "http://localhost:8080/" + country + "/" + pagePath + "/msisdn");
        attributes.addAttribute("cid", cid);
        attributes.addAttribute("msisdn", msisdn);
        return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/prepage.php");
    }

    @GetMapping("/msisdn")
    public RedirectView redirectMsisdn(
            RedirectAttributes attributes,
            @PathVariable String country,
            @PathVariable String pagePath,
            @RequestParam int cid,
            @RequestParam String tariff,
            @RequestParam(defaultValue = "") String msisdn
    ) {
        if (!Objects.equals(msisdn, "")) {
            return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/thanksyou.html");
        } else {
            attributes.addAttribute("url", "http://localhost:8080/" + country + "/" + pagePath + "/pin");
            attributes.addAttribute("cid", cid);
            attributes.addAttribute("tariff", tariff);
            attributes.addAttribute("token", "no");
            attributes.addAttribute("id", firstStepService.newFirstStep(cid, country, tariff));
            return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/enter_msisdn.php");
        }
    }

    @GetMapping("/pin")
    public RedirectView redirectPin(
            RedirectAttributes attributes,
            @PathVariable String country,
            @PathVariable String pagePath,
            @RequestParam String tariff,
            @RequestParam String token,
            @RequestParam String msisdn,
            @RequestParam int carrier,
            @RequestParam int id
    ) {
        String result = firstStepService.setFirstStep(id, msisdn, carrier);

        if (result.equals("correcto")) {
            attributes.addAttribute("url", "http://localhost:8080/" + country + "/" + pagePath + "/thanksyou");
            attributes.addAttribute("tariff", tariff);
            attributes.addAttribute("token", token);
            attributes.addAttribute("id", id);
            return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/pin.php");
        } else {
            attributes.addAttribute("url", "http://localhost:8080/" + country + "/" + pagePath + "/pin");
            attributes.addAttribute("tariff", tariff);
            attributes.addAttribute("token", token);
            attributes.addAttribute("id", id);
            attributes.addAttribute("error", "Invalid MSISDN");
            return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/enter_msisdn.php");
        }
    }

    @GetMapping("/thanksyou")
    public RedirectView redirectThanksyou(
            RedirectAttributes attributes,
            @PathVariable String country,
            @PathVariable String pagePath,
            @RequestParam int id,
            @RequestParam int pin,
            @RequestParam String tariff,
            @RequestParam String token
    ) {
        if (firstStepService.tryPin(id, pin)) {
            RestTemplate restTemplate = new RestTemplate();
            Gson gson = new Gson();

            FirstStepDTO firstStepDTO = new FirstStepDTO();
            firstStepDTO.setId(id);
            firstStepDTO.setId_campaing(firstStepService.getCid(id));
            firstStepDTO.setSubscription_id(1);
            firstStepDTO.setState("active");
            firstStepDTO.setOffer_id(1);
            firstStepDTO.setOffer_name("Gametime " + tariff);
            firstStepDTO.setCharged(1);
            firstStepDTO.setMsisdn(firstStepService.getMsisdn(id));

            String data = gson.toJson(firstStepDTO);

            restTemplate.postForEntity("http://localhost:8081/notification/" + country, data, String.class);
            log.info("Notification sent to " + country + " with data: " + data);

            return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/thanksyou.html");
        } else {
            attributes.addAttribute("url", "http://localhost:8080/" + country + "/" + pagePath + "/thanksyou");
            attributes.addAttribute("tariff", tariff);
            attributes.addAttribute("token", token);
            attributes.addAttribute("id", id);
            attributes.addAttribute("error", "Incorrect PIN");
            return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/pin.php");
        }
    }
}
