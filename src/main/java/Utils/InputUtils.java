package Utils;

public class InputUtils {

    public boolean isDigit(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }
}
