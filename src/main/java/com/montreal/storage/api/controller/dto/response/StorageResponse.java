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
    private String nameFile;
    private String url;
    private String typeFile;
    private Map<String, String> metadata;
    private LocalDateTime dataUpload;

}