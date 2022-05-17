package com.example.domain.dto.create;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アカウントの新規登録用DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateDto {
    // アカウントのメールアドレス
    private Optional<String> email;

    // アカウントのパスワード
    private Optional<String> password;

    // ユーザの名前
    private Optional<String> userName;

    // ユーザの名前
    private Optional<String> accountDetails;
}
