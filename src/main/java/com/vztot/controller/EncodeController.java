package com.vztot.controller;

import com.vztot.model.dto.EncodeRequestDto;
import com.vztot.model.dto.EncodeResponseDto;
import com.vztot.model.mapper.EncodeMapper;
import com.vztot.service.CryptoService;
import com.vztot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/encode")
@RestController
@AllArgsConstructor
public class EncodeController {
    private final UserService userService;
    private final CryptoService cryptoService;
    private final EncodeMapper mapper;

    @PostMapping
    @SneakyThrows
    private EncodeResponseDto handlePost(@RequestBody EncodeRequestDto request) {
        return mapper.buildResponseDto(cryptoService.encrypt(userService.getUserFioById(request.getId())));
    }

    @GetMapping
    private String handleGet() {
        return "Please use POST-request.\n BODY example:{\"id\": 1}";
    }
}
