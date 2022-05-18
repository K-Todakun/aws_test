package com.example.practice_wsbp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;

import org.apache.wicket.model.Model;

import org.apache.wicket.spring.injection.annot.SpringBean;
import com.example.practice_wsbp.repository.IUserService;

@MountPath("UserMaker")
public class UserMakerPage extends WebPage{

    //IUserService を IoC/DI する
    @SpringBean
    private IUserService userService;

    public UserMakerPage() {

        var userNameModel = Model.of("");
        var userPassModel = Model.of("");

        // 前回の課題の部分
        var toUserMakerLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toUserMakerLink);

        var userInfoForm = new Form<Void>("userInfo"){
            @Override
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                var userPass = userPassModel.getObject();
                var msg = "送信データ："
                        + userName
                        + ","
                        + userPass;
                System.out.println(msg);
                // この1行を追加
                //setResponsePage(new UserMakerCompPage(userNameModel));

                // IoC/DI した userService のメソッドを呼び出す
                userService.registerUser(userName, userPass);
                setResponsePage(new UserMakerCompPage(userNameModel));
            }
        };
        add(userInfoForm);

      //  var userNameField = new TextField<>("userName");
      //  userInfoForm.add(userNameField);

       // var userPassField = new PasswordTextField("userPass");
       // userInfoForm.add(userPassField);

        // 右辺の型引数 <String> を <> に省略して書いている
        var userNameField = new TextField<>("userName", userNameModel){
            // onInitialize() は全てのコンポーネントに備わっている、初期化時の処理。
            // オーバーライドするときは super.onInitialize() を忘れずに残しておく。
            @Override
            protected void onInitialize() {
                super.onInitialize();
                // 文字列の長さを8〜32文字に制限するバリデータ
                var validator = StringValidator.lengthBetween(8, 32);
                add(validator);
            }
        };
        userInfoForm.add(userNameField);

        var userPassField = new PasswordTextField("userPass", userPassModel){
            // onInitialize() は全てのコンポーネントに備わっている、初期化時の処理。
            // オーバーライドするときは super.onInitialize() を忘れずに残しておく。
            @Override
            protected void onInitialize() {
                super.onInitialize();
                // 文字列の長さを8〜32文字に制限するバリデータ
                var validator = StringValidator.lengthBetween(8, 32);
                add(validator);
            }
        };
        userInfoForm.add(userPassField);

    }

}
