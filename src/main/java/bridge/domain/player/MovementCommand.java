package bridge.domain.player;

import bridge.view.InputException;
import bridge.view.InputValidator;

public class MovementCommand implements InputValidator {

	private static final String UPPER_SIDE_MOVEMENT = "U";
	private static final String UNDER_SIDE_MOVEMENT = "D";

	private final String movement;

	public MovementCommand(String movement) {
		validate(movement);
		this.movement = movement;
	}

	public static MovementCommand valueOf(String movement) {        //TODO : VALIDATION과 "U" or "D" 리턴을 getter 없이 할 수 있는 방법에 대해 고민
		return new MovementCommand(movement);
	}

	@Override
	public void validate(String inputMovement) {
		isAssignedCommand(inputMovement);
	}

	private void isAssignedCommand(String movement) {
		if (!movement.equals(UPPER_SIDE_MOVEMENT) && !movement.equals(UNDER_SIDE_MOVEMENT)) {
			throw new InputException(InputException.MOVEMENT_NOT_ASSIGNED_COMMAND);
		}
	}

	public String side() {
		return movement;
	}

	@Override
	public void validate(Integer value) {
	}
}
