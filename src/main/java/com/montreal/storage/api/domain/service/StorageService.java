package com.montreal.storage.api.domain.service;

import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import com.montreal.storage.api.domain.exceptions.InternalErrorException;
import com.montreal.storage.api.domain.exceptions.NotFoundException;
import com.montreal.storage.api.domain.exceptions.StorageClientException;
import com.montreal.storage.api.domain.mapper.IStorageMapper;
import com.montreal.storage.api.domain.repository.StorageRepository;
import com.montreal.storage.api.domain.service.bo.DownloadFileBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository repository;
    private final StorageClient storageClient;

    public StorageResponse uploadFile(MultipartFile file, StorageRequest request) {

        try {

            log.info("Enviado arquivo: {}", request.getNameFile());
            var blobUrl = storageClient.uploadFile(file, request);

            log.info("Arquivo enviado com sucesso");

            var storage = IStorageMapper.INSTANCE.toStorage(request);
            storage.setUrl(blobUrl);
            storage.setDataUpload(LocalDateTime.now());

            var storageSaved = repository.save(storage);

            log.info("Arquivo salvo com ID: {}", storageSaved.getId());

            return IStorageMapper.INSTANCE.toStorageResponse(storageSaved);

        } catch (StorageClientException e) {
            throw e;

        } catch (Exception e) {
            log.error("Falha ao enviar arquivo: {}", request.getNameFile());
            throw new InternalErrorException("Falha ao enviar arquivo", e);
        }

    }

    public StorageResponse getFile(String id) {

        return repository.findById(id)
                .map(IStorageMapper.INSTANCE::toStorageResponse)
                .orElseThrow(() -> new NotFoundException(String.format("Arquivo %s não encontrado", id)));
    }

    public DownloadFileBO downloadFile(String id) {
        log.info("Baixando arquivo com ID: {}", id);

        try {

            var storage = getFile(id);

            var file = storageClient.downloadFile(storage.getUrl());

            var downloadFileBO = DownloadFileBO.builder()
                    .inputStreamResource(new InputStreamResource(new FileInputStream(file)))
                    .nameFile(storage.getNameFile())
                    .build();

            log.info("Marca arquivo para exclusão após o uso");
            file.deleteOnExit();

            log.info("Arquivo baixado com sucesso");

            return downloadFileBO;

        } catch (StorageClientException e) {
            throw e;

        } catch (Exception e) {
            log.error("Falha ao baixar arquivo com ID: {}", id);
            throw new InternalErrorException("Falha ao baixar arquivo", e);
        }

    }

    public void deleteFile(String id) {

        log.info("Deletando arquivo com ID: {}", id);

        repository.deleteById(id);

    }

}
