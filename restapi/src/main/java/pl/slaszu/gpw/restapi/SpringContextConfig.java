package pl.slaszu.gpw.restapi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "pl.slaszu.gpw.datacenter",
})
public class SpringContextConfig {
}