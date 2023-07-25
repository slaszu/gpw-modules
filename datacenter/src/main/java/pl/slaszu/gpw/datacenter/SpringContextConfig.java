package pl.slaszu.gpw.datacenter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@EntityScan("pl.slaszu.gpw.datacenter")
@EnableJpaRepositories(basePackages = "pl.slaszu.gpw.datacenter")
public class SpringContextConfig {
}
