package pl.slaszu.gpw.admin.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {

    private OAuth2User oauth2User;

    private String providerName;

    public CustomOAuth2User(OAuth2User oauth2User, String providerName) {
        this.oauth2User = oauth2User;
        this.providerName = providerName;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return "User %s (from %s)".formatted(this.getNameByStrategy(), this.providerName);
    }

    private String getNameByStrategy() {

        List<String> fields = Arrays.asList("asdasd", "name", "email", "login");

        for (String field : fields) {
            String attribute = this.oauth2User.getAttribute(field);
            if (attribute != null) {
                return attribute;
            }
        }

        return this.oauth2User.getName();
    }
}
