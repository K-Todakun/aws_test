package com.example.practice_wsbp.page.signed;

import com.example.practice_wsbp.MySession;
import com.example.practice_wsbp.data.AuthUser;
import com.example.practice_wsbp.page.NotSubject;
import com.example.practice_wsbp.page.SignPage;
import com.example.practice_wsbp.page.Subject;
import com.example.practice_wsbp.repository.IUserService;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

// ↓ どの役割のユーザであれば表示してよいか。
// セッションのgetRoleメソッドが USER であれば表示し、それ以外は表示しない。
@AuthorizeInstantiation(Roles.USER)
@MountPath("Signed")
public class
SignedPage extends WebPage {

    // Service を IoC/DI する
    @SpringBean
    private IUserService userService;


    public SignedPage() {
        //ユーザID表示
        var signedUserName = MySession.get().getUserName();
        var name = Model.of(signedUserName);
        var userNameLabel = new Label("userName", name);
        add(userNameLabel);

        //科目一覧表示
        var toSubject = new BookmarkablePageLink<>("toSubject", Subject.class);
        add(toSubject);

        var toNotSubject = new BookmarkablePageLink<>("toNotSubject", NotSubject.class);
        add(toNotSubject);

        var toNotSubject2 = new BookmarkablePageLink<>("toNotSubject2", NotSubject.class);
        add(toNotSubject2);

        var toNotSubject3 = new BookmarkablePageLink<>("toNotSubject3", NotSubject.class);
        add(toNotSubject3);

        var toNotSubject4 = new BookmarkablePageLink<>("toNotSubject4", NotSubject.class);
        add(toNotSubject4);


        //サインアウト処理
        Link<Void> signoutLink = new Link<Void>("signout") {

            @Override
            public void onClick() {
                // セッションの破棄
                MySession.get().invalidate();
                // SignPageへ移動
                setResponsePage(SignPage.class);
            }
        };
        add(signoutLink);





        /*
        今回は、ユーザ情報一覧を表示させる必要がないと思いコメントアウトしました
        もしかしたら、使うこともあるかもしれないので残しておきます

        ここから下はユーザ情報一覧表示処理
-------------------------------------------------------------------------------
        // Service からデータベースのユーザ一覧をもらい、Modelにする
        // List型のモデルは Model.ofList(...) で作成する。
        var authUsersModel = Model.ofList(userService.findAuthUsers());

        // List型のモデルを表示する ListView
        var usersLV = new ListView<>("users", authUsersModel) {
            @Override
            protected void populateItem(ListItem<AuthUser> listItem) {
                // List型のモデルから、 <li>...</li> ひとつ分に分けられたモデルを取り出す
                var itemModel = listItem.getModel();
                var authUser = itemModel.getObject(); // 元々のListの n 番目の要素

                // インスタンスに入れ込まれたデータベースの検索結果を、列（＝フィールド変数）ごとにとりだして表示する
                // add する先が listItem になることに注意。
                var userNameModel = Model.of(authUser.getUserName());
                var userNameLabel = new Label("userName", userNameModel);
                listItem.add(userNameLabel);

                var userPassModel = Model.of(authUser.getUserPass());
                var userPassLabel = new Label("userPass", userPassModel);
                listItem.add(userPassLabel);
            }
        };
        add(usersLV);

         */

    }
}