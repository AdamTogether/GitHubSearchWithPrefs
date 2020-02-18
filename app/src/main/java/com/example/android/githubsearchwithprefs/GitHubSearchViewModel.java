package com.example.android.githubsearchwithprefs;

import com.example.android.githubsearchwithprefs.data.GitHubRepo;
import com.example.android.githubsearchwithprefs.data.GitHubSearchRepository;
import com.example.android.githubsearchwithprefs.data.Status;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class GitHubSearchViewModel extends ViewModel {
    private GitHubSearchRepository mRepository;
    private LiveData<List<GitHubRepo>> mSearchResults;
    private LiveData<Status> mLoadingStatus;

    public GitHubSearchViewModel() {
        mRepository = new GitHubSearchRepository();
        mSearchResults = mRepository.getSearchResults();
        mLoadingStatus = mRepository.getLoadingStatus();
    }

    public void loadSearchResults(String query) {
        mRepository.loadSearchResults(query);
    }

    public LiveData<List<GitHubRepo>> getSearchResults() {
        return mSearchResults;
    }

    public LiveData<Status> getLoadingStatus() {
        return mLoadingStatus;
    }
}
