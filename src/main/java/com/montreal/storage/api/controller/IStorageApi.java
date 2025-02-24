package com.montreal.storage.api.controller;

import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Storage API")
@RequestMapping(value = "/api/storage/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IStorageApi {

    @Operation(summary = "Faz upload de um arquivo para o Azure Storage")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<StorageResponse> uploadFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart("metadata") StorageRequest request
    );

    @Operation(summary = "Obtém informações de um arquivo pelo ID")
    @GetMapping("/{id}")
    ResponseEntity<StorageResponse> getFile(@PathVariable("id") String id);

    @Operation(summary = "Deleta um arquivo do Azure Storage pelo ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteFile(@PathVariable("id") String id);

}
