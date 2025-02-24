package com.montreal.storage.api.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageRequest {

    private String nameFile;
    private String typeFile;
    private String description;
    private Map<String, String> metadados;

}