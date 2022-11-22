package bridge;

import exceptionHandler.BridgeGenerationException;

import java.util.List;

public class Bridge {
    private final List<String> movableSides;

    public Bridge(final List<String> movableSides) {
        validate(movableSides);
        this.movableSides = movableSides;
    }

    public boolean isMovableSide(final String selectedSides, final int position) {
        return movableSides.get(position).equals(selectedSides);
    }

    public boolean isLastPosition(final int playerPosition) {
        return getLastIndex() == playerPosition;
    }

    private void validate(final List<String> movableSides) {
        BridgeGenerationException.validate(movableSides);
    }

    private int getLastIndex() {
        return movableSides.size() - 1;
    }
}