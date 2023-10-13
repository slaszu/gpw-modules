package pl.slaszu.gpw.admin.oauth;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import pl.slaszu.gpw.admin.db.User;

import java.util.Map;


public class CustomOIDCUser extends CustomOAuth2User implements OidcUser {

    public CustomOIDCUser(User user) {
        super(user);
    }

    @Override
    public Map<String, Object> getClaims() {
        return null;
    }

    @Override
    public OidcUserInfo getUserInfo() {
        return null;
    }

    @Override
    public OidcIdToken getIdToken() {
        return null;
    }
}
