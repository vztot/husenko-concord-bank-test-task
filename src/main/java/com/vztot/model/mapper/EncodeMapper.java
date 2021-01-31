package com.vztot.model.mapper;

import com.vztot.model.dto.EncodeResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EncodeMapper {
    public EncodeResponseDto buildResponseDto(String name) {
        EncodeResponseDto dto = new EncodeResponseDto();
        dto.setFioEncrypted(name);
        return dto;
    }
}
