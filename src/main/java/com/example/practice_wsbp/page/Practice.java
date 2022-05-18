package com.example.practice_wsbp.page;


import com.example.practice_wsbp.MySession;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceScriptDatabaseInitializer;
import org.wicketstuff.annotation.mount.MountPath;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import com.example.practice_wsbp.service.ISampleService;
import org.apache.wicket.spring.injection.annot.SpringBean;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;

//演習画面
@AuthorizeInstantiation(Roles.USER)
@WicketHomePage
@MountPath("Practice")
public class Practice extends WebPage{

    public Practice(){
        //ユーザID表示
        var signedUserName = MySession.get().getUserName();
        var name = Model.of(signedUserName);
        var userNameLabel = new Label("userName", name);
        add(userNameLabel);


    }

}
