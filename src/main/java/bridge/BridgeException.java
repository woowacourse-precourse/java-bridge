package bridge;

import java.util.regex.Pattern;

public class BridgeException {
	public void checkBridgeSize(String userInputSize) throws IllegalArgumentException {
		if (Integer.parseInt(userInputSize) < Constant.NUMBER_RANGE_THREE
			|| Integer.parseInt(userInputSize) > Constant.NUMBER_RANGE_TWENTY) {
			throw new IllegalArgumentException(Constant.NUMBER_OVERLAP_ERROR);
		}
	}

	public void checkBridgeSizeNumberMissMatch(String userInputSize) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", userInputSize)) {
			throw new IllegalArgumentException(Constant.NUMBER_MISSMATCH_ERROR);
		}
	}

	public void checkMissMatch(String userInputMove) throws IllegalArgumentException {
		if (!Pattern.matches("^[A-Z]*$", userInputMove)) {
			throw new IllegalArgumentException(Constant.SPELLING_MISSMATCH_ERROR);
		}
	}

	public void checkUserInputMove(String userInputMove) throws IllegalArgumentException {
		if (!userInputMove.equals(Constant.SPELLING_U) && !userInputMove.equals(Constant.SPELLING_D)) {
			throw new IllegalArgumentException(Constant.SPELLING_U_OR_D_MISSMATCH_ERROR);
		}
	}

	public void checkUsertryOrEnd(String userInputMove) throws IllegalArgumentException {
		if (!userInputMove.equals(Constant.SPELLING_R) && !userInputMove.equals(Constant.SPELLING_Q)) {
			throw new IllegalArgumentException(Constant.SPELLING_R_OR_Q_MISSMATCH_ERROR);
		}
	}
}