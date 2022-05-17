package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.domain.dto.create.TweetCreateDto;
import com.example.domain.dto.update.TweetUpdateDto;
import com.example.domain.service.impl.TweetService;
import com.example.infrastructure.entity.TweetEntity;

/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("tweet")
@CrossOrigin
public class TweetController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    TweetService tweetService;

    /**
     * アカウント情報を全件取得します
     * 
     * @return List<TweetEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TweetEntity> getAll() {
        return tweetService.getAll();
    }

    /**
     * アカウント情報を全件取得します
     * 
     * @return List<TweetEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    public TweetEntity findById(@RequestParam("id") int id) {
        return tweetService.findById(id);
    }

    /**
     * 
     * 
     * @param userName
     * @return アカウントデータリスト
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<TweetEntity> searchAccountByName(@RequestParam("accountName") String userName) {
        return tweetService.getTweetByTweetText(userName);
    }

    /**
     * アカウント情報を全件取得します
     * 
     * @param tweetString
     * @return void
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public void storeTweet(@RequestBody TweetCreateDto postParam) {
        tweetService.storeTweet(postParam);
    }

    /**
     * ツイート情報を削除します
     * 
     * @param id
     * @return アカウントデータリスト
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteTweet(@RequestParam("id") int id) {
        tweetService.deleteTweet(id);
    }

    /**
     * ツイート情報を更新します
     * 
     * @param postParam
     * @return void
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateTweet(@RequestBody TweetUpdateDto postParam) {
        tweetService.updateTweet(postParam);
    }
}
