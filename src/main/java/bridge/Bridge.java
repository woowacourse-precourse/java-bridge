package bridge;

import exceptionHandler.BridgeGenerationException;

import java.util.List;

public class Bridge {
    private final List<String> movableSides;

    public Bridge(List<String> movableSides) {
        validate(movableSides);
        this.movableSides = movableSides;
    }

    private void validate(List<String> movableSides) {
        BridgeGenerationException.validate(movableSides);
    }

    private int getLastIndex() {
        return movableSides.size() - 1;
    }

    public boolean isMovable(String selectedSides, int nextPosition) {
        return movableSides.get(nextPosition).equals(selectedSides);
    }

    public String getMovableSide(int bridgeIndex) {
        return movableSides.get(bridgeIndex);
    }

    public boolean isLastPosition(int playerPosition) {
        return getLastIndex() == playerPosition;
    }
}
