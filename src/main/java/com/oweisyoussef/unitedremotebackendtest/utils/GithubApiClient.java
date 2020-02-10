package com.oweisyoussef.unitedremotebackendtest.utils;

import com.oweisyoussef.unitedremotebackendtest.pojo.GithubApiResponse;
import com.oweisyoussef.unitedremotebackendtest.pojo.GithubApiResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class GithubApiClient {
    private static final String OAUTH_TOKEN = "0cb2e333ad1d51b6084ed6a789e40509ebe23761";
    private static final String GITHUB_API_SEARCH_TRENDING = "https://api.github.com/search/repositories";

    private static GithubApiResponse get(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + OAUTH_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.GET, entity, GithubApiResponse.class).getBody();
    }

    public static List<GithubApiResult> getAllTopRepositories() {
        StringBuilder githubApiEndpoint = new StringBuilder(GITHUB_API_SEARCH_TRENDING);
        githubApiEndpoint.append("?")
                .append("q=created:>" + getCreatedDate())
                .append("&")
                .append("sort=stars")
                .append("&")
                .append("order=desc")
                .append("&")
                .append("per_page=100");


        GithubApiResponse githubApiResponse = get(githubApiEndpoint.toString());
        return githubApiResponse.getItems();
    }

    private static String getCreatedDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now().minusDays(30);
        return dtf.format(localDate);
    }
}
