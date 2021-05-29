package set2

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest2PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    val accountToSponsor = KeyPair.random()

    txBuilder.addOperation(
        BeginSponsoringFutureReservesOperation.Builder(accountToSponsor.accountId).build()
    )
    txBuilder.addOperation(
        CreateAccountOperation.Builder(accountToSponsor.accountId, "0").build()
    )
    txBuilder.addOperation(
        EndSponsoringFutureReservesOperation(accountToSponsor.accountId)
    )

    val transaction = txBuilder.build()
    transaction.sign(questAccountKeys)
    transaction.sign(accountToSponsor)
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