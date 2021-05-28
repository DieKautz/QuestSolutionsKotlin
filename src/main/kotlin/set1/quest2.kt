package set1

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest1PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    txBuilder.addOperation(
        PaymentOperation.Builder("GAIH3ULLFQ4DGSECF2AR555KZ4KNDGEKN4AFI4SU2M7B43MGK3QJZNSR", AssetTypeNative(), "10").build()
    )

    val transaction = txBuilder.build()
    transaction.sign(questAccountKeys)
    println("Executing tx..")
    try {
        val response = server.submitTransaction(transaction)
        println("Success!")
        println("txHash: ${response.hash}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }
}