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

---

## Foundation Set 2

### [Quest 1:](src/main/kotlin/set2/quest1.kt) Create and fund a Stellar account
In this challenge your task is to **create and fund** a brand new Stellar account (seen below) **with 5000 XLM** on the testnet.

Include the SHA256 hash of the string **Stellar Quest Series 2** as the `MEMO_HASH` in the transaction memo field.

You will be required to use the `createAccount` operation, so don't just rely on friendbot. Good luck!

### [Quest 2:](src/main/kotlin/set2/quest2.kt) Construct and execute a multi-operational transaction
Did you know each Stellar transaction can include as many as 100 unique operations? 😱 This is an incredible feature as each transaction is atomic meaning either the whole group of operations succeeds or fails together.

In this challenge your task is to create a multi-operational transaction which creates a custom asset trustline on your account and pays that asset to your account from the issuing account all in the same transaction.

**Fun fact:** This is actually what we do here at Stellar Quest when issuing prizes. The claim transaction is a nice little multi-operational transaction adding and issuing the badge to your account all in a single transaction.

### [Quest 3:](src/main/kotlin/set2/quest3.kt) Create and submit a fee bump transaction
Fee channels are a common best practice in Stellar development. Their goal is to delegate fee payments away from user accounts for an improved UX. Protocol 13 saw a huge improvement to this flow with the introduction of fee bump transactions.

In this challenge your task is to create and execute a fee bump transaction which consumes the sequence number from your account (seen below) but the transaction fee from some other account.

This is _actually_ how Stellar Quest delivers your prizes to you. A multi-operational transaction wrapped in a fee bump transaction. You pay the sequence number but we pay the transaction fee. How nice!

### [Quest 4:](src/main/kotlin/set2/quest4.kt) Create a claimable balance
This one will be a bit tricky but I believe in you.

Today you've gotta sort out how to create a claimable balance that is only claimable by you and **only claimable after the next challenge**.

Additionally the claimable balance **must be denoted in the native XLM asset** for an exact **amount of 100 XLM**.

### [Quest 5:](src/main/kotlin/set2/quest5.kt) Claim your claimable balance
Remember that claimable balance you setup in the last challenge?

This challenge is to "simply" **claim that balance and get your XLM back**.

### [Quest 6:](src/main/kotlin/set2/quest6.kt) Sponsor the absolute minimum balance for a new account
Storing stateful data on the Stellar blockchain isn't free. Everything from data attributes, trustlines and offers all the way down to just creating an account all increase the minimum balance of the account in question.

Up until protocol 15 this minimum balance had to be paid for by the account itself which often makes sense. However there are instances where it would be more convenient or even essential for these fees to be staked by some other accou
nt, a "sponsor" account.

In this challenge your task is to **create a brand new 0 XLM balance account with the absolute minimum balance sponsored by your account** (seen below).

### [Quest 7:](src/main/kotlin/set2/quest7.kt) Revoke account sponsorship for the account you're sponsoring
Remember that account you sponsored in the last challenge? Well the winds of change are blowing and you no longer wish to sponsor their absolute minimum balance any longer.

In this challenge you need to **revoke account sponsorship for the account you're currently sponsoring**.

### [Quest 8:](src/main/kotlin/set2/quest8.kt) Create and host a stellar.toml file for your account
Not all digital info should be stored on a blockchain. Some information needs to be mutable and derives no benefit from maintaining a blockchain paper trail. For these requirements we must look outside Stellar.

Blockchain database software like IPFS, Torrent or Filecoin can store stuff in a decentralized manner but are overkill when simply storing basic, mutable metadata for a Stellar account. For that we'll use SEP 1.

SEPs, or Stellar Ecosystem Proposa
ls are ecosystem initiatives aimed at providing consensus around common Stellar use cases. For SEP 1 that's providing a common format for Stellar account metadata.

In today's challenge your task is to create, host and link to a stellar.toml file with an `SQ02_EASTER_EGG` field containing the text:

    Log into series 2 of Stellar Quest then visit quest.stellar.org/series2. Finally drag and drop your Stellar Quest series 2 badge PNG images onto the screen. Enjoy!

Note you won't be able to solve today's challenge
using only the laboratory. You'll need to host a toml file and for that you'll need a basic server. Personally I love [RunKit](https://runkit.com) and [CodeSandbox](https://codesandbox.io) but feel free to use whatever works. Good luck!