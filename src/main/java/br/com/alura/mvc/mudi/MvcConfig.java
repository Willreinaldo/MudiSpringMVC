package br.com.alura.mvc.mudi;

import br.com.alura.mvc.mudi.interceptor.InteceptadorDeAcessos;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("pedido/formulario");
        registry.addViewController("/login").setViewName("login");
    }

   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InteceptadorDeAcessos()).addPathPatterns("/**");
    }

}