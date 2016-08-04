#things to do

(Optional) Add butterknife to your project

1. add classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8' to your root build.gradle
2. add these to your module's build.gradle dependency section
    compile 'com.jakewharton:butterknife:8.2.1'
    apt 'com.jakewharton:butterknife-compiler:8.2.1'
3. add the following to the top of your module's build.gradle
    apply plugin: 'com.neenbedankt.android-apt'

4. Add the @BindView annotation and the ButterKnife.bind() calls to MainActivity
5. Add the @BindView annotation and the ButterKnife.bind() calls to NewsAdapter