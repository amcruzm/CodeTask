package com.example.anagramcheckerapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AnagramCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnagramCheckerApplication.class, args);
    }
}
@RestController
class AnagramController {

    @GetMapping("/anagrams")
    public ResponseEntity<Boolean> checkAnagrams(
            @RequestParam String text1,
            @RequestParam String text2
    ) {
        boolean areAnagrams = AnagramChecker.areAnagrams(text1, text2);
        return ResponseEntity.ok(areAnagrams);
    }
}

