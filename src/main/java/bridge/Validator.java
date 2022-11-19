package bridge;

import java.util.regex.Pattern;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Validator {
    public void validateNumeric(String input){
        String numericPattern = "^[0-9]*$";
        if(!Pattern.matches(numericPattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자 형태가 아닙니다");
        }
    }
}
