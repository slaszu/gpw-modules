package pl.slaszu.gpw.admin.oauth.provider;

import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GoogleProvider implements ProviderInterface {
    @Override
    public String getUniqueId(OAuth2User oAuth2User) {
        Optional<Object> idOptional = Optional.ofNullable(oAuth2User.getAttribute("id"));
        Object o = idOptional.orElseThrow();

        return o.toString();
    }

    @Override
    public String getUserName(OAuth2User oAuth2User) {

        List<String> fields = Arrays.asList("name", "email", "login");

        for (String field : fields) {
            String attribute = oAuth2User.getAttribute(field);
            if (attribute != null) {
                return attribute;
            }
        }

        return oAuth2User.getName();
    }
}