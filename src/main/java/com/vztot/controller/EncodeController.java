package com.vztot.controller;

import com.vztot.model.dto.EncodeRequestDto;
import com.vztot.model.dto.EncodeResponseDto;
import com.vztot.model.mapper.EncodeMapper;
import com.vztot.service.CryptoService;
import com.vztot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RequestMapping("/encode")
@RestController
@AllArgsConstructor
public class EncodeController {
    private final UserService userService;
    private final CryptoService cryptoService;
    private final EncodeMapper mapper;

    @PostMapping
    private EncodeResponseDto handlePost(@RequestBody EncodeRequestDto request) throws BadPaddingException,
            InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException,
            NoSuchPaddingException, InvalidKeyException {
        return mapper.buildResponseDto(cryptoService.encrypt(userService.getUserFioById(request.getId())));
    }

    @GetMapping
    private String handleGet() {
        return "Please use POST-request.\n BODY example:{\"id\": 1}";
    }
}
