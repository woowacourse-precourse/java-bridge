package bridge;

public class BridgeException {
	public void checkBridgeSize(String userInputSize) throws IllegalArgumentException {
		if (Integer.parseInt(userInputSize) < Constant.NUMBER_RANGE_THREE
			|| Integer.parseInt(userInputSize) > Constant.NUMBER_RANGE_TWENTY) {
			throw new IllegalArgumentException(Constant.NUMBER_OVERLAP_ERROR);
		}
	}
}