package set2

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest2PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val issuerAccountKeys = KeyPair.fromSecretSeed(Keys.set2helperKey)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    val myAsset = Asset.createNonNativeAsset("MINE", issuerAccountKeys.accountId)

    txBuilder.addOperation(
        ChangeTrustOperation.Builder(myAsset, "10000").build()
    )
    txBuilder.addOperation(
        PaymentOperation.Builder(questAccount.accountId, myAsset, "1337.69")
            .setSourceAccount(issuerAccountKeys.accountId)
            .build()
    )

    val transaction = txBuilder.build()
    transaction.sign(questAccountKeys)
    transaction.sign(issuerAccountKeys)
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