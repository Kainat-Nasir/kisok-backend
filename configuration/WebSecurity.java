package com.conurets.parking_kiosk.configuration;

import com.conurets.parking_kiosk.security.CustomWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurity extends CustomWebSecurityConfigurerAdapter {

    private static final String[] URL_API = new String[]{
            "/api/authenticate","/api/user/register"
    };
    private static final String[] URL_RESOURCE = new String[]{};
    private static final String[] URL_WEBSOCKET = new String[]{};

    public WebSecurity() {
        super(URL_API, URL_RESOURCE, URL_WEBSOCKET);
    }
}
