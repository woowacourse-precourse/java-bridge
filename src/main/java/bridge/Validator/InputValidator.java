package bridge.Validator;

import bridge.view.OutputView;

public class InputValidator {

    public static String checkBridgeSize(String size) {
        try{
            checkOnlyNumber(size);
            checkBoundaryNumber(size);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            System.out.println("다시 입력해주세요.");
            return "error";
        }
        return size;
    }

    public static void checkBoundaryNumber(String size) {
        Integer bridgeSize = Integer.parseInt(size);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 범위가 아닙니다.");
        }
    }

    public static void checkOnlyNumber(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static String controlMovingInput(String moving){
        try {
            checkMoving(moving);
        }catch (IllegalArgumentException exception){
            OutputView.printException(exception.getMessage());
            return "error";
        }
        return moving;
    }
    public static void checkMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))){
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
    }

    public static String controlRetryInput(String retryInput){
        try {
            checkRetry(retryInput);
        }catch (IllegalArgumentException exception){
            OutputView.printException(exception.getMessage());
            return "error";
        }
        return retryInput;
    }
    public static void checkRetry(String retryInput) {
        if(!(retryInput.equals("Q") || retryInput.equals("R"))){
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
    }
}
