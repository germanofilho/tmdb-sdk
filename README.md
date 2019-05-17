# tmdb-sdk
[![](https://jitpack.io/v/germanofilho/tmdb-sdk.svg)](https://jitpack.io/#germanofilho/tmdb-sdk)
[![Github Version](https://img.shields.io/github/release/germanofilho/tmdb-sdk.svg)](https://github.com/germanofilho/tmdb-sdk/releases)

SDK to integration TMDb API

### Installation 
```gradle
allprojects {
    repositories {
        jcenter()
       maven { url "https://jitpack.io" }
    }
}
```

And then in your app gradle `app/build.gradle`
```gradle
implementation 'com.github.germanofilho:tmdb-sdk:x.x.x'
```

### How to Configure
You'll need to implement the configuration passing your TMDb API Key, as sample below:

```kotlin
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        initTMDbSdk()
    }

    private fun initTMDbSdk(){
        val configuration = TMDbConfiguration()
        configuration.setApiKey("PUT YOUR TMDB API KEY HERE!!!")
        TMDb.instance.init(applicationContext, configuration)
    }
}
```

### How to Use
To use this SDK you may implement the API calls like this:
```kotlin
tmDbMovie.getPopularMovies(object : CallbackBoundary<PopularMovieList>{
    override fun success(response: PopularMovieList) {
        //Success logic here!
    }

    override fun error(e: Throwable) {
        //Handle error here!
    }
})
```
