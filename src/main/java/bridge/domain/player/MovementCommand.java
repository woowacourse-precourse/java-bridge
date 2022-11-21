package bridge.domain.player;

import bridge.view.input.InputException;
import bridge.view.input.InputValidator;
import bridge.view.output.OutputView;

public class MovementCommand implements InputValidator {

	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

	private static final String UPPER_SIDE_MOVEMENT = "U";
	private static final String UNDER_SIDE_MOVEMENT = "D";

	private final String movement;

	public MovementCommand(String movement) {
		validate(movement);
		this.movement = movement;
	}

	public static MovementCommand valueOf(String movement) {
		OutputView.withContentOf(REQUEST_MOVEMENT, true, false).ConsoleMessage();
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
