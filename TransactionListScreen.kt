package com.zenwallet.app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.Transaction
import org.web3j.utils.Convert

@Composable
fun TransactionListScreen(web3: Web3j, address: String) {
    var transactions by remember { mutableStateOf<List<Transaction>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        getTransactionHistory(web3, address) {
            transactions = it
            loading = false
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Riwayat Transaksi", style = MaterialTheme.typography.h6)
        if (loading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(transactions) { tx ->
                    TransactionItem(tx)
                }
            }
        }
    }
}

@Composable
fun TransactionItem(tx: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("To: ${tx.to}", fontSize = 14.sp)
            Text("Hash: ${tx.hash.take(20)}...", fontSize = 12.sp)
            Text("Value: ${Convert.fromWei(tx.value.toString(), Convert.Unit.ETHER)} ETH", fontSize = 14.sp)
        }
    }
}