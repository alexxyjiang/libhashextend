# libhashextend

A Java library providing implementations of specialized hash functions.
- FNV (Fowler-Noll-Vo)
- Jenkins

## Hash Functions Included

### FNV Hash

Implementation of the FNV (Fowler-Noll-Vo) hash function with support for both FNV-1 and FNV-1a variants.

**Features:**
- 32-bit and 64-bit hash output
- FNV-1 and FNV-1a algorithm variants
- Support for byte arrays and UTF-8 strings

**Usage:**
```java
import com.oxyjiang.commons.libhashextend.FNVHash;

// 64-bit hash
long hash64 = FNVHash.hash64UTF8("hello world", FNVHash.FNVVersion.FNV1A);
long hash64Bytes = FNVHash.hash64(data, FNVHash.FNVVersion.FNV1);

// 32-bit hash
int hash32 = FNVHash.hash32UTF8("hello world", FNVHash.FNVVersion.FNV1A);
int hash32Bytes = FNVHash.hash32(data, FNVHash.FNVVersion.FNV1);
```

### Jenkins Hash

Implementation of Bob Jenkins' hash function (also known as "lookup3").

**Features:**
- 32-bit and 64-bit hash output
- Compatible with the original C implementation
- Support for incremental hashing with offset parameters

**Usage:**
```java
import com.oxyjiang.commons.libhashextend.JenkinsHash;

// Simple hashing
long hash64 = JenkinsHash.hash64UTF8("hello world");
int hash32 = JenkinsHash.hash32UTF8("hello world");

// Advanced usage with offsets (compatible with original C implementation)
int hash = JenkinsHash.hashLittle(data, length, primaryOffset);
long hash = JenkinsHash.hashLittle2(data, length, primaryOffset, secondaryOffset);
```
