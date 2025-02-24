package com.montreal.storage.api.controller.impl;

import com.montreal.storage.api.controller.IStorageApi;
import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
public class StorageApi implements IStorageApi {


    @Override
    public ResponseEntity<StorageResponse> uploadFile(MultipartFile file, StorageRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<StorageResponse> getFile(String id) {
        return null;
    }

    @Override
    public void deleteFile(String id) {

    }

}