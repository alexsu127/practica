package com.example.landing.controller;

import com.example.landing.service.FirstStepService;
import com.example.landing.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/{country}/{pagePath}")
public class PageController {
    @Autowired
    private FirstStepService firstStepService;

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("")
    public RedirectView redirect(
            RedirectAttributes attributes,
            @PathVariable String country,
            @PathVariable String pagePath,
            @RequestParam int cid
    ) {
        attributes.addAttribute("url", "http://localhost:8080/" + country + "/" + pagePath + "/msisdn");
        attributes.addAttribute("cid", cid);
        return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/prepage.php");
    }

    @GetMapping("/msisdn")
    public RedirectView redirectMism(
            RedirectAttributes attributes,
            @PathVariable String country,
            @PathVariable String pagePath,
            @RequestParam int cid,
            @RequestParam String tariff
    ) {
        attributes.addAttribute("url", "http://localhost:8080/" + country + "/" + pagePath + "/pin");
        attributes.addAttribute("cid", cid);
        attributes.addAttribute("tariff", tariff);
        attributes.addAttribute("token", "no");
        attributes.addAttribute("id", firstStepService.newFirstStep(cid, country, tariff));
        return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/enter_msisdn.php");
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
        } else if (result.equals("repetido")) {
            return new RedirectView("http://localhost/" + country + "/lp/" + pagePath + "/thanksyou.html");
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
            subscriptionService.newSubscription(id);
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
