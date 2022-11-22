package bridge.View;

public class InputValidator {

    static String UPPER_CASE = "(?=.*[A-Z])";
    static String ONLY_NUMBER = "[0-9]+";

    public static int validateInputBridgeLength(String inputLength) {
        checkOnlyNumber(inputLength);
        int bridgeLength = toInt(inputLength);
        validateBridgeLength(bridgeLength);
        return bridgeLength;
    }

    public static void validateInputMoveCommande(String inputMoveCommande) {
        validateCommandeLength(inputMoveCommande);
        validateCommandUppercase(inputMoveCommande);
        checkUorR(inputMoveCommande);
    }

    public static void validateInputRestartOrEndGame(String inputRestartOREndGame) {
        validateCommandeLength(inputRestartOREndGame);
        validateCommandUppercase(inputRestartOREndGame);
        checkRorQ(inputRestartOREndGame);
    }

    public static int toInt(String inputLength) {
        return Integer.parseInt(inputLength);
    }

    public static void validateBridgeLength(int inputLength) {
        if (inputLength < 3 || inputLength > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3에서 20 사이로 입력해주세요. ");
        }
    }

    public static void validateCommandeLength(String inputMoveCommande) {
        if (!(inputMoveCommande.length() == 1)) {
            throw new IllegalArgumentException("[ERROR]명령어는 한글자입니다. ");
        }
    }

    public static void validateCommandUppercase(String inputMoveCommande) {
        if (inputMoveCommande.matches(UPPER_CASE)) {
            throw new IllegalArgumentException("[ERROR]명령어는 대문자로 입력 해 주세요.");
        }
    }

    public static void checkUorR(String inputMoveCommande) {
        if (!inputMoveCommande.equals("U") && !inputMoveCommande.equals("D")) {
            throw new IllegalArgumentException("[ERROR]명령어는 U 또는 D로 입력해 주세요");
        }
    }

    public static void checkRorQ(String inputRestartOrEndGame) {
        if (!inputRestartOrEndGame.equals("R") && !inputRestartOrEndGame.equals("Q")) {
            throw new IllegalArgumentException("[ERROR]명령어는 R 또는 Q 로 입력해주세요");
        }
    }

    public static void checkOnlyNumber(String inputsize) {
        if (!inputsize.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력 해 주세요.");
        }
    }

}
