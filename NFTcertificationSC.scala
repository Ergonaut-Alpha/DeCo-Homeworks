package ErgoscriptSC

object NFTcertificationSC {

  import org.ergoplatform.compiler.ErgoScalaCompiler._
  import org.ergoplatform.playgroundenv.utils.ErgoScriptCompiler
  import org.ergoplatform.playground._
  import org.ergoplatform.Pay2SAddress
  import sigmastate.eval.Extensions._
  import scorex.crypto.hash.{Blake2b256}

  // importing of blockchain basics above

  //Tx1 input and output boxes below

  val StandardInputBox = Box(
    val HasSufficientValue = Value > (MinTxFee + MinBoxValue)
  )

  val MinerFeeBox = Box(Value = MinTxFee)

  val RosterBox = Box(
    val StudentPK = SELF.R4[Coll[Byte]]
    val CourseInformation = SELF.R5[Coll[String]]
    val TeamInformation = SELF.R6[Coll[String]]
  )

  val StudentSpendingBox = Box(
    val HasSufficientValue = Value > (MinTxFee + MinBoxValue)
  )

  val CertificationBox = Box(
    val VerboseName = SELF.R4[coll[Byte]]
    val TokenDescription = SELF.R5[Coll[Byte]]
    val NumberofDecimals = SELF.R6[Coll[Byte]]
    val AssetType = SELF.R7[Coll[Byte]]
    val HashofPicture = SELF.R8[Coll[Byte]]
    val LinktoArtwork= SELF.R9[Coll[Byte]]
  )

  // Modeling of the boxes shown above

  val RegistrationTransaction= Transaction(
    inputs = StandardInputBox
    outputs = List(RosterBox, MinerFeeBox)
    fee = MinTxFee
    sendChangeTo = SELF.wallet.getAddress
    )

  val CertificationMintTransaction = Transaction(
    inputs = RosterBox
    outputs = List(CertificationBox, MinerFeeBox)
    fee = MinTxFee
    sendChangeTo = SELF.wallet.getAddress
  )

  //Build transaction shown above (enrollment & graduation mint)



  //Proof and Signing of the transaction model shown above

}
