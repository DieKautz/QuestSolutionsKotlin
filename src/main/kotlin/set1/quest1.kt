package set1

import Keys
import friendBot
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest1PrivateKey)

    // Need helper account to create with exactly 1000XLM
    val creatorAccountKeys = KeyPair.random()
    println("helper: ${creatorAccountKeys.accountId}")
    creatorAccountKeys.friendBot()
    val creatorAccount = server.accounts().account(creatorAccountKeys.accountId)

    val txBuilder = Transaction.Builder(creatorAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    txBuilder.addOperation(
        CreateAccountOperation.Builder(questAccountKeys.accountId, "1000").build()
    )

    val transaction = txBuilder.build()
    transaction.sign(creatorAccountKeys)
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