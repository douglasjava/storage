package com.montreal.storage.api.domain.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "azure.storage")
public class StorageProperties {

    private String connectionUrl;
    private String containerName;
    private String sasToken;

}
