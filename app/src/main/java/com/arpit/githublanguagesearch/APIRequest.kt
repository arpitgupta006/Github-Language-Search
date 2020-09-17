package com.arpit.githublanguagesearch

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIRequest {

    @GET("search/repositories")
    suspend fun githubResults(@Query("q")q:String) : Response<GithubResponse>
}

//https://api.github.com/search/repositories?q=language:kotlin