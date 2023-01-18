package frameless

import org.scalatest.matchers.should.Matchers

object EncoderTests {
  case class Foo(s: Seq[(Int, Int)])
  case class InstantRow(i: java.time.Instant)
  case class DurationRow(d: java.time.Duration)
  case class PeriodRow(p: java.time.Period)
  case class ValueClass(d: Double) extends AnyVal
  case class UsingTuple(v: (ValueClass, Double))
}

class EncoderTests extends TypedDatasetSuite with Matchers {
  import EncoderTests._

  test("It should encode deeply nested collections") {
    implicitly[TypedEncoder[Seq[Foo]]]
  }

  test("It should encode java.time.Instant") {
    implicitly[TypedEncoder[InstantRow]]
  }

  test("It should encode java.time.Duration") {
    implicitly[TypedEncoder[DurationRow]]
  }

  test("It should encode java.time.Period") {
    implicitly[TypedEncoder[PeriodRow]]
  }

  test("It should encode Tuple2") {
    implicitly[TypedEncoder[UsingTuple]]
  }

  test("It should encode Tuple5") {
    implicitly[TypedEncoder[(Int, String, Double, Long, Byte)]]
  }
}
