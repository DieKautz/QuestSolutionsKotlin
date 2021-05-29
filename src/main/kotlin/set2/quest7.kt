package set2

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest2PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val accountToSponsorKeys = KeyPair.fromSecretSeed(Keys.s2q6SponsoredKey)
    val accountToSponsor = server.accounts().account(accountToSponsorKeys.accountId)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    txBuilder.addOperation(
        PaymentOperation.Builder(accountToSponsor.accountId, AssetTypeNative(), "1").build()
    )
    txBuilder.addOperation(
        RevokeAccountSponsorshipOperation.Builder(accountToSponsor.accountId).build()
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