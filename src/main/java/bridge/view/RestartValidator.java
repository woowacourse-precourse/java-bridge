package bridge.view;

public class RestartValidator implements Validator{

    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    @Override
    public void validate(String str) {
        if (!str.equals(RESTART) && !str.equals(QUIT)) {
            throw new IllegalArgumentException(ViewError.PREFIX +
                    ViewError.ERROR_RESTART);
        }
    }
}
