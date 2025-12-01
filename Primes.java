public class Primes {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        boolean [] primeCheck = new boolean[n + 1];

        // initializes boolean array and marks all numbers as true
        for (int i = 2; i <= n; i++) {
            
            primeCheck[i] = true;
        }

        // checks if a number has a prime multiple other than itself or 1
        for (int j = 2; j * j <= n; j++) {
            
            if (primeCheck[j] == true) {
                for (int z = j * j; z <=n; z += j) {
                    primeCheck[z] = false;
                }
            }
        }

        // prints the prime numbers in given array
        int sum = 0;
        int primeCount = 0;

        for (int x = 0; x <= n; x++) {
            if (primeCheck[x] == true) {
                primeCount++;
                sum += x;
                System.out.println(x);
            }
        }

        double average = (double)(sum / primeCheck.length);
        System.out.println("There are " + primeCount + " primes between 2 and " + args[0] + " (" + average + "% are primes)");

    }
}