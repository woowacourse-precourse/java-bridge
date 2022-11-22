package validator;

import static view.InputViewConstants.ERROR_MESSAGE_WRONG_MOVING_INPUT;
import static view.InputViewConstants.MOVING_DOWN;
import static view.InputViewConstants.MOVING_UP;

public class MovingInputValidator {

	public String validateMoving(String moving) {
		if (moving.equals(MOVING_UP) || moving.equals(MOVING_DOWN)) {
			return moving;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_MOVING_INPUT);
	}
}