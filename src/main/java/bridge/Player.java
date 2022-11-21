package bridge;

public class Player {
    private static final String MOVING_ERROR = "[ERROR] U와 D 중에 입력해주세요.";
    private static final String RETRY_ERROR = "[ERROR] R과 Q 중에 입력해주세요.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private InputView moving;
    public Player() {
        moving = new InputView();
    }

    public String move() {
        try {
            String input = moving.readMoving();
            if (!validateMoving(input)) {
                throw new IllegalArgumentException();
            }
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(MOVING_ERROR);
            return move();
        }
    }

    public String retry() {
        try {
            String input = moving.readGameCommand();
            if(!validateRetry(input)) {
                throw new IllegalArgumentException();
            }
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(RETRY_ERROR);
            return retry();
        }
    }

    protected boolean validateMoving(String input) {
        if(input.equals(UP) || input.equals(DOWN)) {
            return true;
        }
        return false;
    }

    protected boolean validateRetry(String input) {
        if(input.equals(RETRY) || input.equals(QUIT)) {
            return true;
        }
        return false;
    }
}
