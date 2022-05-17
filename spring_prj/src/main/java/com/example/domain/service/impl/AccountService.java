package com.example.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import com.example.domain.dto.update.AccountUpdateDto;
import com.example.domain.dto.create.AccountCreateDto;
import com.example.domain.repository.AccountRepository;
import com.example.domain.service.ServiceInterFace;
import com.example.infrastructure.entity.AccountEntity;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class AccountService implements ServiceInterFace<AccountEntity> {

    // Beenからリポジトリの呼び出し
    @Autowired
    AccountRepository accountRepository;

    /**
     * アカウント情報を全て取得します
     * 
     * @return List<AccountEntity> アカウント情報リスト
     */
    public List<AccountEntity> getAll() {
        return accountRepository.findAll();
    }

    /**
     * IDからツイート情報を取得して返却します
     * 
     * @return TweetEntity ツイート情報
     */
    public AccountEntity findById(int id) {
        return accountRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("アカウントが存在しません。");
        });
    }

    /**
     * アカウント名からアカウント情報を検索します
     * 
     * @param userName 検索条件のアカウント名
     * @return
     */
    public List<AccountEntity> getAccountByName(String userName) {
        // アカウント情報をあいまい検索する
        return accountRepository.findByUserNameLike(userName);
    }

    /**
     * アカウントIDからアカウント情報を削除します
     * 
     * @param id
     */
    public void deleteAccount(int id) {
        AccountEntity account = accountRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("アカウントが存在しません。");
        });
        accountRepository.delete(account);
    }

    /**
     * アカウント情報を保存します
     * 
     * @param postParam アカウント情報リスト
     * @return void
     */
    public void storeAccount(AccountCreateDto postParam) {
        // 保存したいAcountEntityをリストに挿入
        List<AccountEntity> entities = Arrays.asList(
                new AccountEntity(
                        // アカウントのID
                        0,
                        // メールアドレス
                        postParam.getEmail().orElseThrow(() -> {
                            throw new RuntimeException("メールアドレスが入力されていません。");
                        }),
                        // パスワード
                        postParam.getPassword().orElseThrow(() -> {
                            throw new RuntimeException("パスワードが入力されていません。");
                        }),
                        // ユーザネーム
                        postParam.getUserName().orElseThrow(() -> {
                            throw new RuntimeException("ユーザ名が入力されていません。");
                        }),
                        // アカウント詳細
                        postParam.getAccountDetails().orElseThrow(() -> {
                            throw new RuntimeException("アカウント情報詳細が入力されていません。");
                        })));
        // アカウントデータを保存
        accountRepository.saveAll(entities);
    }

    public void updateAccount(AccountUpdateDto postParam) {
        // 保存したいAcountEntityをリストに挿入
        List<AccountEntity> entities = Arrays.asList(
                new AccountEntity(
                        // アカウントのID
                        postParam.getId().orElseThrow(() -> {
                            throw new RuntimeException("アカウント情報IDが指定されていません。");
                        }),
                        // メールアドレス
                        postParam.getEmail().orElseThrow(() -> {
                            throw new RuntimeException("メールアドレスが入力されていません。");
                        }),
                        // パスワード
                        postParam.getPassword().orElseThrow(() -> {
                            throw new RuntimeException("パスワードが入力されていません。");
                        }),
                        // ユーザネーム
                        postParam.getUserName().orElseThrow(() -> {
                            throw new RuntimeException("ユーザ名が入力されていません。");
                        }),
                        // アカウント詳細
                        postParam.getAccountDetails().orElseThrow(() -> {
                            throw new RuntimeException("アカウント情報詳細が入力されていません。");
                        })));
        // アカウントデータを保存
        accountRepository.saveAll(entities);
    }

}
