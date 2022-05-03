package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import domain.ExpertBean;
import domain.MatchBean;

@Configuration
@EnableWebMvc
@ComponentScan({"com.spring.fifa.FifaController","config.SecurityConfig"})
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public ExpertBean expertBean() {
		return new MatchBean();
	}
	
    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
