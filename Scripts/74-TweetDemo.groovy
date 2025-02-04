@groovy.transform.Canonical
class Tweet {
    String post // message
    String username
    Date postDateTime
    
    private List favorites = []
    private List retweets = []
    private List mentions = []
    private List hashtags = []
    
    // Implementacion de metodos
    void favorite(String username){
        favorites << username
    }
    List getFavorites(){
        favorites
    }
    void retweets(String username){
        retweets << username
    }
    List getRetweets(){
        retweets
    }
    List getMentions(){
        String pattern = /\B@[a-z0-9_-]+/
        post.findAll(pattern)
    }
    List getHashTags(){
        String pattern = /(?:\s|\A)[##]+([A-Za-z0-9-_]+)/
        post.findAll(pattern)
    }
}

Tweet tweet = new Tweet (post:"Avance del curso groovy seccion 8 @therealdanvega #Java #groovylang", username:"@lbolanos", postDateTime: new Date() )
println tweet
// Imprime: Tweet(Avance del curso groovy seccion 8, @lbolanos, Fri Jan 31 17:15:33 COT 2025)

tweet.favorite("@ApacheGroovy")
tweet.retweets("@ApacheGroovy")

println tweet.getFavorites()   // imprime [@ApacheGroovy]
println tweet.getRetweets()   // imprime [@ApacheGroovy]

println tweet.getMentions()   // imprime [@therealdanvega]
println tweet.getHashTags()   // imprime [ #Java,  #groovylang]

