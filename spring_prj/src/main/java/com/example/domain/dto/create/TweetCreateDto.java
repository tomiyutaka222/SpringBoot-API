package com.example.domain.dto.create;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ツイートの新規登録用DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetCreateDto {
    // ツイートのID
    private Optional<Integer> tweetId;

    // ツイートの文章
    private Optional<String> tweetText;

    // 投稿したアカウントのID
    private Optional<String> accountId;
}
