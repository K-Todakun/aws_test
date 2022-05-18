package com.example.practice_wsbp;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootWebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ↓ スーパークラスを WicketBootSecuredWebApplication に変更する
@SpringBootApplication
public class PracticeWsbpApplication extends WicketBootSecuredWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeWsbpApplication.class, args);
	}

	// 認証OK/NGを判定するセッションクラスを返値にする
	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return MySession.class;
	}

}
