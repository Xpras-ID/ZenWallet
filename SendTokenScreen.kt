package com.zenwallet.app

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import java.math.BigDecimal

@Composable
fun SendTokenScreen(web3: Web3j, credentials: Credentials) {
    var toAddress by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }

    val ztcContractAddress = "0xYourZtcContractAddress"

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Kirim ZTC", style = MaterialTheme.typography.h6)
        OutlinedTextField(value = toAddress, onValueChange = { toAddress = it }, label = { Text("Alamat Tujuan") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = amount, onValueChange = { amount = it }, label = { Text("Jumlah") })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val token = ZtcToken(web3, ztcContractAddress, credentials)
            token.sendTokens(toAddress, amount.toBigDecimal()) {
                result = it
            }
        }) {
            Text("Kirim")
        }

        result?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(it)
        }
    }
}