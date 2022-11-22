package bridge.domain;

import bridge.view.ExceptionMessage;
import bridge.view.InputView;

import java.util.regex.Pattern;

public class BridgeSize {

    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public int checkNumber(String str){
        isNumber(str);
        isRangeNumber(str);
        return Integer.parseInt(str);
    }

    private String isNumber(String str){
        if(!(pattern.matcher(str).matches())) {
            System.out.println(ExceptionMessage.isNumberMsg());
            return InputView.readBridgeSize();
        }
        return str;
    }

    private String isRangeNumber(String str) {
        int size = Integer.parseInt(str);
        if(!(size >=3 && size <=20)) {
            System.out.println(ExceptionMessage.isRangeNumberMsg());
            return InputView.readBridgeSize();
        }
        return str;
    }



}
