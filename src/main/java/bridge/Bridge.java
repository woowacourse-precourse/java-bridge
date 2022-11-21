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

    public boolean isMovableSide(String selectedSides, int position) {
        return movableSides.get(position).equals(selectedSides);
    }

    public boolean isLastPosition(int playerPosition) {
        return getLastIndex() == playerPosition;
    }
}
