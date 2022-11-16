package bridge.util;

public class TypeConversion {

    public static int stringToInt(String string) {

        int conversionValue;
        try {
            conversionValue = Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        return conversionValue;
    }
}
