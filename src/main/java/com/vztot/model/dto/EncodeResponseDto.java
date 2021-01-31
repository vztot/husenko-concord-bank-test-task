package com.vztot.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EncodeResponseDto {
    @JsonProperty("fio_encr")
    String fioEncrypted;
}
