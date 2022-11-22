package bridge.utils;

public class StringToIntegerConverter {
    private Validation validation = new Validation();

    public int toInteger(String stringToInteger){
        validation.validateInteger(stringToInteger);
        return Integer.valueOf(stringToInteger);
    }
}
