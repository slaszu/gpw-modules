package pl.slaszu.gpw.admin.oauth.provider;

import org.springframework.security.oauth2.core.user.OAuth2User;

public interface ProviderInterface {

    public String getUniqueId(OAuth2User oAuth2User);

    public String getUserName(OAuth2User oAuth2User);
}
