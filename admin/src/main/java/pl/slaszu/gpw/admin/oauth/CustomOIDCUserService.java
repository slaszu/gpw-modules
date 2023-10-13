package pl.slaszu.gpw.admin.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import pl.slaszu.gpw.admin.db.User;
import pl.slaszu.gpw.admin.oauth.provider.Provider;
import pl.slaszu.gpw.admin.service.UserService;

public class CustomOIDCUserService extends OidcUserService {

    @Autowired
    private UserService userService;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);

        Provider provider = Provider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
        User user = this.userService.postLoginCreateOrUpdate(oidcUser, provider);

        return new CustomOIDCUser(user);
    }
}
