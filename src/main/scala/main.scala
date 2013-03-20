package bad

import java.security.Provider.Service
import java.security.{Provider, Security}
import java.security.SecureRandomSpi
import square.SquareRoot

object Main {

  Security.insertProviderAt(new BadProvider, 1)

  def main(args: Array[String]) {
    SquareRoot.answer(BigInt(1).bigInteger)
  }

}

class BadProvider extends Provider("bad-provider", 1, "evil shenanigans") {
  putService(new BadService(this))
}

class BadService(p: Provider) extends Service(
  p, "SecureRandom", "bad-algorithm", "bad.BadSecureRandom", null, null)

class BadSecureRandom extends SecureRandomSpi {
  def engineSetSeed(seed: Array[Byte]) {}
  def engineNextBytes(bytes: Array[Byte]) { bytes(bytes.size - 1) = 1.toByte }
  def engineGenerateSeed(numBytes: Int) = ???
}
