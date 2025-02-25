package com.montreal.storage.api.controller;


import com.montreal.storage.api.controller.dto.response.CheckHostResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.UnknownHostException;

@Tag(name = "Health")
@RequestMapping(value = "/api/storage/v1/host-check", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IHostCheckApi {

    @GetMapping()
    CheckHostResponse checkHost() throws UnknownHostException;

}
