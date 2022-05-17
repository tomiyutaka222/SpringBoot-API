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
@Table(name = "message")
public class MessageEntity {
    // メッセージのID
    @Id
    @GeneratedValue
    private int id;

    // メッセージの表題
    @Column(nullable = false)
    private String messageTitle;

    // メッセージの内容
    @Column(nullable = false)
    private String messageDetail;

    // 登録ユーザ
    @Column(nullable = false)
    private String submitAccount;
}
