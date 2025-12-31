# Sieve of Eratosthenes – Kotlin

This Kotlin program efficiently finds all **prime numbers** up to a given limit using the **Sieve of Eratosthenes** algorithm.

---

## How It Works

1. Initialize a **boolean array** `isPrime` of size `limit + 1` to track prime numbers.
2. Set `0` and `1` as non-prime.
3. Iterate from `2` to `√limit`:
   - If the number is prime, mark all its **multiples as non-prime**.
4. Collect all numbers still marked as prime.

This approach ensures **efficient prime generation** without checking every number individually.

---

## Implementation

``kotlin
fun sieveOfEratosthenes(limit: Int): List<Int> {
    if (limit < 2) return emptyList()
    val isPrime = BooleanArray(limit + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (number in 2..kotlin.math.sqrt(limit.toDouble()).toInt()) {
        if (isPrime[number]) {
            for (multiple in number * number..limit step number) {
                isPrime[multiple] = false
            }
        }
    }

    return isPrime.indices.filter { isPrime[it] }
}

fun main() {
    val limit = 50
    val primes = sieveOfEratosthenes(limit)
    println("Prime numbers up to $limit: $primes")
}
