package com.vztot.controller;

import com.vztot.model.dto.DecodeRequestDto;
import com.vztot.model.dto.DecodeResponseDto;
import com.vztot.model.mapper.DecodeMapper;
import com.vztot.service.CryptoService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/decode")
@RestController
@AllArgsConstructor
public class DecodeController {
    private final CryptoService cryptoService;
    private final DecodeMapper mapper;

    @PostMapping
    @SneakyThrows
    private DecodeResponseDto handlePost(@RequestBody DecodeRequestDto request) {
        return mapper.buildResponseDto(cryptoService.decrypt(request.getFioEncrypted()));
    }

    @GetMapping
    private String handleGet() {
        return "Please use POST-request.\n BODY example:{\"fio_encr\": \"ybhyXTGXBFM99u5m1EZ4Mg==\"}";
    }
}
