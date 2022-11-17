package bridge.Validator;

public class InputValidator {

    public static void checkBridgeSize(String size) {
        if(!(checkOnlyNumber(size))){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if(!(checkBoundaryNumber(size))){
            throw new IllegalArgumentException("범위가 아닙니다.");
        }
    }

    public static boolean checkBoundaryNumber(String size) {
        Integer bridgeSize = Integer.parseInt(size);
        if(bridgeSize < 3 || bridgeSize > 20){
            return false;
        }
        return true;
    }

    public static boolean checkOnlyNumber(String size) {
        try{
            Integer.parseInt(size);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
