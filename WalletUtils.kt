package com.zenwallet.app

import org.web3j.crypto.Credentials

object WalletUtils {
    fun loadWalletFromPrivateKey(privateKey: String): Credentials {
        return Credentials.create(privateKey)
    }
}