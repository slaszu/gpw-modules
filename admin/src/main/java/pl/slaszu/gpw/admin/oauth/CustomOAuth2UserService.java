package pl.slaszu.gpw.admin.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import pl.slaszu.gpw.admin.db.User;
import pl.slaszu.gpw.admin.oauth.provider.Provider;
import pl.slaszu.gpw.admin.service.UserService;

public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Provider provider = Provider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
        User user = this.userService.postLoginCreateOrUpdate(oAuth2User, provider);

        return new CustomOAuth2User(user);
    }
}
