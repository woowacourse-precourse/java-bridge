package bridge;

public class Player {
    private static final String MOVING_ERROR = "[ERROR] U와 D 중에 입력해주세요.";

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
        return moving.readGameCommand();
    }

    private boolean validateMoving(String input) {
        if(input.equals("U") || input.equals("D")) {
            return true;
        }
        return false;
    }
}
