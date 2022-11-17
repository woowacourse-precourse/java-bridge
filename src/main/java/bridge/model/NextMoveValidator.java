package bridge.model;

public class NextMoveValidator implements Validator {
    @Override
    public void validateInput(String input) {
        if (GameMove.find(input).equals(GameMove.NOT_FOUND)) {
            throw new IllegalArgumentException();
        }
    }
}
