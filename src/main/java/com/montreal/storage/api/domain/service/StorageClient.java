package com.montreal.storage.api.domain.service;

import com.azure.storage.blob.BlobServiceClientBuilder;
import com.montreal.storage.api.domain.exceptions.StorageClientException;
import com.montreal.storage.api.domain.properties.StorageProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class StorageClient {

    private final StorageProperties storageProperties;

    public String uploadFile(MultipartFile file) {

        try {

            log.info("Enviando arquivo para o repositorio azure");

            var blobServiceClient = new BlobServiceClientBuilder()
                    .connectionString(storageProperties.getConnectionUrl())
                    .buildClient();

            var containerClient = blobServiceClient.getBlobContainerClient(storageProperties.getContainerName());

            var fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            var blobClient = containerClient.getBlobClient(fileName);

            blobClient.upload(file.getInputStream(), file.getSize(), true);

            return blobClient.getBlobUrl();

        } catch (Exception e) {
            throw new StorageClientException("Falha ao enviar arquivo para o repositorio azure", e);
        }

    }

}

