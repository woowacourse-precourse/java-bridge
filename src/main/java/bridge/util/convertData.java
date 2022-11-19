package bridge.util;

public class convertData {

    public static String mappingBridgeCellIntToString(int number) {
        String value = new String();

        if (number == 0) {
            value = "D";
        }
        if (number == 1) {
            value = "U";
        }

        return value;
    }
}
