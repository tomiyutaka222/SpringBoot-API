package com.example.domain.dto.update;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アカウントの更新用DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateDto {
    // ID
    private Optional<Integer> id;

    // アカウントのメールアドレス
    private Optional<String> email;

    // アカウントのパスワード
    private Optional<String> password;

    // ユーザの名前
    private Optional<String> userName;

    // ユーザの名前
    private Optional<String> accountDetails;
}
