package com.example.domain.repository;

import java.util.List;

import com.example.infrastructure.entity.MessageEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * メッセージ情報EntityにアクセスするRepositoryクラス
 */
@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
    /**
     * メッセージ表題からメッセージ情報の検索を行う
     * 
     * @param userName
     */
    List<MessageEntity> findByMessageTitleLike(String messageTitle);
}