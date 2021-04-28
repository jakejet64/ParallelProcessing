public class PrimeFinderThread extends Thread{
    private int start;
    private int end;
    private int increment;
    private PrimeFinder parent;

    public PrimeFinderThread(int starting, int ending, int increment, PrimeFinder parent){
        this.start = starting;
        this.end = ending;
        this.increment = increment;
        this.parent = parent;
    }

    public void run(){
        for(int testNum = start; testNum <= end; testNum += increment){
            boolean prime = true;
            for(int i = 2; i <= Math.sqrt(testNum); i++){
                if(testNum % i == 0){
                    prime = false;
                    i = testNum;
                }
            }
            if(prime){
                parent.increment();
            }
        }
    }
}
