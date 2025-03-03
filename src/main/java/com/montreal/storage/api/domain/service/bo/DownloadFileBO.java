package com.montreal.storage.api.domain.service.bo;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.InputStreamResource;

@Data
@Builder
public class DownloadFileBO {

    private InputStreamResource inputStreamResource;
    private String nameFile;

}
