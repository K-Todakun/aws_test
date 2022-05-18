package com.example.practice_wsbp.page;

import com.example.practice_wsbp.MySession;
import com.example.practice_wsbp.page.signed.SignedPage;
import com.example.practice_wsbp.repository.IUserService;
import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.Objects;

@WicketSignInPage
@MountPath("Sign")
public class SignPage extends WebPage{

    // ServiceをIoC/DIする
    @SpringBean
    private IUserService service;


    public SignPage() {

        var userNameModel = Model.of("");
        var userPassModel = Model.of("");

       /* var userInfoForm = new Form<>("userInfo") {
            @Override
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                var userPass = userPassModel.getObject();
                if (Objects.equals(userName, "b1970010")
                        && Objects.equals(userPass, "qwertyui")) {
                    MySession.get().sign(userName);
                }
                setResponsePage(new SignedPage());
            }
        };
        add(userInfoForm);
        */
        Form<Void> userInfoForm = new Form<Void>("userInfo") {
            @Override
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                var userPass = userPassModel.getObject();
                // b1992490...の定数で照合していたものを、DB経由に変更
                if (service.existsUser(userName, userPass)) {
                    MySession.get().sign(userName);
                }
                setResponsePage(new SignedPage());
            }
        };
        add(userInfoForm);

        var userNameField = new TextField<>("userName", userNameModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                // 文字列の長さを8〜32文字に制限するバリデータ
                add(StringValidator.lengthBetween(8, 32));
            }
        };

        userInfoForm.add(userNameField);

        var userPassField = new PasswordTextField("userPass", userPassModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                // 文字列の長さを8〜32文字に制限するバリデータ
                add(StringValidator.lengthBetween(8, 32));
            }
        };
        userInfoForm.add(userPassField);
    }

}
