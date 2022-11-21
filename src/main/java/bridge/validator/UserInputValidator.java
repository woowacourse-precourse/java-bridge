package bridge.validator;

import static bridge.validator.ErrorMessage.*;

import java.util.regex.Pattern;

public class UserInputValidator {
	private static final Pattern movePattern = Pattern.compile("[D,U]");
	private static final Pattern decisionPattern = Pattern.compile("[R,Q]");

	public String runMoveInputValidator(String move) throws IllegalArgumentException {
		if (isInvalidInput(movePattern, move)) {
			throw new IllegalArgumentException(MOVE_INPUT.getMessage());
		}
		return move;
	}

	public String runDecisionValidator(String decision) throws IllegalArgumentException {
		if (isInvalidInput(decisionPattern, decision)) {
			throw new IllegalArgumentException(DECISION_INPUT.getMessage());
		}
		return decision;
	}

	private boolean isInvalidInput(Pattern pattern, String inputData) {
		return !pattern.matcher(inputData).matches();
	}
}
