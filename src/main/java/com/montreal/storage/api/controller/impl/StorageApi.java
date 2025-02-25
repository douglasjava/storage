package com.montreal.storage.api.controller.impl;

import com.montreal.storage.api.controller.IStorageApi;
import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import com.montreal.storage.api.domain.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
public class StorageApi implements IStorageApi {

    private final StorageService service;

    @Override
    public StorageResponse uploadFile(MultipartFile file, StorageRequest request) {
        return service.uploadFile(file, request);
    }

    @Override
    public StorageResponse getFile(String id) {
        return service.getFile(id);
    }

    @Override
    public void deleteFile(String id) {
        service.deleteFile(id);
    }

}