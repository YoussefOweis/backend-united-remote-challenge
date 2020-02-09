package com.oweisyoussef.unitedremotebackendtest.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageDetailsController {
    @Autowired
    LanguageDetailsService languageDetailsService;

    @RequestMapping("/languages")
    public List<LanguageDetails> getAllLanguageDetails()
    {
        return languageDetailsService.getAllLanguageDetails();
    }

    @RequestMapping("/languages/{language}")
    public LanguageDetails getLanguageDetails(@PathVariable String Language)
    {
        return languageDetailsService.getLanguageDetails(Language);
    }

}
