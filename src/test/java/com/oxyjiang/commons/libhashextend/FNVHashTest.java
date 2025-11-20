package com.oxyjiang.commons.libhashextend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FNVHashTest {
  @Test
  void hashStringFunctions() {
    String case1 = "foo";
    String case2 = "The quick brown fox jumps over a lazy dog";
    long expected_hash_l1_1 = 0xd8cbc7186ba13533L;
    long expected_hash_l1_1a = 0xdcb27518fed9d577L;
    long expected_hash_l2_1 = 0x3dd095620f468e1eL;
    long expected_hash_l2_1a = 0xf8f0f1ee98d3ea10L;
    int expected_hash_s1_1 = 0x408f5e13;
    int expected_hash_s1_1a = 0xa9f37ed7;
    int expected_hash_s2_1 = 0x3b8f3abe;
    int expected_hash_s2_1a = 0xaeee1790;

    Assertions.assertEquals(expected_hash_l1_1, FNVHash.hash64UTF8(case1, FNVHash.FNVVersion.FNV1));
    Assertions.assertEquals(
        expected_hash_l1_1a, FNVHash.hash64UTF8(case1, FNVHash.FNVVersion.FNV1A));
    Assertions.assertEquals(expected_hash_l2_1, FNVHash.hash64UTF8(case2, FNVHash.FNVVersion.FNV1));
    Assertions.assertEquals(
        expected_hash_l2_1a, FNVHash.hash64UTF8(case2, FNVHash.FNVVersion.FNV1A));
    Assertions.assertEquals(expected_hash_s1_1, FNVHash.hash32UTF8(case1, FNVHash.FNVVersion.FNV1));
    Assertions.assertEquals(
        expected_hash_s1_1a, FNVHash.hash32UTF8(case1, FNVHash.FNVVersion.FNV1A));
    Assertions.assertEquals(expected_hash_s2_1, FNVHash.hash32UTF8(case2, FNVHash.FNVVersion.FNV1));
    Assertions.assertEquals(
        expected_hash_s2_1a, FNVHash.hash32UTF8(case2, FNVHash.FNVVersion.FNV1A));
  }
}
