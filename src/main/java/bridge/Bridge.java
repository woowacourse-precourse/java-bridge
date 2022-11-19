package bridge;

import java.util.List;

public class Bridge {
    private final List<String> availableSquares;

    public Bridge(List<String> availableSquares) {
        this.availableSquares = availableSquares;
    }

    public boolean isNextAvailable(String selectedSquare, int nextPosition) {
        return availableSquares.get(nextPosition).equals(selectedSquare);
    }

    public int getLastIndex() {
        return availableSquares.size() - 1;
    }

}
