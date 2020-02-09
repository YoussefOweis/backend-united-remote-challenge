package com.oweisyoussef.unitedremotebackendtest.restapi;

import com.oweisyoussef.unitedremotebackendtest.pojo.GithubApiResult;
import com.oweisyoussef.unitedremotebackendtest.utils.GithubApiClient;
import com.oweisyoussef.unitedremotebackendtest.utils.MapUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LanguageDetailsService {
    public List<LanguageDetails> getAllLanguageDetails() {
        List<GithubApiResult> repositoryList = GithubApiClient.getAllTopRepositories();
        Map<String, ArrayList<String>> languageDetailsMap = new HashMap<>();
        for (int i = 0; i < repositoryList.size(); i++) {
            String languageName = repositoryList.get(i).getLanguage();
            String repositoryName = repositoryList.get(i).getFullName();
            if (!"null".equals(languageName) && languageName != null) {
                MapUtil.addToList(languageDetailsMap, languageName, repositoryName);
            }
        }


        Iterator<Map.Entry<String, ArrayList<String>>> itr = languageDetailsMap.entrySet().iterator();
        List<LanguageDetails> languageList = new ArrayList<>();
        while (itr.hasNext()) {
            Map.Entry<String, ArrayList<String>> lang = itr.next();
            LanguageDetails languageDetails = new LanguageDetails(lang.getKey(), lang.getValue());
            languageList.add(languageDetails);
        }

        Collections.sort(languageList);
        for (int i = 0; i < languageList.size(); i++) {
            languageList.get(i).setRank(i + 1);
        }

        return languageList;
    }


    public LanguageDetails getLanguageDetails(String languageName) {
        List<LanguageDetails> languageDetailsList = getAllLanguageDetails();
        LanguageDetails languageDetails = null;
        for (int i = 0; i < languageDetailsList.size(); i++) {
            if (languageDetailsList.get(i).getName().equals(languageName)) {
                languageDetails = languageDetailsList.get(i);
                break;
            }
        }
        return languageDetails;
    }
}
