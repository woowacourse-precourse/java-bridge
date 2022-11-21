package exception;

import message.ErrorMessage;
import view.OutputView;

public class MovingException {
    private final String moving;
    OutputView outputView = new OutputView();

    public MovingException(String moving) {
        validate(moving);
        this.moving = moving;
    }

    public void validate(String moving) {
        if(!(moving.equals("U") || moving.equals("D"))) {
            outputView.printError(ErrorMessage.Moving.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public String getMoving() {
        return moving;
    }
}
