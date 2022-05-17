package com.example.domain.dto.update;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageUpdateDto {
    // メッセージID
    private Optional<Integer> id;

    // メッセージの表題
    private Optional<String> messageTitle;

    // メッセージの内容
    private Optional<String> messageDetail;

    // 登録ユーザ
    private Optional<String> submitAccount;
}
