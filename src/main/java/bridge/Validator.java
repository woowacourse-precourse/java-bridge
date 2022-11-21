package bridge;

import java.util.Objects;

public class Validator {
	public static void validateBridgeSize (String bridgeSize){
		try{
			int parseIntBridgeSize = Integer.parseInt(bridgeSize);
			if(parseIntBridgeSize < 3 || parseIntBridgeSize >20){
				throw new IllegalArgumentException(ErrorMessage.errorMessage.ONLY_INPUT_BETWEEN_3_20.getValue());
			}
		}catch (NumberFormatException e){
			throw new IllegalArgumentException(ErrorMessage.errorMessage.ONLY_INPUT_INTEGER.getValue());
		};

	}
	public static void validateMoving (String moving){
		if(!Objects.equals(moving, "U") && !Objects.equals(moving, "D")){
			throw new IllegalArgumentException(ErrorMessage.errorMessage.ONLY_INPUT_U_AND_D.getValue());
		}
	}

	public static void validateIsRestart (String isRestart){
		if(!Objects.equals(isRestart, "R") && !Objects.equals(isRestart, "Q")){
			throw new IllegalArgumentException((ErrorMessage.errorMessage.ONLY_INPUT_R_AND_Q.getValue()));
		}
	}
}
