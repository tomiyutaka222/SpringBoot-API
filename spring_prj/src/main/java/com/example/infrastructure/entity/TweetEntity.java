package com.example.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * アカウントの情報を永続化するEntity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tweet")
public class TweetEntity {
    // ツイートのID
    @Id
    @GeneratedValue
    private int tweetId;

    // ツイートの文章
    @Column(nullable = false)
    private String tweetText;

    @Column(nullable = false)
    // 投稿したアカウントのID
    private String accountId;
}
