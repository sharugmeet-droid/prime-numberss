fun sieveOfEratosthenes(limit: Int): List<Int> {
    if (limit < 2) return emptyList()

    // Initialize a boolean array to track prime numbers
    val isPrime = BooleanArray(limit + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    // Start marking multiples as non-prime
    for (number in 2..kotlin.math.sqrt(limit.toDouble()).toInt()) {
        if (isPrime[number]) {
            for (multiple in number * number..limit step number) {
                isPrime[multiple] = false
            }
        }
    }

    // Collect all prime numbers
    return isPrime.indices.filter { isPrime[it] }
}

fun main() {
    val limit = 50
    val primes = sieveOfEratosthenes(limit)
    println("Prime numbers up to $limit: $primes")
}
