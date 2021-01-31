package com.vztot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class DefaultController {
    private static final String INFO_MESSAGE = "Please send requests to /encode or /decode endpoints.";

    @PostMapping
    private String handlePost() {
        return INFO_MESSAGE;
    }

    @GetMapping
    private String handleGet() {
        return INFO_MESSAGE;
    }
}
