package com.montreal.storage.api.controller.impl;

import com.montreal.storage.api.controller.IStorageApi;
import com.montreal.storage.api.controller.dto.enumerations.SourceEnum;
import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import com.montreal.storage.api.domain.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.montreal.storage.api.AppConstants.ATTACHMENT_FILENAME;


@RestController
@RequiredArgsConstructor
public class StorageApi implements IStorageApi {

    private final StorageService service;

    @Override
    public StorageResponse uploadFile(MultipartFile file, String nameFile, String typeFile,
                                      String description, SourceEnum source, String product) {

        var storageRequest = StorageRequest.builder()
                .nameFile(nameFile)
                .typeFile(typeFile)
                .description(description)
                .source(source)
                .product(product)
                .build();

        return service.uploadFile(file, storageRequest);

    }

    @Override
    public StorageResponse getFile(String id) {
        return service.getFile(id);
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String id) {

        var downloadFileBO = service.downloadFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILENAME + downloadFileBO.getNameFile())
                .body(downloadFileBO.getInputStreamResource());

    }

    @Override
    public void deleteFile(String id) {
        service.deleteFile(id);
    }

}