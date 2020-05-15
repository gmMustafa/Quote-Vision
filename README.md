## Quote-Vision

### Quotes App Using RxJava2, Daggar2, and Retrofit. 


Quotes Data [REST API](https://type.fit/api/quotes)





### Screens

  Splash Screen              | Fetching Data               | Home Screen                   :---------------------------:|:---------------------------:|:---------------------------:
 ![](/screens/Splash.jpg)    |![](/screens/Downloading.jpg)| ![](/screens/Home.jpg)     








### Setup
Add dependencies to your build.gradle (app-level) 

```
//RecyclerView
    implementation 'androidx.recyclerview:recyclerview:1.1.0'
    //GSON
    implementation 'com.google.code.gson:gson:2.8.6'
    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.8.1'
    //Retrofit to GSON Converter
    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
    //RXJAVA2
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.8.1'

    //Daggar2
    api 'com.google.dagger:dagger:2.27'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.27'

    api 'com.google.dagger:dagger-android:2.15'
    api 'com.google.dagger:dagger-android-support:2.15'
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.15'

    //progrss bar
    implementation 'com.kaopiz:kprogresshud:1.2.0'
```


Add Maven to build.gradel (project-level)
```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://oss.jfrog.org/libs-snapshot" }
    }
}

```



Add Java support to build.gradel (app-level)
```
   android{
     //to add java8 support
      compileOptions {
          sourceCompatibility JavaVersion.VERSION_1_8
          targetCompatibility JavaVersion.VERSION_1_8
      }
    }
```

Add vector drawalbes support to build.gradel (app-level)
```
   android{
     defaultConfig {
          //allow vectors
          vectorDrawables.useSupportLibrary = true
      }
    }
```
















