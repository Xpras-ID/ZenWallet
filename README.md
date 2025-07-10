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

Klik "Sync Now" jika muncul notifikasi
4. Ganti Isi File
Ubah file berikut dengan kode yang sudah saya beri:

File	Ganti dengan
MainActivity.kt	Kode dari MainActivity dengan import/import screen
Tambah	ImportWalletScreen.kt
Tambah	SendTokenScreen.kt
Tambah	TransactionHistory.kt + TransactionListScreen.kt
Tambah	WalletUtils.kt
Tambah	Theme.kt (tema hijau)

5. Jalankan Emulator / Device
Klik tombol ▶️ Run 'app'
Pilih emulator Android atau device asli
Aplikasi ZenWallet akan terbuka
LANGKAH 1: Buka app/build.gradle di Android Studio
Setelah buka project di Android Studio
Di panel kiri, pilih tab Project → mode "Project" atau "Android"
Navigasikan ke:
ZenWalletApp/
├── app/
│   └── build.gradle ← klik file ini
Gantilah bagian dependencies dan plugins seperti ini:
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace 'com.zenwallet.app'
    compileSdk 34

    defaultConfig {
        applicationId "com.zenwallet.app"
        minSdk 21
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = '17'
    }

    buildFeatures {
        compose true
    }

    composeOptions {
        kotlinCompilerExtensionVersion '1.5.0'
    }
}

dependencies {
    implementation "androidx.core:core-ktx:1.12.0"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
    implementation "androidx.activity:activity-compose:1.7.2"
    implementation "androidx.compose.ui:ui:1.5.0"
    implementation "androidx.compose.material:material:1.5.0"
    implementation "androidx.compose.ui:ui-tooling-preview:1.5.0"

    // Web3j untuk transaksi blockchain
    implementation "org.web3j:core:4.9.4"

    // Optional (debugging)
    debugImplementation "androidx.compose.ui:ui-tooling:1.5.0"
}

LANGKAH 2: Sinkronkan Gradle
Setelah selesai mengedit:

Klik tombol "Sync Now" di pojok kanan atas Android Studio

Tunggu hingga selesai (jika ada error, pastikan versi Compose cocok)

✅ Selesai!
Setelah gradle berhasil disinkronkan, kamu bisa Run ▶️ aplikasi ZenWallet-nya langsung.
