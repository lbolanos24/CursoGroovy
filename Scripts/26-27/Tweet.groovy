@groovy.transform.ToString
class Tweet{
    String username
    String text
    Integer retweets
    Integer favorites
    Date createdOn
    
    public Tweet(String user, String tweet){
        username = user
        text = tweet
        retweets = 0
        favorites = 0
        createdOn = new Date()
    }
    
    void addToRetweets(){
        retweets += 1
    }
    
    void addToFavorites(){
        favorites += 1
    }
}