package com.example.domain.repository;

import java.util.List;

import com.example.infrastructure.entity.TweetEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ツイート情報EntityにアクセスするRepositoryクラス
 */
@Repository
public interface TweetRepository extends JpaRepository<TweetEntity, Integer> {
    /**
     * ツイート内容からツイート情報の検索を行う
     * 
     * @param userName
     */
    List<TweetEntity> findByTweetTextLike(String tweetText);
}