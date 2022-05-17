package com.example.domain.service;

import java.util.List;

public interface ServiceInterFace<T> {

    /**
     * 全てのデータを取得し、返却します
     * 
     * @return T データ
     */
    public List<T> getAll();

    /**
     * IDからデータを取得し、返却します
     * 
     * @return データ
     */
    public T findById(int id);
}