package ag.sportradar.newsreader.api.model

data class NewsData(val status: String, val totalResults: Int, val articles: List<Article>)