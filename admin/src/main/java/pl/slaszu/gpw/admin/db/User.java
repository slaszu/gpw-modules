package pl.slaszu.gpw.admin.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.slaszu.gpw.admin.oauth.provider.Provider;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Column(name = "provider_unique_id")
    private String providerUniqueId;

    @Column(name = "registration_name")
    private String registrationName;

    @Column(name = "authorities", length = 500)
    private String authorities;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_logged_in")
    private LocalDateTime lastLoggedIn;

    public User(Provider provider, String providerUniqueId, String registrationName) {
        this.provider = provider;
        this.providerUniqueId = providerUniqueId;
        this.registrationName = registrationName;
    }


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void setLastLoggedIn(LocalDateTime lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }
}
