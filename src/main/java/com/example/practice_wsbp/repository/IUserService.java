package com.example.practice_wsbp.repository;

import com.example.practice_wsbp.data.AuthUser;

import java.util.List;

public interface IUserService {

    public void registerUser(String userName, String userPass);

    public void removeUser(String userName);

    // 中略

    /**
     * ユーザ名とパスワードの一覧を、AuthUser型のリストで検索する
     *
     * @return AuthUser型のListインスタンス
     */
    public List<AuthUser> findAuthUsers();

    /**
     * ユーザ名とパスワードをデータベースに照合する
     *
     * @param userName ユーザー名
     * @param userPass パスワード
     * @return 照合成功であれば<code>true</code>, 照合失敗は<code>false</code>
     */
    public boolean existsUser(String userName, String userPass);

}
