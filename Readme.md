#things to do


0. Add the following to build.gradle

```groovy
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
```
1. Create a networking package
2. Create a NewsAPI class inside the networking package
3. Define the API_KEY and BASE_URL as constants
4. Define an interface: NewsAPIInterface
5. Create a method for each endpoint, pass source and sortBy as query parameters
6. Annotate it with GET with the particular endpoint url along with the KEY
7. define a static NewsAPIInterface object
8. Create a static getNewsAPI method which will help us in accessing the singleton
9. in case the NewsAPIInterface is null, create an instance of Retrofit with
a) the basurl
b) the gson converter
10. create an instance of the newsapiinterface
11. In MainActivity, use NewsAPI.getNewsAPI().getArticles to get Call<NewsApiArticleResponse>
12. use call.enqueue to get a callback for the network response
13. in the onResponse callback, use response.body() to get the NewsApiArticleResponse object
14. Use breakpoints/debugging to verify the response
