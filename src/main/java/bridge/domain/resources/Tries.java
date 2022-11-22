package bridge.domain.resources;

public class Tries {

    private static final int FIRST_TRY = 1;

    private int tries;

    public Tries() {
        this.tries = FIRST_TRY;
    }

    public void oneMoreTry() {
        tries++;
    }

    public int getTries() {
        return tries;
    }

    public void initializeTries() {
        this.tries = FIRST_TRY;
    }
}
