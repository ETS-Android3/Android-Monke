COS 420 Group 1: Android Monke
Contributors: Declan Brinn, Matt Brown, Caiden Emmerson, Sean Staton
Project: NO Monkeying Around!

Project Description:

NO Monekeying Around! is a mobile application developed for the android OS platform. This application is designed to keep the user on task, by displaying a cartoon tree which grows the longer the user is engaed with the app. It will also feature calendar functionality and Goole account integration, as well as a to-do list and leaderboard. Users will be able to view their 10 most recent trees in the tree collection tab of the application. Multipliers and "freezes" will be available for the user to buy or earn through contiued streaks using the app. 

Dependencies: 

    implementation 'androidx.appcompat:appcompat:1.3.0'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.annotation:annotation:1.3.0'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.1'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1'
    implementation 'com.google.firebase:firebase-database:20.0.4'
    implementation platform('com.google.firebase:firebase-bom:29.3.0')
    implementation 'com.google.firebase:firebase-auth'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.8.0-M1'
    testImplementation "org.junit.jupiter:junit-jupiter-api:5.0.1"
    testImplementation 'junit:junit:4.13.2'
    testCompileOnly 'org.apiguardian:apiguardian-api:1.0.0'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
