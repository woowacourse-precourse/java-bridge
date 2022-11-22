package bridge;

public class LocationConverter {

    public static String getLocation(int number) {
        if (number == 0) {
            return "D";
        }
        if (number == 1) {
            return "U";
        }
        return null;
    }
}
