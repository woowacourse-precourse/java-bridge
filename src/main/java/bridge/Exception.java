package bridge;


public class Exception {

    public static int validateBridgeSize(String input) {
        if (validateInputEmpty(input)) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다. 메시지에 맞도록 입력해주세요.");
        }
        if (validateInputtype(input) || validateInputrange(input)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return Integer.parseInt(input);
    }

    private static boolean validateInputtype(String input) {
        if (input.matches("^[a-zA-Z]*$")) {
            return true;
        }
        return false;
    }

    private static boolean validateInputrange(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20) {
            return true;
        }
        return false;
    }


    public static String validateMoving(String input) {
        if (validateInputEmpty(input)) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다. 메시지 조건에 맞게 입력해주세요.");
        }
        if (validateMovinginput(input))
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. U와 D중 하나를 입력해주세요.");
        return input;
    }

    private static boolean validateMovinginput(String input) {
        if (input.matches("[^UD]")) {
            return true;
        }
        return false;
    }

    public static String validateGameCommand(String restartInput) {
        if (validateInputEmpty(restartInput)) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다. 메시지 조건에 맞게 입력해주세요.");
        }
        if ( validateGameCommandinput(restartInput)){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. R과 Q중 하나를 입력해주세요.");
        }
        return restartInput;
    }

    private static boolean validateGameCommandinput(String restartInput) {
        if (restartInput.matches("[^RQ]")) {
            return true;
        }
        return false;
    }

    private static boolean validateInputEmpty(String input) {
        if (input.equals("")) {
            return true;
        }
        return false;
    }
}
