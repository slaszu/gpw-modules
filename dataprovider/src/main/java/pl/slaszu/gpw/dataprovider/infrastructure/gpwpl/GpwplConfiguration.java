package pl.slaszu.gpw.dataprovider.infrastructure.gpwpl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:/dataprovider.yml")
@Getter
public class GpwplConfiguration {

    @Value("${gpw.gpwpl.url-today}")
    private String urlToday;

    @Value("${gpw.gpwpl.url-archive}")
    private String urlArchive;

    @Value("${gpw.gpwpl.dir-temp}")
    private String tempDir;
}
