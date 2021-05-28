package set1

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest1PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val helperAccountKeys = KeyPair.fromSecretSeed(Keys.set1helperKey)
    val helperAccount = server.accounts().account(helperAccountKeys.accountId)

    // use helper acc to pay for tx
    val txBuilder = Transaction.Builder(helperAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    // payback to friendbot as usual but from quest acc
    txBuilder.addOperation(
        PaymentOperation.Builder("GAIH3ULLFQ4DGSECF2AR555KZ4KNDGEKN4AFI4SU2M7B43MGK3QJZNSR", AssetTypeNative(), "10")
            .setSourceAccount(questAccount.accountId)
            .build()
    )

    val transaction = txBuilder.build()
    transaction.sign(helperAccountKeys)
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