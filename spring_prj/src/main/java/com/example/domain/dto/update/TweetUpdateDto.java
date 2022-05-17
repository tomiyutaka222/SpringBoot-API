package com.example.domain.dto.update;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetUpdateDto {
    // ツイートのID
    private Optional<Integer> id;

    // ツイートの文章
    private Optional<String> tweetText;

    // 投稿したアカウントのID
    private Optional<String> accountId;
}
