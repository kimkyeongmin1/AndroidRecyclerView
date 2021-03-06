package tech.thdev.androidrecyclerview.view.git_sample.user_search

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_git_hub_user_search.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.source.github.GitHubUserRepository
import tech.thdev.androidrecyclerview.view.git_sample.user_search.adapter.GitHubUserSearchAdapter
import tech.thdev.androidrecyclerview.view.git_sample.user_search.presenter.GitHubUserSearchContract
import tech.thdev.androidrecyclerview.view.git_sample.user_search.presenter.GitHubUserSearchPresenter
import tech.thdev.base.view.BasePresenterFragment

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserSearchFragment :
        BasePresenterFragment<GitHubUserSearchContract.View, GitHubUserSearchContract.Presenter>(),
        GitHubUserSearchContract.View {

    var searchKeyword = "tom+repos:>42"

    override fun getLayout() = R.layout.fragment_git_hub_user_search

    override fun onCreatePresenter()
            = GitHubUserSearchPresenter()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GitHubUserSearchAdapter(context)
        recycler_view.adapter = adapter
        presenter?.adapterModel = adapter
        presenter?.adapterView = adapter
        presenter?.gitHubUserRepository = GitHubUserRepository
        presenter?.searchGitHubUser(searchKeyword)
    }

    override fun showProgress() {
        Toast.makeText(context, "Start", Toast.LENGTH_SHORT).show()
    }

    override fun hideProgress() {
        Toast.makeText(context, "End", Toast.LENGTH_SHORT).show()
    }

    override fun showDetailUserInfo(html_url: String) {
        // Use a CustomTabsIntent.Builder to configure CustomTabsIntent.
        // Once ready, call CustomTabsIntent.Builder.build() to create a CustomTabsIntent
        // and launch the desired Url with CustomTabsIntent.launchUrl()
        val builder = CustomTabsIntent.Builder()
        // Changes the background color for the omnibox. colorInt is an int
        // that specifies a Color.
        builder.setToolbarColor(resources.getColor(R.color.colorPrimary))

        builder.setStartAnimations(context, 0, 0)
        builder.setExitAnimations(context, 0, 0)

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context as Activity, Uri.parse(html_url))
    }
}