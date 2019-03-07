package ag.sportradar.newsreader

import ag.sportradar.newsreader.api.NewsApiClient
import ag.sportradar.newsreader.api.NewsData
import ag.sportradar.newsreader.api.OnNewsDataFetchedListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnNewsDataFetchedListener {

    override fun onNewsDataFetched(data: NewsData) {
        responseData.text = data.status
    }

    override fun onFailure(message: String) {
        responseData.text = message
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsApiClient = NewsApiClient(getString(R.string.news_api_key))
        newsApiClient.getTopHeadlines(this)
    }
}
