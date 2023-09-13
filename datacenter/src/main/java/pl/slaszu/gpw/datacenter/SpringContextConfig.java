package pl.slaszu.gpw.datacenter;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@EntityScan("pl.slaszu.gpw.datacenter")
@EnableJpaRepositories(basePackages = "pl.slaszu.gpw.datacenter")
@EnableCaching
public class SpringContextConfig {
}
