package com.montreal.storage.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Schema(name = "Problema")
@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problem {

    @Schema(example = "400")
    private Integer status;

    @Schema(example = "https://montreal.com.br/dados-invalidos")
    private String type;

    @Schema(example = "Dados inválidos")
    private String title;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    private String detail;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    private String userMessage;

    @Schema(example = "2019-12-01T18:09:02.70844Z")
    private OffsetDateTime timestamp;

    @Schema(name = "Lista de objetos ou campos que geraram o erro (opcional)")
    private List<Object> objects;

    @Schema(name = "ObjetoProblema")
    @Getter
    @Builder
    public static class Object {

        @Schema(example = "telefone")
        private String name;

        @Schema(example = "O telefone é obrigatório")
        private String userMessage;

    }

}