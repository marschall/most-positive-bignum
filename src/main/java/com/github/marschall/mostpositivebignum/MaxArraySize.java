package com.github.marschall.mostpositivebignum;

public class MaxArraySize {

  public static void main(String[] args) {
    printMaxArraySize();
  }

  private static void printMaxArraySize() {
    int maxArraySize = findMaxArraySize();
    System.out.println("max array size: " + maxArraySize);
    System.out.println("max array size - Integer.MAX_VALUE: " + (Integer.MAX_VALUE - maxArraySize));
  }

  private static int findMaxArraySize() {
    for (int i = Integer.MAX_VALUE; i >= 0; i--) {
      try {
        byte[] data = new byte[i];
        if (System.identityHashCode(data) == 42) {
          System.out.println();
        }
        return i;
      } catch (OutOfMemoryError e) {
        // ignore
      }
    }
    throw new AssertionError("not able to create a byte[0]");
  }

}
