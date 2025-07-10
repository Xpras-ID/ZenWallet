package com.zenwallet.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

class MainActivity : ComponentActivity() {
    private lateinit var web3: Web3j
    private lateinit var credentials: Credentials

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        web3 = Web3j.build(HttpService("https://rpc.zenchain.network"))

        setContent {
            var isWalletReady by remember { mutableStateOf(false) }

            if (!isWalletReady) {
                ImportWalletScreen { creds ->
                    credentials = creds
                    isWalletReady = true
                }
            } else {
                TransactionListScreen(web3 = web3, address = credentials.address)
                // Or replace with SendTokenScreen(web3, credentials)
            }
        }
    }
}