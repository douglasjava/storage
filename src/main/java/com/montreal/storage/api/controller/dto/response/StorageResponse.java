package com.montreal.storage.api.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageResponse {

    private String id;
    private String nomeArquivo;
    private String url;
    private String tipoArquivo;
    private String categoria;
    private Map<String, String> metadados;
    private LocalDateTime dataUpload;

}