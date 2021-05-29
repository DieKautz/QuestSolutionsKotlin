# Solutions for the Stellar Quest
from https://quest.stellar.org/

## Foundation Set 1

### [Quest 1:](src/main/kotlin/set1/quest1.kt) Create and fund a Stellar account
In this challenge your task is to **create and fund** a brand new Stellar account (seen below) **with 1000 XLM** on the testnet.

You will be required to use the `createAccount` operation, so don't just rely on friendbot. Good luck!

### [Quest 2:](src/main/kotlin/set1/quest2.kt) Make a payment from your Stellar account
In this challenge, your task is to **make a 10 XLM payment** from the Stellar account (seen below) you funded in challenge 1.

Use the `payment` operation to send the XLM payment to any other testnet account.
### [Quest 3:](src/main/kotlin/set1/quest3.kt) Store some arbitrary data in your Stellar account
Stellar allows you to store arbitrary data in the form of key : value pairs. In this challenge, you're tasked with adding a key of **Hello** and a value of **World** as a data attribute on your account. (seen below).

Note this challenge is case sensitive, so ensure you've got your key and value properly capitalized before checking your answer.
### [Quest 4:](src/main/kotlin/set1/quest4.kt) Add multisig to your account and make use of it in a transaction
In this challenge, your task is to **add and then make use of multisig** on your account (seen below).

⚠ **Please take your time with this one** ⚠\
If you get it wrong you could lock yourself out of your account for the remainder of the series.

Multisig can be a little tricky to wrap your mind around at first, but it's an important and essential security feature of Stellar baked into the core of the protocol.

*HINT: When adding multisig use `setOptions` but only `Signer Type`. Do not touch `Master Weight` or any Threshold settings unless you're sure you know what you're doing.
### [Quest 5:](src/main/kotlin/set1/quest5.kt) Create a custom asset and send it to your account
In this challenge, your task is to **create and send a custom asset** to your account (seen below).

Custom assets are a first-class citizen in Stellar, and while the concept of trustlines can be a little tricky, once you get it sorted it's quite intuitive and straightforward.
### [Quest 6:](src/main/kotlin/set1/quest6.kt) Create an offer to sell your custom asset for XLM
In this challenge, your task is to **create an offer to sell your custom asset for XLM**.

Stellar's decentralized exchange is a powerful feature that is built into the core of the protocol. It allows for instant interoperability between all Stellar assets, including yours!

⚠ \
You'll need to complete at least challenges 1 and 5 again before you'll be able to complete this challenge.
### [Quest 7:](src/main/kotlin/set1/quest7.kt) Make use of a channel account to make a payment
In this challenge, your task is to submit a payment operation from your account (seen below), but to **use a separate source account** to pay the fee and sequence number for the transaction.

This is known as a _fee channel_ or a _channel account_. It's a great way to soak up fees for users in larger apps or achieve higher transaction throughput.
### [Quest 8:](src/main/kotlin/set1/quest8.kt) Acquire custom asset via a path payment
In this challenge, your task is to acquire `SRT` from its issuing account `GCDNJUBQSX7AJWLJACMJ7I4BC3Z47BQUTMHEICZLE6MU4KQBRYG5JY6B` **via a path payment** operation.

By taking advantage of the decentralized exchange built in at the protocol level, a path payment combines the conversion and transfer of assets It's one of Stellar's most powerful features.