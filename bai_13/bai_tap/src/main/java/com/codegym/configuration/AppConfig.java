package com.codegym.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
        //phương thức lưu lại ngôn ngữ của người dùng bằng session
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        // phương thức lưu lại ngôn ngữ của người dùng bằng Cookie
        //CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        //cookieLocaleResolver.setCookieMaxAge(60*60*24);
        //Thiết lập ngôn ngữ mặc định
        sessionLocaleResolver.setDefaultLocale(Locale.US);
//            sessionLocaleResolver.setDefaultLocale(new Locale("vi"));

        return sessionLocaleResolver;
    }
    // tạo interceptor để bắt tham số language
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }
    // đăng kí intercepter
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    // Trỏ liên kết đến các file message
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("i18n/msg");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }

}
