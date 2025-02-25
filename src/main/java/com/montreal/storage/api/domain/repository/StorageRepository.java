package com.montreal.storage.api.domain.repository;

import com.montreal.storage.api.domain.entity.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends MongoRepository<Storage, String> {
}
