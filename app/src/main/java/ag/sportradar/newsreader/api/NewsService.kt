package ag.sportradar.newsreader.api

import ag.sportradar.newsreader.api.model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    fun topHeadlines(@Query("country") country: String, @Query("apiKey") apiKey: String): Call<NewsData>
}