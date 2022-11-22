package bridge;

import java.util.List;

public class Bridge {

    public static final String PASS_POSSIBILITY = "O";
    public static final String PASS_IMPOSSIBILITY = "X";

    private final List<String> bridgeLine;

    public Bridge(List<String> bridgeLine) {
        this.bridgeLine = bridgeLine;
    }

    public boolean isMove(int count) {
        return this.bridgeLine.get(count).equals(PASS_POSSIBILITY);
    }

    public void addMovePossibility() {
        this.bridgeLine.add(PASS_POSSIBILITY);
    }

    public void addMoveImpossibility() {
        this.bridgeLine.add(PASS_IMPOSSIBILITY);
    }

    public List<String> getBridgeLine() {
        return this.bridgeLine;
    }

}
