package com.montreal.storage.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;


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
    private Map<String, String> metadata;
    private String url;
    private LocalDateTime dataUpload;

}