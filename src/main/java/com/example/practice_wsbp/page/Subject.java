package com.example.practice_wsbp.page;

import com.example.practice_wsbp.MySession;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@WicketHomePage
@MountPath("Subject")
public class Subject extends WebPage {

    public Subject(){

        //ユーザID表示
        var signedUserName = MySession.get().getUserName();
        var name = Model.of(signedUserName);
        var userNameLabel = new Label("userName", name);
        add(userNameLabel);


        //単元一覧
        var toNotPractice1 = new BookmarkablePageLink<>("toNotPractice", NotPractice.class);
        add(toNotPractice1);

        var toNotPractice2 = new BookmarkablePageLink<>("toNotPractice2", NotPractice.class);
        add(toNotPractice2);

        var toNotPractice3 = new BookmarkablePageLink<>("toNotPractice3", NotPractice.class);
        add(toNotPractice3);

        var toNotPractice4 = new BookmarkablePageLink<>("toNotPractice4", NotPractice.class);
        add(toNotPractice4);


        var toNotPractice5 = new BookmarkablePageLink<>("toNotPractice5", NotPractice.class);
        add(toNotPractice5);

        var toNotPractice6 = new BookmarkablePageLink<>("toNotPractice6", NotPractice.class);
        add(toNotPractice6);

        var toNotPractice7 = new BookmarkablePageLink<>("toNotPractice7", NotPractice.class);
        add(toNotPractice7);

        var toNotPractice8 = new BookmarkablePageLink<>("toNotPractice8", NotPractice.class);
        add(toNotPractice8);

        var toNotPractice9 = new BookmarkablePageLink<>("toNotPractice9", NotPractice.class);
        add(toNotPractice9);

        var toNotPractice10 = new BookmarkablePageLink<>("toNotPractice10", NotPractice.class);
        add(toNotPractice10);

        var toNotPractice11 = new BookmarkablePageLink<>("toNotPractice11", NotPractice.class);
        add(toNotPractice11);

        var toNotPractice12 = new BookmarkablePageLink<>("toNotPractice12", NotPractice.class);
        add(toNotPractice12);


        var toNotPractice13 = new BookmarkablePageLink<>("toNotPractice13", NotPractice.class);
        add(toNotPractice13);

        var toNotPractice14 = new BookmarkablePageLink<>("toNotPractice14", NotPractice.class);
        add(toNotPractice14);

        var toNotPractice15 = new BookmarkablePageLink<>("toNotPractice15", NotPractice.class);
        add(toNotPractice15);

        var toNotPractice16 = new BookmarkablePageLink<>("toNotPractice16", NotPractice.class);
        add(toNotPractice16);

        var toNotPractice17 = new BookmarkablePageLink<>("toNotPractice17", NotPractice.class);
        add(toNotPractice17);

        var toPractice1 = new BookmarkablePageLink<>("toPractice1", Practice.class);
        add(toPractice1);


        var toPractice2 = new BookmarkablePageLink<>("toPractice2", Practice.class);
        add(toPractice2);

    }
}
