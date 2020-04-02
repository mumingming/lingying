package cn.tedu.lingying;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
@MapperScan("cn.tedu.lingying.mapper")
@Configuration
public class LingyingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LingyingApplication.class, args);
    }

    @Bean
    public MultipartConfigElement getMultipartConfig() {
        MultipartConfigFactory factory
                = new MultipartConfigFactory();

        DataSize maxFileSize = DataSize.ofMegabytes(50);
        factory.setMaxFileSize(maxFileSize);
        DataSize maxRequestSize = DataSize.ofMegabytes(100);
        factory.setMaxRequestSize(maxRequestSize);

        return factory.createMultipartConfig();
    }


}
