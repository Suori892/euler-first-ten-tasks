import java.math.BigInteger;

public class Solution {

    private static String NUMBER_TASK_8 = "73167176531330624919225119674426574742355349194934\n" +
            "96983520312774506326239578318016984801869478851843\n" +
            "85861560789112949495459501737958331952853208805511\n" +
            "12540698747158523863050715693290963295227443043557\n" +
            "66896648950445244523161731856403098711121722383113\n" +
            "62229893423380308135336276614282806444486645238749\n" +
            "30358907296290491560440772390713810515859307960866\n" +
            "70172427121883998797908792274921901699720888093776\n" +
            "65727333001053367881220235421809751254540594752243\n" +
            "52584907711670556013604839586446706324415722155397\n" +
            "53697817977846174064955149290862569321978468622482\n" +
            "83972241375657056057490261407972968652414535100474\n" +
            "82166370484403199890008895243450658541227588666881\n" +
            "16427171479924442928230863465674813919123162824586\n" +
            "17866458359124566529476545682848912883142607690042\n" +
            "24219022671055626321111109370544217506941658960408\n" +
            "07198403850962455444362981230987879927244284909188\n" +
            "84580156166097919133875499200524063689912560717606\n" +
            "05886116467109405077541002256983155200055935729725\n" +
            "71636269561882670428252483600823257530420752963450";

    //answer 233168
    public static int task1() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    //answer 4613732
    public static int task2() {
        int firstDigit = 1;
        int secondDigit = 2;
        int sum = 0;

        while (firstDigit < 4_000_000) {
            if (firstDigit % 2 == 0) {
                sum += firstDigit;
            }

            int thirdDigit = firstDigit + secondDigit;
            firstDigit = secondDigit;
            secondDigit = thirdDigit;
        }

        return sum;
    }

    //answer 6857
    public static long task3() {
        long num =  600851475143L;

        while (true) {
            long p = smallestFactor(num);

            if (p < num) {
                num /= p;
            } else {
                return num;
            }
        }
    }

    private static long smallestFactor(long num) {
        if (num <= 1) throw new IllegalArgumentException("argument must be more than 1");

        for (long i = 2, end = (long) Math.sqrt(num); i <= end; i++) {
            if (num % i == 0)
                return i;
        }
        return num;
    }

    //answer 906609
    public static int task4() {
        int maxPalindrome = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int prod = i * j;
                if (isPalindrome(prod) && prod > maxPalindrome) maxPalindrome = prod;
            }
        }
        return maxPalindrome;
    }

    private static boolean isPalindrome(int n) {
        String intStr = String.valueOf(n);
        return intStr.equals(new StringBuilder(intStr).reverse().toString());
    }

    //answer 232792560
    public static BigInteger task5() {
        BigInteger allLcm = BigInteger.ONE;
        for (int i = 1; i <= 20; i++)
            allLcm = lcm(BigInteger.valueOf(i), allLcm);
        return allLcm;
    }

    private static BigInteger lcm(BigInteger x, BigInteger y) {
        return x.divide(x.gcd(y)).multiply(y);
    }

    //answer 25164150
    public static int task6() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 1; i <= 100; i++) {
            sum1 += i;
            sum2 += i * i;
        }

        return sum1 * sum1 - sum2;
    }

    //answer 104743
    public static int task7() {
      for (int i = 2, count = 0; ; i++) {
          if (isPrime(i)) {
              count++;
              if (count == 10001) return i;
          }
      }
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i < num; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    //answer 5377010688
    public static long task8() {
        long maxProd = -1;
        int adj = 13;

        for (int i = 0; i + adj <= NUMBER_TASK_8.length(); i++) {
            long prod = 1;
            for (int j = 0; j < adj; j++)
                prod *= NUMBER_TASK_8.charAt(i + j) - '0';
            maxProd = Math.max(prod, maxProd);
        }

        return maxProd;
    }

    //answer 31875000
    public static int task9() {
        int num = 1000;
        int ans = 0;
        for (int a = 1; a < num; a++) {
            for (int b = a + 1; b < num; b++) {
                int c = num - a - b;
                if (a * a + b * b == c * c) {
                    ans = a * b * c;
                }
            }
        }
        return ans;
    }

    //answer 142913828922
    public static long task10() {
        int limit = 2_000_000;
        long sum = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) sum += i;
        }
        return sum;
    }
}
