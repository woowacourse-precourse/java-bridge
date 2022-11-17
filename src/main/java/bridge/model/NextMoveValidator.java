package bridge.model;

public class NextMoveValidator implements Validator {
    @Override
    public void validateInput(String input) {
        if (!input.equals(GameMove.UP.getLetter()) || !input.equals(GameMove.DOWN.getLetter())) {
            throw new IllegalArgumentException();
        }
    }
}
