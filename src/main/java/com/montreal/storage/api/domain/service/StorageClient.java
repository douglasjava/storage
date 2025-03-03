package com.montreal.storage.api.domain.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobProperties;
import com.azure.storage.blob.models.BlobServiceProperties;
import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.domain.exceptions.StorageClientException;
import com.montreal.storage.api.domain.properties.StorageProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class StorageClient {

    private final StorageProperties storageProperties;

    public String uploadFile(MultipartFile file, StorageRequest request) {

        try {

            log.info("Enviando arquivo para o repositorio azure");

            var blobServiceClient = new BlobServiceClientBuilder()
                    .endpoint(storageProperties.getConnectionUrl())
                    .sasToken(storageProperties.getSasToken())
                    .buildClient();

            var containerClient = blobServiceClient.getBlobContainerClient(storageProperties.getContainerName());

            var fileName = String.format("%s/%s/%s", request.getSource().name(), request.getProduct().toUpperCase(),
                    request.getNameFile().toUpperCase());

            var blobClient = containerClient.getBlobClient(fileName);

            blobClient.upload(file.getInputStream(), file.getSize(), true);

            return blobClient.getBlobUrl();

        } catch (Exception e) {
            throw new StorageClientException(String.format("Falha ao enviar arquivo para o repositorio azure - %s", e.getMessage()), e);
        }

    }

    public File downloadFile(String blobUrl) {

        log.info("Recuperando arquivo do repositório Azure");

        try {

            var blobClient = new BlobClientBuilder()
                    .endpoint(blobUrl)
                    .sasToken(storageProperties.getSasToken())
                    .buildClient();

            BlobProperties properties = blobClient.getProperties();
            String fileName = properties.getMetadata().getOrDefault("filename", "arquivo_baixado");

            File tempFile = File.createTempFile(fileName, ".tmp");

            log.info("Arquivo temporário criado: {}", tempFile.getAbsolutePath());
            try (OutputStream outputStream = new FileOutputStream(tempFile)) {
                blobClient.downloadStream(outputStream);
            }

            return tempFile;

        } catch (IOException e) {
            throw new StorageClientException(String.format("Falha ao criar arquivo temporário para %s - %s", blobUrl, e.getMessage()), e);

        } catch (Exception e) {
            throw new StorageClientException(String.format("Falha ao recuperar arquivo %s do repositório Azure - %s", blobUrl, e.getMessage()), e);

        }
    }
}