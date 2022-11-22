package bridge.util;

public class DataTypeChanger {
    public String convertToUpOrDown(int number) {
        if (number == 1) {
            return "U";
        }
        return "D";
    }

    public int StringToInteger(String str) {
        return Integer.parseInt(str);
    }
}
