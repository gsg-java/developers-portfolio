package com.coduckfoilo.domain;

import com.coduckfoilo.domain.project.Project;
import com.coduckfoilo.domain.user.User;
import com.coduckfoilo.domain.user.UserRepository;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;
import org.eclipse.egit.github.core.client.GitHubResponse;
import org.eclipse.egit.github.core.service.GitHubService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
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
import sun.reflect.annotation.ExceptionProxy;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 2. 10..
 */

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getUser(@PathVariable("name") String name) {
        // Git Hub API를 사용하기 위한 작업, Util class 로 대체할 예정
        String token = ((OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();

        try {
            GitHubClient gitHubClient = new GitHubClient();
            gitHubClient.setOAuth2Token(token);
            UserService userService = new UserService(gitHubClient);

            String email = userService.getUser(name).getEmail();
            int id = userService.getUser(name).getId();
            String gitHubName = userService.getUser(name).getName();

            return email + " " + id + " " + gitHubName;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
