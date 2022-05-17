package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.domain.dto.update.AccountUpdateDto;
import com.example.domain.dto.create.AccountCreateDto;
import com.example.domain.service.impl.AccountService;
import com.example.infrastructure.entity.AccountEntity;

/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("account")
@CrossOrigin
public class AccountController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    AccountService accountService;

    /**
     * アカウント情報を全件取得します
     * 
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AccountEntity> getAll() {
        return accountService.getAll();
    }

    /**
     * アカウント情報を全件取得します
     * 
     * @return List<TweetEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    public AccountEntity findById(@RequestParam("id") int id) {
        return accountService.findById(id);
    }

    /**
     * ユーザ名からアカウントデータを検索します。
     * 
     * @param userName
     * @return アカウントデータリスト
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<AccountEntity> searchAccountByName(@RequestParam("accountName") String userName) {
        return accountService.getAccountByName(userName);
    }

    /**
     * アカウント情報を削除します
     * 
     * @param id
     * @return アカウントデータリスト
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAccount(@RequestParam("id") int id) {
        accountService.deleteAccount(id);
    }

    /**
     * アカウント情報を全件取得します
     * 
     * @param postParam
     * @return void
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public void storeTweet(@RequestBody AccountCreateDto postParam) {
        accountService.storeAccount(postParam);
    }

    /**
     * アカウント情報を更新します
     * 
     * @param postParam
     * @return void
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateAccount(@RequestBody AccountUpdateDto postParam) {
        accountService.updateAccount(postParam);
    }
}
