package bridge.domain;

public class NumberOfTry {
    public static final int FIRST_NUMBER_OF_TRY = 1;
    
    private final int numberOfTry;
    
    public NumberOfTry() {
        this(FIRST_NUMBER_OF_TRY);
    }
    
    private NumberOfTry(final int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }
    
    public NumberOfTry increase() {
        return new NumberOfTry(numberOfTry + FIRST_NUMBER_OF_TRY);
    }
    
    public int numberOfTry() {
        return numberOfTry;
    }
    
    @Override
    public String toString() {
        return "NumberOfTry{" +
                "numberOfTry=" + numberOfTry +
                '}';
    }
}
