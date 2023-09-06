package pl.slaszu.gpw.admin.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

public class CustomOAuth2User implements OAuth2User {

    private OAuth2User oauth2User;

    private Provider provider;

    public CustomOAuth2User(OAuth2User oauth2User, Provider provider) {
        this.oauth2User = oauth2User;
        this.provider = provider;
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
        return "User %s (from %s)".formatted(this.getNameByStrategy(), this.provider.toString());
    }

    private String getNameByStrategy() {

        List<String> fields = Arrays.asList("name", "email", "login");

        for (String field : fields) {
            String attribute = this.oauth2User.getAttribute(field);
            if (attribute != null) {
                return attribute;
            }
        }

        return this.oauth2User.getName();
    }
}
