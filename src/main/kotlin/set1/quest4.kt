package set1

import Keys
import org.stellar.sdk.*
import org.stellar.sdk.responses.AccountResponse

fun main() {
    val server = Server("https://horizon-testnet.stellar.org")
    val questAccountKeys = KeyPair.fromSecretSeed(Keys.quest1PrivateKey)
    val questAccount = server.accounts().account(questAccountKeys.accountId)

    // acc used for other key, must be created!
    val multisigAccKeys = KeyPair.fromSecretSeed(Keys.set1helperKey)

    val txBuilder = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    // add additional signer
    txBuilder.addOperation(
        SetOptionsOperation.Builder()
            .setMediumThreshold(2)
            .setSigner(multisigAccKeys.xdrSignerKey, 1)
            .build()
    )

    val addMultisigTx = txBuilder.build()
    addMultisigTx.sign(questAccountKeys)
    println("Executing tx.. (adding multisig)")
    try {
        val response = server.submitTransaction(addMultisigTx)
        println("Success!")
        println("txHash: ${response.hash}")
        println("result: ${response.resultXdr.get()}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }

    // do transaction
    val txBuilder2 = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    // make payment to friendbot
    txBuilder2.addOperation(
        PaymentOperation.Builder("GAIH3ULLFQ4DGSECF2AR555KZ4KNDGEKN4AFI4SU2M7B43MGK3QJZNSR", AssetTypeNative(), "10").build()
    )

    val useMultiSigTx = txBuilder2.build()
    useMultiSigTx.sign(questAccountKeys)
    useMultiSigTx.sign(multisigAccKeys)
    println("Executing tx.. (using multisig)")
    try {
        val response = server.submitTransaction(useMultiSigTx)
        println("Success!")
        println("txHash: ${response.hash}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }

    // OPTIONAL: remove multisig to not have to deal with it later on
    removeMultisig(questAccount, multisigAccKeys, questAccountKeys, server)
}

private fun removeMultisig(
    questAccount: AccountResponse,
    multisigAccKeys: KeyPair,
    questAccountKeys: KeyPair,
    server: Server
) {
    val txBuilder3 = Transaction.Builder(questAccount, Network.TESTNET)
        .setBaseFee(FeeBumpTransaction.MIN_BASE_FEE)
        .setTimeout(180)

    // make payment to friendbot
    txBuilder3.addOperation(
        SetOptionsOperation.Builder()
            .setMediumThreshold(0)
            .setSigner(multisigAccKeys.xdrSignerKey, 0)
            .build()
    )

    val removeMultiSigTx = txBuilder3.build()
    removeMultiSigTx.sign(questAccountKeys)
    println("Executing tx.. (removing multisig)")
    try {
        val response = server.submitTransaction(removeMultiSigTx)
        println("Success!")
        println("txHash: ${response.hash}")
    } catch (e: Exception) {
        println("Something went wrong!")
        println(e.message)
    }
}