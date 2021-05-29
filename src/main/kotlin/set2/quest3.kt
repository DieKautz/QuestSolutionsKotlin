package set2

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest2PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val helperAccountKeys = KeyPair.fromSecretSeed(Keys.set2helperKey)
    val helperAccount = server.accounts().account(helperAccountKeys.accountId)

    // use helper acc to pay for tx
    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    // payback to friendbot as usual but from quest acc
    txBuilder.addOperation(
        PaymentOperation.Builder("GAIH3ULLFQ4DGSECF2AR555KZ4KNDGEKN4AFI4SU2M7B43MGK3QJZNSR", AssetTypeNative(), "10")
            .build()
    )

    val innerTx = txBuilder.build()
    innerTx.sign(questAccountKeys)

    val feeTxBuilder = FeeBumpTransaction.Builder(innerTx)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE.toLong())
        .setFeeAccount(helperAccount.accountId)
    val feeBumpTransaction = feeTxBuilder.build()
    feeBumpTransaction.sign(helperAccountKeys)

    println("Executing tx..")
    try {
        val response = server.submitTransaction(feeBumpTransaction)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }
}