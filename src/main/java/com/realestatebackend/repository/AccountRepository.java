package com.realestatebackend.repository;

import com.realestatebackend.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer>, JpaSpecificationExecutor<AccountEntity> {

    Optional<AccountEntity> findAccountEntityById(Integer id);

}
