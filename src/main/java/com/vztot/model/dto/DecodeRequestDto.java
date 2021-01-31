package com.vztot.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DecodeRequestDto {
    @JsonProperty("fio_encr")
    String fioEncrypted;
}
