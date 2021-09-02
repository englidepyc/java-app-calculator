package company;

public class MyMath {
    private MyMath(){}

    public static int printlnTheNPrime(int n){
        int [] primes = new int [n];
        primes [0] = 2;
        int number = 3;
        int primeCounter = 1;
        boolean isPrime = true;

        while (primeCounter < n){
            isPrime = true;

            for(int i = 0; i < primeCounter; ++i) {
                if (number % primes[i] == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                primes[primeCounter] = number;
                ++primeCounter;
                ++number;
            }
            else{
                ++number;
            }

        }

        System.out.println(primes[n-1]);
        return number-1;
    }

}
