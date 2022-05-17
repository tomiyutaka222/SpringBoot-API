package com.example.domain.dto.create;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageCreateDto {
    // メッセージID
    private Optional<Integer> id;

    // メッセージの表題
    private Optional<String> messageTitle;

    // メッセージの内容
    private Optional<String> messageDetail;

    // 登録ユーザ
    private Optional<String> submitAccount;
}
