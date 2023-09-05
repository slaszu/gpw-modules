package pl.slaszu.gpw.admin.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

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


        Collection<GrantedAuthority> authorities = new ArrayList<>(this.oauth2User.getAuthorities());
        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return authorities;
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
