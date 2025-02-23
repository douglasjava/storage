package com.montreal.storage.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Storage API")
@RequestMapping(value = "/api/storage/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IStorageApi {

}
