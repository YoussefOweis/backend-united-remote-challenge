package com.oweisyoussef.unitedremotebackendtest.utils;

import com.oweisyoussef.unitedremotebackendtest.pojo.GithubApiResponse;
import com.oweisyoussef.unitedremotebackendtest.pojo.Item;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class GithubApiClient {
    private static final String OAUTH_TOKEN = "05a4fc7bc34630a0184a17e9017baab7a984d6e1";
    private static final String GITHUB_API_SEARCH_TRENDING = "https://api.github.com/search/repositories?q=is:public+stars:>25000&sort=stars&order=desc&per_page=100";

    private static GithubApiResponse get(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + OAUTH_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.GET, entity, GithubApiResponse.class).getBody();
    }

    public static List<Item> getAllTopRepositories() {
        GithubApiResponse githubApiResponse = get(GITHUB_API_SEARCH_TRENDING);
        return githubApiResponse.getItems();
    }
}
