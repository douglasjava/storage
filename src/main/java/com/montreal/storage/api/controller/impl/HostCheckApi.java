package com.montreal.storage.api.controller.impl;

import com.montreal.storage.api.controller.IHostCheckApi;
import com.montreal.storage.api.dto.response.CheckHostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
@Component
@RequiredArgsConstructor
public class HostCheckApi implements IHostCheckApi {

    private final Environment environment;

    @Value("${storage.api.version}")
    public String version;

    @Override
    public CheckHostResponse checkHost() throws UnknownHostException {
        String activeProfiles = String.join(",", environment.getActiveProfiles());

        return CheckHostResponse.builder()
                .hostAddress( InetAddress.getLocalHost().getHostAddress())
                .dateTime(LocalDateTime.now())
                .hostName(InetAddress.getLocalHost().getHostName())
                .version(version)
                .profile(activeProfiles)
                .build();

    }

}