package com.montreal.storage.api.controller.dto.request;

import com.montreal.storage.api.controller.dto.enumerations.SourceEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageRequest {

    @Schema(description = "Nome do arquivo", example = "arquivo.txt")
    private String nameFile;

    @Schema(description = "Tipo do arquivo", example = "txt")
    private String typeFile;

    @Schema(description = "Descrição do arquivo", example = "Arquivo de texto")
    private String description;

    @Schema(description = "Origem do arquivo", example = "COST_CENTER")
    private SourceEnum source;

    @Schema(description = "Produto do arquivo", example = "Produto A")
    private String product;

}