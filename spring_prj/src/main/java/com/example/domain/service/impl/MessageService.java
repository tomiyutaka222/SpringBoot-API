package com.example.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import com.example.domain.dto.create.MessageCreateDto;
import com.example.domain.dto.update.MessageUpdateDto;
import com.example.domain.repository.MessageRepository;
import com.example.domain.service.ServiceInterFace;
import com.example.infrastructure.entity.MessageEntity;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class MessageService implements ServiceInterFace<MessageEntity> {

    // Beenからリポジトリの呼び出し
    @Autowired
    MessageRepository messageRepository;

    /**
     * メッセージを全て取得して返却します
     * 
     * @return List<MessageEntity> アカウント情報リスト
     */
    public List<MessageEntity> getAll() {
        // メッセージを全取得する
        return messageRepository.findAll();
    }

    /**
     * IDからメッセージ情報を取得して返却します
     * 
     * @return TweetEntity メッセージ情報リスト
     */
    public MessageEntity findById(int id) {
        // IDからメッセージを検索
        return messageRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("メッセージが存在しません。");
        });
    }

    /**
     * メッセージの表題からメッセージを検索します
     * 
     * @param messageTitle メッセージのタイトル
     * @return メッセージ情報リスト
     */
    public List<MessageEntity> getMessageByMessageTitle(String messageTitle) {
        // メッセージ情報をあいまい検索する
        return messageRepository.findByMessageTitleLike(messageTitle);
    }

    /**
     * IDからメッセージを削除します
     * 
     * @param id メッセージのID
     */
    public void deleteMessage(int id) {
        // IDからメッセージを検索
        MessageEntity account = messageRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("メッセージが存在しません。");
        });
        // 対象メッセージを削除
        messageRepository.delete(account);
    }

    /**
     * メッセージを保存します
     * 
     * @param postParam メッセージ情報
     * @return void
     */
    public void storeMessage(MessageCreateDto postParam) {
        // メッセージ情報リストを作成する
        List<MessageEntity> entities = Arrays.asList(
                new MessageEntity(
                        // メッセージのID
                        // オートインクリメントされるので0で固定
                        0,
                        // メッセージ表題
                        postParam.getMessageTitle().orElseThrow(() -> {
                            throw new RuntimeException("メッセージのタイトルが入力されていません。");
                        }),
                        // メッセージ内容
                        postParam.getMessageDetail().orElseThrow(() -> {
                            throw new RuntimeException("メッセージの本文が入力されていません。");
                        }),
                        // 登録アカウント
                        postParam.getSubmitAccount().orElseThrow(() -> {
                            throw new RuntimeException("アカウント情報IDが指定されていません。");
                        })));
        // メッセージデータを保存
        messageRepository.saveAll(entities);
    }

    public void updateMessage(MessageUpdateDto postParam) {
        // メッセージ情報リストを作成する
        List<MessageEntity> entities = Arrays.asList(
                new MessageEntity(
                        // メッセージのID
                        postParam.getId().orElseThrow(() -> {
                            throw new RuntimeException("メッセージIDが指定されていません。");
                        }),
                        // メッセージ表題
                        postParam.getMessageTitle().orElseThrow(() -> {
                            throw new RuntimeException("メッセージのタイトルが入力されていません。");
                        }),
                        // メッセージ内容
                        postParam.getMessageDetail().orElseThrow(() -> {
                            throw new RuntimeException("メッセージの本文が入力されていません。");
                        }),
                        // 登録アカウント
                        postParam.getSubmitAccount().orElseThrow(() -> {
                            throw new RuntimeException("アカウント情報IDが指定されていません。");
                        })));
        // メッセージデータを保存
        messageRepository.saveAll(entities);

    }
}
