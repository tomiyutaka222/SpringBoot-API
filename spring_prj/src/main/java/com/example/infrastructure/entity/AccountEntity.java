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
@Table(name = "account")
public class AccountEntity {
    // アカウントのID
    @Id
    @GeneratedValue
    private int accountId;

    // アカウントのメールアドレス
    @Column(nullable = false)
    private String email;

    // アカウントのパスワード
    @Column(nullable = false)
    private String password;

    // ユーザの名前
    @Column(nullable = false)
    private String userName;

    // ユーザの名前
    @Column(nullable = false)
    private String accountDetails;
}
