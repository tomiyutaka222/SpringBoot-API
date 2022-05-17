package com.example.domain.repository;

import java.util.List;

import com.example.infrastructure.entity.AccountEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * アカウント情報EntityにアクセスするRepositoryクラス
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    /**
     * ユーザ名検索を行う
     * 
     * @param userName
     */
    List<AccountEntity> findByUserNameLike(String userName);
}