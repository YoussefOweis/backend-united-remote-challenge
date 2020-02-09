package com.oweisyoussef.unitedremotebackendtest.restapi;

import java.util.List;

public class LanguageDetails implements Comparable {

    private String name;
    private List<String> repositoryNameList;
    private int repositoryCount;
    private int rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageDetails that = (LanguageDetails) o;

        if (repositoryCount != that.repositoryCount) return false;
        if (rank != that.rank) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return repositoryNameList != null ? repositoryNameList.equals(that.repositoryNameList) : that.repositoryNameList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (repositoryNameList != null ? repositoryNameList.hashCode() : 0);
        result = 31 * result + repositoryCount;
        result = 31 * result + rank;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        LanguageDetails languageDetails = (LanguageDetails) o;
        return languageDetails.getRepositoryCount() - getRepositoryCount();
    }

    public LanguageDetails() {
    }

    public LanguageDetails(String name, List<String> repositoryNameList) {
        this.name = name;
        this.repositoryNameList = repositoryNameList;
        this.repositoryCount = repositoryNameList.size();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRepositoryNameList(List<String> repositoryNameList) {
        this.repositoryNameList = repositoryNameList;
    }

    public void setRepositoryCount(int repositoryCount) {
        this.repositoryCount = repositoryCount;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    public String getName() {
        return name;
    }

    public List<String> getRepositoryNameList() {
        return repositoryNameList;
    }

    public int getRepositoryCount() {
        return repositoryCount;
    }

    public int getRank() {
        return rank;
    }

}
