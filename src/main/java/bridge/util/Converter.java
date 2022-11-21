package bridge.util;

public class Converter {

    public static String convertNumberToMoving(int number) {
        if (number == Constant.UPPER_MOVING_NUMBER) {
            return Constant.UPPER_MOVING;
        }
        return Constant.LOWER_MOVING;
    }
}
