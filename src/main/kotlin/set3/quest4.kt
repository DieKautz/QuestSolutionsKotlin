package set3

import Keys
import friendBot
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.set3q4Key)

    // Ask friendbot to fund our account
    questAccountKeys.friendBot()
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val bumpedQuestAccount = server.accounts().account(questAccountKeys.accountId)
    bumpedQuestAccount.incrementSequenceNumber()
    val preAuthTx = Transaction.Builder(bumpedQuestAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)
        .addOperation(
            PaymentOperation.Builder("GAIH3ULLFQ4DGSECF2AR555KZ4KNDGEKN4AFI4SU2M7B43MGK3QJZNSR", AssetTypeNative(), "1").build()
        )
        .build()

    preAuthTx.sequenceNumber
    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    val preAuthTxKey = Signer.preAuthTx(preAuthTx)

    txBuilder.addOperation(
        SetOptionsOperation.Builder()
            .setSigner(preAuthTxKey,1)
            .build()
    )

    val transaction = txBuilder.build()
    transaction.sign(questAccountKeys)
    println("Executing tx.. (adding hash tx signer)")
    try {
        val response = server.submitTransaction(transaction)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }

    println("Executing tx.. (pre signed tx)")
    try {
        val response = server.submitTransaction(preAuthTx)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }
}