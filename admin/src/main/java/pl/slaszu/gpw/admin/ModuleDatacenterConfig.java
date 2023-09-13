package pl.slaszu.gpw.admin;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "pl.slaszu.gpw.datacenter"
})
public class ModuleDatacenterConfig {
}