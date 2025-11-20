package com.oxyjiang.commons.libhashextend;

import java.nio.charset.StandardCharsets;

public class FNVHash {
  private static final long INIT64 = 0xcbf29ce484222325L;
  private static final long PRIME64 = 0x00000100000001b3L;
  private static final int INIT32 = 0x811c9dc5;
  private static final int PRIME32 = 0x01000193;

  /**
   * Returns a 64-bit hash value.
   *
   * @return 64-bit hash value
   */
  public static long hash64UTF8(String input, FNVVersion type) {
    return hash64(input.getBytes(StandardCharsets.UTF_8), type);
  }

  /**
   * Returns a 64-bit hash value.
   *
   * @return 64-bit hash value
   */
  public static long hash64(byte[] input, FNVVersion type) {
    long hash = INIT64;
    for (byte b : input) {
      if (type == FNVVersion.FNV1) {
        hash *= PRIME64;
        hash ^= b;
      }
      if (type == FNVVersion.FNV1A) {
        hash ^= b;
        hash *= PRIME64;
      }
    }
    return hash;
  }

  /**
   * Returns a 32-bit hash value.
   *
   * @return 32-bit hash value
   */
  public static int hash32UTF8(String input, FNVVersion type) {
    return hash32(input.getBytes(StandardCharsets.UTF_8), type);
  }

  /**
   * Returns a 32-bit hash value.
   *
   * @return 32-bit hash value
   */
  public static int hash32(byte[] input, FNVVersion type) {
    int hash = INIT32;
    for (byte b : input) {
      if (type == FNVVersion.FNV1) {
        hash *= PRIME32;
        hash ^= b;
      }
      if (type == FNVVersion.FNV1A) {
        hash ^= b;
        hash *= PRIME32;
      }
    }
    return hash;
  }

  public enum FNVVersion {
    FNV1,
    FNV1A
  }
}
