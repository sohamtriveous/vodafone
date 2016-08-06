#things to do

- Create a new Activity, call it SwipHomeActivity (Use New>Activity>Empty Activity)
- Also give change its intent-filter to Main and Launcher, so that it launches when the app is opened
- Write the retrofit API definition for the sources endpoint, which includes
  - getting a sample json response from newsapi.org
  - validating it in jsoneditoronline
  - creating the object (described before) in jsonshcematopojo
  - import the objects in our app
  - write a new method in our NewsAPI interface like so:
```java
      @GET("sources")
      Call<NewsApiSourcesResponse> getSources();
```
- Add support for storing and retrieving the Sources in CommonStuff
```java
    public static List<Source> sources;
    public static List<Source> getSources() {
        return sources;
    }
    public static void setSources(List<Source> sources) {
        CommonStuff.sources = sources;
    }
```

- Create a Fragment called ListOfArticlesFragment, it is basically a reimplementation of MainActivity
- it should override the following methods
  - override onCreate: get the position of the given source
  - onCreateView: inflate the activity_main view
  - onViewCreated: do the same thing as the old MainActivity#onCreate like getting references to the views, calling the api, handling the response
- create a static method called generateFragment which takes a position and creates a ListOfArticlesFragment, use Bundle and setArguments to set arguments to the fragment

- In SwipeHomeActivity
  - create a ViewPagerAdapter which extends from FragmentStatePagerAdapter
  - implement the getItem and getCount methods
  - it should hold a List<Sources>
  - the constructor should take a FragmentManager and List<Sources>
  - update the getItem and getCount methods as required
  - Make a network response call for the sources endpoint using Retrofit
    - there, get the list of sources
    - store it in commongstuff
    - create a ViewPagerAdapter based on the List<Sources>
    - set it on the adapter