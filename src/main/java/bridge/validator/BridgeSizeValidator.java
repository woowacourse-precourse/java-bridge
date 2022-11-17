package bridge.validator;

import bridge.GameRule;
import bridge.exception.ErrorMessage;

public class BridgeSizeValidator {

	private String size;

	public BridgeSizeValidator(String size) {
		this.size = size;
	}

	public void validate() {
		isNumber();
		isRightRange();
	}

	private void isNumber(){
		final String REGEX = "[0-9]+";
		if (!size.matches(REGEX)) {
			 throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
		}
	}

	private void isRightRange(){
		int size = Integer.parseInt(this.size);
		if (size< GameRule.MIN_BRIDGE_LENGTH || size> GameRule.MAX_BRIDGE_LENGTH){
			throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_RANGE_ERROR.getMessage());
		}
	}

	public String getSize() {
		return size;
	}
}
