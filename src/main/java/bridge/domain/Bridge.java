package bridge.domain;

import bridge.view.ExceptionMessage;
import bridge.view.InputView;

import java.util.regex.Pattern;

public class Bridge {

    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public boolean isNumber(String str){
        if(!(pattern.matcher(str).matches())) {
            throw new IllegalArgumentException(ExceptionMessage.isNumberMsg());
        }
        return true;
    }

    public boolean isRangeNumber(String str) {
        int size = Integer.parseInt(str);
        if(!(size >=3 && size <=20)) {
            throw new IllegalArgumentException(ExceptionMessage.isRangeNumberMsg());
        }
        return true;
    }


}
