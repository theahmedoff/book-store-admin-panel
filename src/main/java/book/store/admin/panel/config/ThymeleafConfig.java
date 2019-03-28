package book.store.admin.panel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Controller
public class ThymeleafConfig {

    @Bean
    public SpringSecurityDialect securityDialect(){
        return new SpringSecurityDialect();
    }

}
