package ag.sportradar.newsreader.api.model

data class Article(val title: String){

    val source: Source? = null
    val author: String? = null
    val description: String? = null
    val url: String? = null
    val urlToImage: String? = null
    val publishedAt: String? = null
    val content: String? = null
}