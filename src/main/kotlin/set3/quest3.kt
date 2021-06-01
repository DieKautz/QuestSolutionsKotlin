package set3

import Keys
import friendBot
import org.stellar.sdk.*
import java.security.MessageDigest
import java.util.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.set3q3Key)

    // Ask friendbot to fund our account
    questAccountKeys.friendBot()

    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    val secret = Base64.getDecoder().decode("S2FuYXllTmV0")
    val hashX = String(secret).sha256()
    val hashXSignerKey = Signer.sha256Hash(hashX)

    txBuilder.addOperation(
        SetOptionsOperation.Builder()
            .setSigner(hashXSignerKey,1)
            .build()
    )

    val transaction = txBuilder.build()
    transaction.sign(questAccountKeys)
    println("Executing tx.. (adding hash signer)")
    try {
        val response = server.submitTransaction(transaction)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }

    val remSignBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    remSignBuilder.addOperation(
        SetOptionsOperation.Builder()
            .setSigner(hashXSignerKey,0)
            .build()
    )

    val txRemoveSigner = remSignBuilder.build()
    txRemoveSigner.sign(String(secret).toByteArray())
    println("Executing tx.. (removing hash signer)")
    try {
        val response = server.submitTransaction(txRemoveSigner)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }
}


fun String.sha256(): ByteArray {
    return MessageDigest
        .getInstance("SHA-256")
        .digest(this.toByteArray())
}