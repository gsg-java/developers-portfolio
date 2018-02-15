package com.coduckfoilo.domain;

import com.coduckfoilo.domain.user.User;
import com.coduckfoilo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 2. 10..
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Map> getUser(@PathVariable("name") String name) {
        // Git Hub API를 사용하기 위한 작업, Util class 로 대체할 예정
        RestTemplate restTemplate = new RestTemplate();

        SecurityContextHolder.getContext().getAuthentication().getDetails();
        String token = ((OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set(HttpHeaders.AUTHORIZATION, "token " + token);
        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity responseEntity = restTemplate.getForEntity("https://api.github.com/users/" + name, Map.class, httpEntity);
        return responseEntity;
    }
}