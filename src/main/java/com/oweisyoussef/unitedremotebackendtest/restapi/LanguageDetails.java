package com.oweisyoussef.unitedremotebackendtest.restapi;

import java.util.List;

public class LanguageDetails implements Comparable {

    private String name;
    private List<String> repositoryNameList;
    private int RepositoryCount;
    private int rank;

    public String getName() {
        return name;
    }

    public List<String> getRepositoryNameList() {
        return repositoryNameList;
    }

    public int getRepositoryCount() {
        return RepositoryCount;
    }

    public int getRank() {
        return rank;
    }

    public LanguageDetails() {
    }
    public LanguageDetails(String _name,List<String> _repositoryNameList) {
        this.name =_name;
        this.repositoryNameList = _repositoryNameList;
        this.RepositoryCount = _repositoryNameList.size();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRepositoryNameList(List<String> repositoryNameList) {
        this.repositoryNameList = repositoryNameList;
    }

    public void setRepositoryCount(int repositoryCount) {
        RepositoryCount = repositoryCount;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }



    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
