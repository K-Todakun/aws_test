package com.example.practice_wsbp.page;

import com.example.practice_wsbp.MySession;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

//実装されてない演習
@AuthorizeInstantiation(Roles.USER)
@WicketHomePage
@MountPath("NotPractice")
public class NotPractice extends WebPage {

    public NotPractice(){
        //ユーザID表示
        var signedUserName = MySession.get().getUserName();
        var name = Model.of(signedUserName);
        var userNameLabel = new Label("userName", name);
        add(userNameLabel);

    }
}
