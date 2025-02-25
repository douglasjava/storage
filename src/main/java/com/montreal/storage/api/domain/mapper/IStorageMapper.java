package com.montreal.storage.api.domain.mapper;

import com.montreal.storage.api.controller.dto.request.StorageRequest;
import com.montreal.storage.api.controller.dto.response.StorageResponse;
import com.montreal.storage.api.domain.entity.Storage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IStorageMapper {

    IStorageMapper INSTANCE = Mappers.getMapper(IStorageMapper.class);

    StorageResponse toStorageResponse(Storage storage);

    Storage toStorage(StorageRequest storageRequest);

}
