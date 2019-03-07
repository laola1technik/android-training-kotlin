package ag.sportradar.newsreader.api

import ag.sportradar.newsreader.api.model.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class NewsApiClient(val apiKey: String) {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val newsService: NewsService = retrofit.create(NewsService::class.java)


    fun getTopHeadlines(listener: OnNewsDataFetchedListener) {
        val topHeadlines = newsService.topHeadlines("us", apiKey)
        topHeadlines.enqueue(object : Callback<NewsData> {
            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                listener.onFailure(t.message ?: "Message is null")
            }

            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                if (response.body() != null) {
                    listener.onNewsDataFetched(response.body()!!)
                } else {
                    listener.onFailure("NewsData is null")
                }
            }

        })
    }

}