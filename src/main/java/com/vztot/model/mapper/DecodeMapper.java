package com.vztot.model.mapper;

import com.vztot.model.dto.DecodeResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DecodeMapper {
    public DecodeResponseDto buildResponseDto(String name) {
        DecodeResponseDto dto = new DecodeResponseDto();
        dto.setFio(name);
        return dto;
    }
}
