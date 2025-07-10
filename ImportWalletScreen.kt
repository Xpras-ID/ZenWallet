package com.zenwallet.app

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.web3j.crypto.Credentials

@Composable
fun ImportWalletScreen(onWalletImported: (Credentials) -> Unit) {
    var privateKey by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Import Wallet", style = MaterialTheme.typography.h6)
        OutlinedTextField(
            value = privateKey,
            onValueChange = { privateKey = it },
            label = { Text("Private Key or Mnemonic") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            try {
                val credentials = WalletUtils.loadWalletFromPrivateKey(privateKey.trim())
                onWalletImported(credentials)
                error = null
            } catch (e: Exception) {
                error = "Invalid key or mnemonic"
            }
        }) {
            Text("Import")
        }

        error?.let {
            Text(it, color = MaterialTheme.colors.error)
        }
    }
}