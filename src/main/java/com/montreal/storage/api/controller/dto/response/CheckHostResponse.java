package com.montreal.storage.api.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckHostResponse {

    @Schema(description = "HostAddress")
    private String hostAddress;

    @Schema(description = "Data/Hora")
    private LocalDateTime dateTime;

    @Schema(description = "HostName")
    private String hostName;

    @Schema(description = "Version")
    private String version;

    @Schema(description = "Profile")
    private String profile;

}
