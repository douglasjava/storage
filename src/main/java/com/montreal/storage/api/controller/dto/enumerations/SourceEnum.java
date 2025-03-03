package com.montreal.storage.api.controller.dto.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SourceEnum {

    COST_CENTER_BH("CENTRO DE CUSTO BH"),
    COST_CENTER_RJ("CENTRO DE CUSTO RJ");

    private final String description;

}
