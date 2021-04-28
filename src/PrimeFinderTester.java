public class PrimeFinderTester {
    public static void main(String[] args){
        for(int i = 1; i <= 4; i++){
            PrimeFinder test = new PrimeFinder(1000000, 2000000, i);
            long before = System.nanoTime();
            int primes = test.start();
            long after = System.nanoTime();
            System.out.println(
                    i + " thread(s) found " + primes + " primes and took " +
                            ((after - before)/1000000) + " milliseconds"
                    );
        }
    }
}
