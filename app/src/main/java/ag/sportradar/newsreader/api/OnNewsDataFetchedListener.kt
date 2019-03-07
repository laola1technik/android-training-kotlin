package ag.sportradar.newsreader.api

import ag.sportradar.newsreader.api.model.NewsData

interface OnNewsDataFetchedListener {
    fun onNewsDataFetched(data: NewsData)
    fun onFailure(message: String = "Default Error")
}
