package pl.slaszu.gpw.datacenter;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("pl.slaszu.gpw.datacenter")
@EnableJpaRepositories(basePackages = "pl.slaszu.gpw.datacenter")
public class SpringContextConfig {
}
