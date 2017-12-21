package springboottest;

import makeswaggerjson.core.AppInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Administrator on 2017/6/20.
 * @author xudacheng
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(Application.class);
    }

    public static void main(String[] args) {
        AppInit.initApp();
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container){
        container.setPort(8082);
    }
}
