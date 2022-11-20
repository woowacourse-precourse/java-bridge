package bridge.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BridgeLength {

    private final int length;

    public BridgeLength(String length) {
        validateLength(length);
        this.length = Integer.parseInt(length);
    }

    public int getLength(){
        return length;
    }

    public void validateLength(String length){
        validateLengthNumber(length);
        validateLengthRange(length);
    }

    public void validateLengthNumber(String length){
        if(isLengthNumberCorrect(length)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
    }

    private static boolean isLengthNumberCorrect(String length){
        String regex = "^[1-2]?[1-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(length);
        return matcher.matches();
    }

    public void validateLengthRange(String length){
        if(isLengthRangeCorrect(length)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    private static boolean isLengthRangeCorrect(String length){
        int lengthNumber = Integer.parseInt(length);
        return lengthNumber >= 3 && lengthNumber <= 20;
    }
}
