package bridge.domain;

public class NumberOfTry {
    private final int numberOfTry;
    
    public NumberOfTry() {
        this(1);
    }
    
    public NumberOfTry(final int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }
    
    public NumberOfTry increase() {
        return new NumberOfTry(numberOfTry + 1);
    }
    
    public int numberOfTry() {
        return numberOfTry;
    }
}
