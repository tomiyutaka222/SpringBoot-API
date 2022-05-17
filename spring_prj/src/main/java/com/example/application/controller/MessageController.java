package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.domain.dto.create.MessageCreateDto;
import com.example.domain.dto.update.MessageUpdateDto;
import com.example.domain.service.impl.MessageService;
import com.example.infrastructure.entity.MessageEntity;

/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("message")
@CrossOrigin
public class MessageController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    MessageService messageService;

    /**
     * アカウント情報を全件取得します
     * 
     * @return List<MessageEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<MessageEntity> getAll() {
        return messageService.getAll();
    }

    /**
     * アカウント情報を全件取得します
     * 
     * @return List<TweetEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    public MessageEntity findById(@RequestParam("id") int id) {
        return messageService.findById(id);
    }

    /**
     * メッセージ表題からメッセージ情報を取得します
     * 
     * @param messageTitle メッセージの表題
     * @return メッセージ情報リスト
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<MessageEntity> searchMessageByMessageTitle(@RequestParam("accountName") String messageTitle) {
        return messageService.getMessageByMessageTitle(messageTitle);
    }

    /**
     * メッセージを登録する
     * 
     * @param postParam アカウント情報
     * @return void
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public void storeMessage(@RequestBody MessageCreateDto postParam) {
        messageService.storeMessage(postParam);
    }

    /**
     * メッセージIDからメッセージを削除する
     * 
     * @param id
     * @return アカウントデータリスト
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteMessage(@RequestParam("id") int id) {
        messageService.deleteMessage(id);
    }

    /**
     * アカウント情報を更新します
     * 
     * @param postParam
     * @return void
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateMessage(@RequestBody MessageUpdateDto postParam) {
        messageService.updateMessage(postParam);
    }
}
