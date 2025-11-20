package com.oxyjiang.commons.libhashextend;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JenkinsHashTest {
  @Test
  void hashStringFunctions() {
    String case1 = "";
    String case2 = "Four score and seven years ago";
    long expected_hash_l1 = 0xdeadbeefdeadbeefL;
    long expected_hash_l2 = 0x17770551ce7226e6L;
    int expected_hash_s1 = 0xdeadbeef;
    int expected_hash_s2 = 0x17770551;

    Assertions.assertEquals(expected_hash_l1, JenkinsHash.hash64UTF8(case1));
    Assertions.assertEquals(expected_hash_l2, JenkinsHash.hash64UTF8(case2));
    Assertions.assertEquals(expected_hash_s1, JenkinsHash.hash32UTF8(case1));
    Assertions.assertEquals(expected_hash_s2, JenkinsHash.hash32UTF8(case2));
  }

  @Test
  void innerHashFunctions() {
    String input = "Four score and seven years ago";
    long expected_hash_l1 = 0x17770551ce7226e6L;
    long expected_hash_l2 = 0xe3607caebd371de4L;
    long expected_hash_l3 = 0xcd6281616cbea4b3L;
    int expected_hash_s1 = 0x17770551;
    int expected_hash_s2 = 0xcd628161;

    Assertions.assertEquals(
        expected_hash_l1,
        JenkinsHash.hashLittle2(input.getBytes(StandardCharsets.UTF_8), input.length(), 0, 0));
    Assertions.assertEquals(
        expected_hash_l2,
        JenkinsHash.hashLittle2(input.getBytes(StandardCharsets.UTF_8), input.length(), 0, 1));
    Assertions.assertEquals(
        expected_hash_l3,
        JenkinsHash.hashLittle2(input.getBytes(StandardCharsets.UTF_8), input.length(), 1, 0));
    Assertions.assertEquals(
        expected_hash_s1,
        JenkinsHash.hashLittle(input.getBytes(StandardCharsets.UTF_8), input.length(), 0));
    Assertions.assertEquals(
        expected_hash_s2,
        JenkinsHash.hashLittle(input.getBytes(StandardCharsets.UTF_8), input.length(), 1));
  }
}
