# Solutions for the Stellar Quest
from https://quest.stellar.org/

<table>
<thead>
  <tr>
    <th>Series</th>
    <th>Quest</th>
    <th>Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td rowspan="8">Foundation Set 1</td>
    <td><a href="src/main/kotlin/set1/quest1.kt">Quest 1</a></td>
    <td><h3>Create and fund a Stellar account</h3>
    In this challenge your task is to <b>create and fund</b> a brand new Stellar account (seen below) <b>with 1000 XLM</b> on the testnet.
    <br>You will be required to use the <code>createAccount</code> operation, so don't just rely on friendbot. Good luck!</td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set1/quest2.kt">Quest 2</a></td>
    <td><h3>Make a payment from your Stellar account</h3>
    In this challenge, your task is to <b>make a 10 XLM payment from the Stellar account</b> (seen below) you funded in challenge 1.
    <br>Use the <code>payment</code> operation to send the XLM payment to any other testnet account.</td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set1/quest3.kt">Quest 3</a></td>
    <td><h3>Store some arbitrary data in your Stellar account</h3>
    Stellar allows you to store arbitrary data in the form of key : value pairs. In this challenge, you're tasked with adding a key of <b>Hello</b> and a value of <b>World</b> as a data attribute on your account. (seen below).
    <br>Note this challenge is case sensitive, so ensure you've got your key and value properly capitalized before checking your answer.</td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set1/quest4.kt">Quest 4</a></td>
    <td><h3>Add multisig to your account and make use of it in a transaction</h3>
    In this challenge, your task is to add <b>and then make use of multisig</b> on your account (seen below).
    <br>⚠ <b>Please take your time with this one</b> ⚠
    <br>If you get it wrong you could lock yourself out of your account for the remainder of the series.
    <br>Multisig can be a little tricky to wrap your mind around at first, but it's an important and essential security feature of Stellar baked into the core of the protocol.
    <br>*HINT: When adding multisig use <code>setOptions</code> but only set <code>Signer Type</code>. Do not touch <code>Master Weight</code> or any <code>Threshold</code> settings unless you're sure you know what you're doing.</td>
    
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set1/quest5.kt">Quest 5</a></td>
    <td><h3>Create a custom asset and send it to your account</h3>
    In this challenge, your task is to <b>create and send a custom asset</b> to your account (seen below).
    <br>Custom assets are a first-class citizen in Stellar, and while the concept of trustlines can be a little tricky, once you get it sorted it's quite intuitive and straightforward.</td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set1/quest6.kt">Quest 6</a></td>
    <td><h3>Create an offer to sell your custom asset for XLM</h3>
    In this challenge, your task is to <b>create an offer to sell your custom asset for XLM</b>.
    <br>Stellar's decentralized exchange is a powerful feature that is built into the core of the protocol. It allows for instant interoperability between all Stellar assets, including yours!
    <br>You'll need to complete at least challenges 1 and 5 before you'll be able to complete this challenge.</td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set1/quest7.kt">Quest 7</a></td>
    <td><h3>Make use of a channel account to make a payment</h3>
    In this challenge, your task is to submit a payment operation from your account (seen below), but to <b>use a separate source account</b> to pay the fee and sequence number for the transaction.
    <br>This is known as a <i>fee channel</i> or a <i>channel account</i>. It's a great way to soak up fees for users in larger apps or achieve higher transaction throughput.</td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set1/quest8.kt">Quest 8</a></td>
    <td><h3>Acquire custom asset via a path payment</h3>
In this challenge, your task is to acquire <code>SRT</code> from its issuing account <code>GCDNJUBQSX7AJWLJACMJ7I4BC3Z47BQUTMHEICZLE6MU4KQBRYG5JY6B</code> <b>via a path payment</b> operation.

By taking advantage of the decentralized exchange built in at the protocol level, a path payment combines the conversion and transfer of assets It's one of Stellar's most powerful features.</td>
  </tr>
  <tr>
    <td rowspan="8">Foundation Set 2</td>
    <td><a href="src/main/kotlin/set2/quest1.kt">Quest 1</a></td>
    <td></td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set2/quest2.kt">Quest 2</a></td>
    <td></td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set2/quest3.kt">Quest 3</a></td>
    <td></td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set2/quest4.kt">Quest 4</a></td>
    <td></td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set2/quest5.kt">Quest 5</a></td>
    <td></td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set2/quest6.kt">Quest 6</a></td>
    <td></td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set2/quest7.kt">Quest 7</a></td>
    <td></td>
  </tr>
  <tr>
    <td><a href="src/main/kotlin/set2/quest8.kt">Quest 8</a></td>
    <td></td>
  </tr>
</tbody>
</table>
