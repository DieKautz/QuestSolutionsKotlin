package set2

import Keys
import org.stellar.sdk.*

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest2PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    val helperAccountKeys = KeyPair.fromSecretSeed(Keys.set2helperKey)
    val helperAccount = server.accounts().account(helperAccountKeys.accountId)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    // we can get this from list of claimable balances by acc or in q4 result xdr
    val balanceId = "00000000137a4cae8ffe60fafab86b1b56ef429d5c7c3d4011f71f324189cbe6244b43f8"

    txBuilder.addOperation(
        ClaimClaimableBalanceOperation.Builder(balanceId).build()
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