package bridge.view;

public class MoveValidator implements Validator{

    private static final String UP = "U";
    private static final String DOWN = "D";
    @Override
    public void validate(String str) {
        if (!str.equals(UP) && !str.equals(DOWN)) {
            throw new IllegalArgumentException(ViewError.PREFIX +
                    ViewError.ERROR_MOVE);
        }
    }
}
