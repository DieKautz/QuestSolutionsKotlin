package set3

import Keys
import friendBot
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.set3q1Key)

    // Ask friendbot to fund our account
    questAccountKeys.friendBot()

    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    txBuilder.addOperation(
        BumpSequenceOperation.Builder(110101115104111).build() // "nesho" in int representation
    )

    val transaction = txBuilder.build()
    transaction.sign(questAccountKeys)
    println("Executing tx..")
    try {
        val response = server.submitTransaction(transaction)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }
}