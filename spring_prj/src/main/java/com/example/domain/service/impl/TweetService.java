package com.example.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.dto.create.TweetCreateDto;
import com.example.domain.dto.update.TweetUpdateDto;
import com.example.domain.repository.TweetRepository;
import com.example.domain.service.ServiceInterFace;
import com.example.infrastructure.entity.TweetEntity;

import java.util.Arrays;
import java.util.List;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class TweetService implements ServiceInterFace<TweetEntity> {
    // Beanからリポジトリの呼び出し
    @Autowired
    TweetRepository tweetRepository;

    /**
     * ツイートを全取得して返却します
     * 
     * @return List<TweetEntity> ツイート情報リスト
     */
    public List<TweetEntity> getAll() {
        // ツイートを全取得する
        return tweetRepository.findAll();
    }

    /**
     * IDからツイート情報を取得して返却します
     * 
     * @return TweetEntity ツイート情報
     */
    public TweetEntity findById(int id) {
        // IDからツイートを取得する
        return tweetRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("ツイートが存在しません。");
        });
    }

    /**
     * ツイート内容からツイートを検索します
     * 
     * @param userName 検索条件のアカウント名
     * @return
     */
    public List<TweetEntity> getTweetByTweetText(String messageTitle) {
        // アカウント情報をあいまい検索する
        return tweetRepository.findByTweetTextLike(messageTitle);
    }

    /**
     * ツイートIDからツイートを削除します
     * 
     * @param id
     */
    public void deleteTweet(int id) {
        // IDからツイートを取得する
        TweetEntity account = tweetRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("ツイートが存在しません。");
        });
        // ツイート情報を削除する
        tweetRepository.delete(account);
    }

    /**
     * ツイートを保存します
     * 
     * @param String tweetString ツイート文字
     * @return void
     */
    public void storeTweet(TweetCreateDto postParam) {
        // ツイート情報リストを作成する
        List<TweetEntity> entities = Arrays.asList(
                new TweetEntity(
                        // PK オートインクリメントなので、0を指定
                        0,
                        // ツイート内容
                        postParam.getTweetText().orElseThrow(() -> {
                            throw new RuntimeException("ツイート情報が未入力です。");
                        }),
                        // 登録アカウントのID
                        postParam.getAccountId().orElseThrow(() -> {
                            throw new RuntimeException("アカウント情報IDが指定されていません。");
                        })));
        // アカウントデータを保存
        tweetRepository.saveAll(entities);
    }

    public void updateTweet(TweetUpdateDto postParam) {
        // ツイート情報リストを作成する
        List<TweetEntity> entities = Arrays.asList(
                new TweetEntity(
                        // ツイートID
                        postParam.getId().orElseThrow(() -> {
                            throw new RuntimeException("ツイートIDが指定されていません。");
                        }),
                        // ツイート本文
                        postParam.getTweetText().orElseThrow(() -> {
                            throw new RuntimeException("ツイート情報が未入力です。");
                        }),
                        // ツイートしたアカウントID
                        postParam.getAccountId().orElseThrow(() -> {
                            throw new RuntimeException("アカウント情報IDが指定されていません。");
                        })));
        // アカウントデータを保存
        tweetRepository.saveAll(entities);

    }
}
