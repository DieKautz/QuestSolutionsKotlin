import org.stellar.sdk.KeyPair
import java.net.HttpURLConnection
import java.net.URL

fun KeyPair.friendBot() {
    val url = URL("https://friendbot.stellar.org/?addr=$accountId")

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET
        setRequestProperty("user-agent","Mozilla/5.0")

        println("\nFriendbot was asked to fund $accountId" +
                "\nResponse: [$responseCode] $responseMessage")
    }
}