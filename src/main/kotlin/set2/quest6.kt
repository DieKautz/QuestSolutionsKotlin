package set2

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest2PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val accountToSponsorKeys = KeyPair.fromSecretSeed(Keys.s2q6SponsoredKey)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    txBuilder.addOperation(
        BeginSponsoringFutureReservesOperation.Builder(accountToSponsorKeys.accountId).build()
    )
    txBuilder.addOperation(
        CreateAccountOperation.Builder(accountToSponsorKeys.accountId, "0").build()
    )
    txBuilder.addOperation(
        EndSponsoringFutureReservesOperation(accountToSponsorKeys.accountId)
    )

    val transaction = txBuilder.build()
    transaction.sign(questAccountKeys)
    transaction.sign(accountToSponsorKeys)
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