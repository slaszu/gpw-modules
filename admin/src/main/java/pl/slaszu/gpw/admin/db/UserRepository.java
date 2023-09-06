package pl.slaszu.gpw.admin.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.slaszu.gpw.admin.oauth.Provider;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByProviderAndProviderUniqueId(Provider provider, String providerUniqueId);
}
