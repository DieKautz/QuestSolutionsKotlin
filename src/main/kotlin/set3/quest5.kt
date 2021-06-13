package set3

import Keys
import friendBot
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.set3q5Key)
    val helperAccountKeys = KeyPair.fromSecretSeed(Keys.set3helperKey)

    // Ask friendbot to fund our accounts
    helperAccountKeys.friendBot()
    questAccountKeys.friendBot()
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    val asset = Asset.createNonNativeAsset("MariusLenk", questAccountKeys.accountId)

    // enable clawback for issuer account
    // 2: authorization revocable, 8: clawback enabled
    txBuilder.addOperation(
        SetOptionsOperation.Builder()
            .setSetFlags(2 or 8)
            .build()
    )
    // establish trustline from helper to issuer
    txBuilder.addOperation(
        ChangeTrustOperation.Builder(asset, "1000000")
            .setSourceAccount(helperAccountKeys.accountId)
            .build()
    )
    // send asset to helper
    txBuilder.addOperation(
        PaymentOperation.Builder(helperAccountKeys.accountId, asset, "1000").build()
    )

    val createAssetTx = txBuilder.build()
    createAssetTx.sign(questAccountKeys)
    createAssetTx.sign(helperAccountKeys)
    println("Executing tx.. (sending asset)")
    try {
        val response = server.submitTransaction(createAssetTx)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }


    val tx2Builder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    // now claw back the 1000
    tx2Builder.addOperation(
        ClawbackOperation.Builder(helperAccountKeys.accountId, asset, "1000").build()
    )

    val clawbackTx = tx2Builder.build()
    clawbackTx.sign(questAccountKeys)
    println("Executing tx.. (clawback asset)")
    try {
        val response = server.submitTransaction(clawbackTx)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }
}