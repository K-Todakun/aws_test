package com.example.practice_wsbp.page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;

import org.apache.wicket.model.Model;

import org.apache.wicket.spring.injection.annot.SpringBean;
import com.example.practice_wsbp.repository.IUserService;

@MountPath("UserDelete")
public class UserDeletePage extends WebPage{

    //IUserService を IoC/DI する
    @SpringBean
    private IUserService userService;

    public UserDeletePage(){

        // ホームに戻りための記述
        var toUserMakerLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toUserMakerLink);

        var userNameModel = Model.of("");

        var userInfoForm = new Form<Void>("userInfo"){
            @Override
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                var msg = "送信データ："
                        + userName
                        + ",";
                System.out.println(msg);
                // ↓ここに、deleteに関する記述が入る
                userService.removeUser(userName);
                setResponsePage(new UserDeleteCompPage(userNameModel));
            }
        };
        add(userInfoForm);

        var userNameField = new TextField<>("userName", userNameModel);
        userInfoForm.add(userNameField);

    }


}
