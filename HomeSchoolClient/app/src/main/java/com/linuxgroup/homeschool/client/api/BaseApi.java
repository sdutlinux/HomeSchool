package com.linuxgroup.homeschool.client.api;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tan on 14-9-26.
 */
public class BaseApi {
    protected static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
}
