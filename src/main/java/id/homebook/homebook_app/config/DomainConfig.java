package id.homebook.homebook_app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("id.homebook.homebook_app")
@EnableJpaRepositories("id.homebook.homebook_app")
@EnableTransactionManagement
public class DomainConfig {
}
