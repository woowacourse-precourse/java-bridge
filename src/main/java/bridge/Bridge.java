package bridge;

import java.util.List;

public class Bridge {
    private final List<String> movableSides;

    public Bridge(List<String> movableSides) {
        this.movableSides = movableSides;
    }

    public boolean isAvailableToMove(String selectedSides, int nextPosition) {
        return movableSides.get(nextPosition).equals(selectedSides);
    }

    public int getLastIndex() {
        return movableSides.size() - 1;
    }

    public String getMovableSide(int bridgeIndex) {
        return movableSides.get(bridgeIndex);
    }

}
