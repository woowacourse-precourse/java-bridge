package bridge.util;

public class Validator {

    public boolean isValidRange(int size) {
        return size >= 3 && size <= 20;
    }

    public boolean isValidMoving(String letter) {
        return letter.equals("U") || letter.equals("D");
    }
}