package com.montreal.storage.api.domain.service;

import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import com.montreal.storage.api.domain.exceptions.InternalErrorException;
import com.montreal.storage.api.domain.exceptions.NotFoundException;
import com.montreal.storage.api.domain.mapper.IStorageMapper;
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
    private final StorageClient storageClient;

    public StorageResponse uploadFile(MultipartFile file, StorageRequest request) {

        try {

            log.info("Enviado arquivo: {}", request.getNameFile());
            var blobUrl = storageClient.uploadFile(file);

            log.info("Arquivo enviado com sucesso");

            var storage = IStorageMapper.INSTANCE.toStorage(request);
            storage.setUrl(blobUrl);

            var storageSaved = repository.save(storage);

            log.info("Arquivo salvo com ID: {}", storageSaved.getId());

            return IStorageMapper.INSTANCE.toStorageResponse(storageSaved);

        } catch (Exception e) {
            log.error("Falha ao enviar arquivo: {}", request.getNameFile());
            throw new InternalErrorException("Falha ao enviar arquivo", e);
        }

    }

    public StorageResponse getFile(String id) {

        return repository.findById(id)
                .map(IStorageMapper.INSTANCE::toStorageResponse)
                .orElseThrow(() -> {
                    log.error("Arquivo com ID: {} não encontrado", id);
                    return new NotFoundException(String.format("Arquivo %s não encontrado", id));
                });


    }

    public void deleteFile(String id) {

        log.info("Deletando arquivo com ID: {}", id);

        repository.deleteById(id);

    }

}
