public class PrimeFinder {
    private PrimeFinderThread[] processors;
    private int primes = 0;

    public PrimeFinder(int start, int end, int threads){
        processors = new PrimeFinderThread[threads];
        // ensures start is odd
        if(start % 2 == 0){
            start++;
        }
        for(int i = 0; i < threads; i++){
            processors[i] = new PrimeFinderThread(
                    (start + (i * 2)),
                    end,
                    (threads * 2),
                    this
            );
        }
    }

    public int start(){
        // start all threads
        for(int i = 0; i < processors.length; i++){
            processors[i].start();
        }
        // wait for all threads to finish
        for(int i = 0; i < processors.length; i++){
            try{
                processors[i].join();
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        return this.primes;
    }

    public synchronized void increment(){
        primes++;
    }
}