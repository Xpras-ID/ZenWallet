package com.zenwallet.app

import kotlinx.coroutines.*
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.methods.response.Transaction

fun getTransactionHistory(
    web3: Web3j,
    address: String,
    onResult: (List<Transaction>) -> Unit
) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val transactions = mutableListOf<Transaction>()
            val latestBlock = web3.ethBlockNumber().send().blockNumber.toLong()

            for (i in latestBlock downTo latestBlock - 100) {
                val block = web3.ethGetBlockByNumber(DefaultBlockParameter.valueOf(i.toBigInteger()), true).send()
                block.block.transactions.forEach { tx ->
                    val txObj = tx.get() as Transaction
                    if (txObj.from.equals(address, ignoreCase = true) || txObj.to?.equals(address, true) == true) {
                        transactions.add(txObj)
                    }
                }
            }

            withContext(Dispatchers.Main) {
                onResult(transactions)
            }

        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                onResult(emptyList())
            }
        }
    }
}