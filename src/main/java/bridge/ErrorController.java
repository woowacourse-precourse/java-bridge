package bridge;

public class ErrorController {
	public static void checkBridgeSize (String bridgeSize){
		try {
			int parseIntBridgeSize = Integer.parseInt(bridgeSize);
			if(parseIntBridgeSize < 3 || parseIntBridgeSize >20){
				throw new IllegalArgumentException();
			}
		}catch(Exception e){
			throw e;
		};
	}
}
