package com.montreal.storage.api.domain.service;

import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import com.montreal.storage.api.domain.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository repository;

    public StorageResponse uploadFile(MultipartFile file, StorageRequest request) {
        return null;
    }

    public StorageResponse getFile(String id) {
        return null;
    }

    public void deleteFile(String id) {

        repository.deleteById(id);

    }

}
