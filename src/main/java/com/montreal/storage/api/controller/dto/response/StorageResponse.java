package com.montreal.storage.api.controller.dto.response;

import com.montreal.storage.api.controller.dto.enumerations.SourceEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageResponse {

    private String id;
    private String nameFile;
    private String url;
    private String typeFile;
    private String description;
    private SourceEnum source;
    private String product;
    private LocalDateTime dataUpload;

}