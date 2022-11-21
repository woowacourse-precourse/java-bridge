package bridge;

import java.util.Objects;

public class Validator {
	public static void validateBridgeSize (String bridgeSize){
		try {
			int parseIntBridgeSize = Integer.parseInt(bridgeSize);
			if(parseIntBridgeSize < 3 || parseIntBridgeSize >20){
				throw new IllegalArgumentException();
			}
		}catch(Exception e){
			throw e;
		};
	}

	public static void validateMoving (String moving){
		if(!Objects.equals(moving, "U") && !Objects.equals(moving, "D")){
			throw new IllegalArgumentException();
		}
	}

	public static void validateIsRestart (String isRestart){
		if(!Objects.equals(isRestart, "R") && !Objects.equals(isRestart, "Q")){
			throw new IllegalArgumentException();
		}
	}
}
