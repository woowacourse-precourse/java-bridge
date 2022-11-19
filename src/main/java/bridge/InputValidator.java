package bridge;

public class InputValidator {

    static String regExp = "[A-Z]";

    public static int validateInputBridgeLength(String inputLength){
        int bridgeLength = toInt(inputLength);
        validateBridgeLength(bridgeLength);
        return bridgeLength;
    }

    public static String validateInputMoveCommande(String inputMoveCommande){
        validateCommandeLength(inputMoveCommande);
        validateCommandUppercase(inputMoveCommande);
        return inputMoveCommande;
    }

    public static int toInt (String inputLength){
        return Integer.parseInt(inputLength);
    }

    public static void validateBridgeLength(int inputLength){
        if(inputLength < 3 || inputLength > 20 ){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3에서 20 사이로 입력해주세요. ");
        }
    }

    public static void validateCommandeLength(String inputMoveCommande){
        if(!(inputMoveCommande.length() == 1)){
            throw new IllegalArgumentException("[ERROR]명령어는 U 또는 R로 입력해 주세요.");
        }
    }

    public static void validateCommandUppercase(String inputMoveCommande){
        if(inputMoveCommande.matches(regExp)){
            throw new IllegalArgumentException("[ERROR]명령어는 대문자로 입력 해 주세요.");
        }
    }

}
