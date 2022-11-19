package bridge;

public class InputValidator {

    public static int validateInputBridgeLength(String inputLength){
        int bridgeLength = toInt(inputLength);
        validateBridgeLength(bridgeLength);
        return bridgeLength;
    }

    public static int toInt (String inputLength){
        return Integer.parseInt(inputLength);
    }

    public static void validateBridgeLength(int inputLength){
        if(inputLength < 3 || inputLength > 20 ){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3에서 20 사이로 입력해주세요. ");
        }
    }
}
