package pl.slaszu.gpw.admin;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("pl.slaszu.gpw.admin")
@EnableJpaRepositories(basePackages = "pl.slaszu.gpw.admin")
public class ModuleAdminConfig {
}
