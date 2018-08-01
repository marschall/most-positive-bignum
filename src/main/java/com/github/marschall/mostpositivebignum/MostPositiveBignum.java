package com.github.marschall.mostpositivebignum;

import java.math.BigInteger;
import java.util.Arrays;

import org.openjdk.jol.info.GraphLayout;

public class MostPositiveBignum {

  private static final int MAX_MAG_LENGTH = 67_108_864 * 4; // 16_777_216

  public static void main(String[] args) {
    BigInteger mostPositiveBigNum = findMostPositiveBigNum();
    GraphLayout graphLayout = GraphLayout.parseInstance(mostPositiveBigNum);
//    System.out.println(graphLayout.toPrintable());
    System.out.println(graphLayout.toFootprint());
//    System.out.println(mostPositiveBigNum);
  }

  private static BigInteger findMostPositiveBigNum() {
    byte[] twosComplement = new byte[MAX_MAG_LENGTH];
    twosComplement[0] = 0b01111111;
    Arrays.fill(twosComplement, 1, twosComplement.length, (byte) 0b11111111);
    BigInteger mostPositiveBignum = new BigInteger(twosComplement);
    try {
      mostPositiveBignum.add(BigInteger.ONE);
      throw new AssertionError("not most-positive-bignum");
    } catch (ArithmeticException e) {
      return mostPositiveBignum;
    }
  }

}