package ag.sportradar.newsreader.api

interface OnNewsDataFetchedListener {
    fun onNewsDataFetched(data: NewsData)
    fun onFailure(message: String = "Default Error")
}
