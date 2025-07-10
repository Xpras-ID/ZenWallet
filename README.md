Cara Menjalankan Aplikasi ZenWallet di Android Studio
1. Buka Android Studio
Jika belum punya, unduh di developer.android.com/studio
2. Buat Project Baru
Pilih: "Empty Compose Activity"
Nama: ZenWallet
Package: com.zenwallet.app
Minimum SDK: API 21 (Lollipop)
3. Tambahkan Dependency
Buka app/build.gradle, tambahkan:

dependencies {
    implementation "androidx.compose.ui:ui:1.5.0"
    implementation "androidx.compose.material:material:1.5.0"
    implementation "androidx.compose.ui:ui-tooling-preview:1.5.0"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
    implementation "androidx.activity:activity-compose:1.7.0"
    implementation "org.web3j:core:4.9.4"
}
}



