package com.montreal.storage.api.domain.entity;

import com.montreal.storage.api.controller.dto.enumerations.SourceEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "storage")
public class Storage {

    @Id
    private String id;

    private String nameFile;
    private String typeFile;
    private String description;
    private SourceEnum source;
    private String product;
    private String url;
    private LocalDateTime dataUpload;

}