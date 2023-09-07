package pl.slaszu.gpw.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.slaszu.gpw.admin.db.User;
import pl.slaszu.gpw.admin.db.UserRepository;
import pl.slaszu.gpw.admin.oauth.provider.Provider;
import pl.slaszu.gpw.admin.oauth.provider.ProviderInterface;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User postLoginCreateOrUpdate(OAuth2User oAuth2User, Provider provider) {
        ProviderInterface providerImplementation = provider.getProviderImplementation();

        Optional<User> optionalUser = this.userRepository.findByProviderAndProviderUniqueId(
            provider,
            providerImplementation.getUniqueId(oAuth2User)
        );

        User user = optionalUser.orElse(new User(
            provider,
            providerImplementation.getUniqueId(oAuth2User),
            providerImplementation.getUserName(oAuth2User)
        ));

        user.setLastLoggedIn(LocalDateTime.now());

        return this.userRepository.save(user);
    }
}
