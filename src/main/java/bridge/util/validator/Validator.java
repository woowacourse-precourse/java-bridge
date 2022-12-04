package bridge.util.validator;

import java.util.regex.Pattern;

public abstract class Validator {

    abstract void validate(String input) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }





}
