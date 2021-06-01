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

### [Quest 1:](src/main/kotlin/set3/quest1.kt) Make use of a sequence number bump operation in a transaction
Welcome to Stellar Quest series 3! In today's inaugural challenge you must submit a transaction from your account, making use of the sequence number bump operation.

What good is the sequence number bump operation you ask? While it may not be a heavily utilized operation within an account's lifecycle it's an incredibly useful op when dealing with smart contracts, particularly around pre-signed transactions.

Imagine a scenario where you have two potential outcomes but only one of them should actually execute. Rather than having both transactions compete for the same sequence number you can control the outcome by bumping the sequence number to support whichever of the two scenarios you wish.

With functionality like this you can now block transaction submission both by time and by sequence. Control all the things!

⚠ This quest isn't as simple at seems. We're just as much about coding as we are about gaming and riddles here at the SQ HQ. Be sure and click all the provided links and peruse for clues on how to conquer this quest.

### [Quest 2:](src/main/kotlin/set3/quest2.kt) Submit a transaction containing 100 operations
Stellar, like all good software, has lots of different caps, limits, and ceilings. For instance the cap on the number of operations per transaction is 100 atm.

Your challenge today is to successfully orchestrate and submit a transaction stuffed full of 100 operations.

For the developers out there still clinging to the Laboratory, now might be a good time to flex your coding skills and utilize one of our SDKs inside a loop.

### [Quest 3:](src/main/kotlin/set3/quest3.kt) Submit a hash signed transaction
So you've heard about Stellar's multisig, but did you know that you can sign with far more than just a simple Ed25519 secret key? That's right! There's also sha256 hashes and pre-authorized transaction hashes.

In today's challenge your task is to add a very specific and special sha256 hash signer to your account and then to submit a second transaction using that signer to remove itself as a signer from the account. A sort of one time use key if you will.

Your clue for what your hash signer should be is included in the Resources links below.

### [Quest 4:](src/main/kotlin/set3/quest4.kt) Submit a pre-authorized transaction
So you probably saw this one coming considering the previous quest, but today's challenge is to add as a signer and then submit to the network, a pre-authorized transaction. The last of the signer types accepted for submitting transactions to the network.

Pre-authorized transactions are a fantastic way to get around the somewhat cumbersome issue of multisig coordination. Just add a transaction hash as a signer to your account and then pass along that XDR to any other sig
ners for additional signing or final submission.

Simple, yet smart! A Simart Contract™! And just another great tool in your ever expanding tool belt of experience as a Stellar developer.

### [Quest 5:](src/main/kotlin/set3/quest5.kt) Successfully submit a clawback operation
Ask and ye shall receive. Today we conquer the asset clawback operation even as the steam wafts up from its freshly minted edifice.

While currently a testnet only feature, the asset clawback operation will be a regulated asset issuer's excalibur of conquest in this brave new world of old → new finance.

It's the Ctrl+Z for blockchain payments. The mechanic for undoing mistaken or fraudulent payments. Once an issuer and trustline have been created under the asset clawback umbrella the issuer has the power to "clawback" any amount of that asset back into the issuing account effectively burning it from existence.

Arguably a controversial feature it's an absolute requirement for issuing regulated assets on the blockchain and ultimately it's issuer specific so effectively opt-in and obvious from a consumers perspective.

### [Quest 6:](src/main/kotlin/set3/quest6.kt) Mint a Stellar Quest style NFT
Today's challenge will be difficult so prepare yourself. Take breaks, deep breaths, walk away for awhile if you need to. Don't stress it, the rewards will be worth the effort.

In reality minting an NFT is actually fairly straightforward, and while there are several variant methods we've used over the past few series we're going to explore the simplest.

What you'll need to do is take the PNG image provided in the Resources list, snag its base64 encoded string and bake that into your account's () manageData fields utilizing both the key and value fields.

So just methodically slice off bits of the base64 string and pack those into both the key and value slots of consecutive manageDate operations until you run out of string.

An important gotcha caveat is to prefix the key with 2 characters of indexing data in order to ensure accurate reassembly of the base64 string later.

### [Quest 7:](src/main/kotlin/set3/quest7.kt) Acquire and make use of a SEP-0010 JWT
Outside of the relatively simple and controlled world of Stellar operations there's a whole universe of use cases and implementations. Even here though there is need for order and interoperability.

These needs are met by Stellar Ecosystem Proposals or SEPs. SEPs are the Stellar wilderness guidebooks ensuring everyone is following the same path and rules and is thus able to interoperate with each other.

`SEP-0010` is an authentication SEP outlining how to prove ownership of a Stellar account to a service. It is used in many other SEPs so it's an important foundational SEP to understand.

Today's task will be to acquire a `SEP-0010` JWT and then embed that JWT back into your account's () manageData fields in identical fashion to how we embedded the NFT data in the previous quest.

Please note that this embed step **is not** part of `SEP-0010` and is **definitely not** something you'd do in practice. I'm just including it here as a method for reading back and making use of the generated `SEP-0010` JWT as part of the verification step. It's also a good refresher for Quest 6.

### [Quest 8:](src/main/kotlin/set3/quest8.kt) Use SEP-0006 to acquire some MULT from testanchor.stellar.org
Now that we've got `SEP-0010` under our belt let's make use of it to make an automated testnet `SEP-0006` deposit to SDF's testanchor endpoint.

Between `SEP-0006`, `SEP-0024` and `SEP-0031` we have all we need to connect Stellar with all the real world's "anchored" assets. `SEP-0006` is the API-only method for handling the flow so let's try that.

Your task today will be to use `SEP-0006` to request a deposit of `MULT` issued by `GDLD...FSMM` from the [testanchor.stellar.org](https://testanchor.stellar.org) endpoint.

This task will actually make use of `SEP-0010`, `SEP-0006` and `SEP-0012` so buckle up, read the docs, and enjoy the ride!

Finally I'm sure you're noticing by now we've begun to drift away from the Laboratory harbor into the more adventurous waters of the greater world wide web.

For Quests like this if you're uncomfortable whipping up some new code feel free to use `curl` or a tool like www.postman.com for constructing your non-Laboratory API calls.