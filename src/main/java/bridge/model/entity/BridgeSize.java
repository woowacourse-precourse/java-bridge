package bridge.model.entity;

import bridge.model.value.BridgeRange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bridge.model.value.BridgeRange.*;
import static bridge.model.value.ErrorMessage.*;

/*
* 숫자여야 함
* 범위는
 */
public class BridgeSize {
    private int bridgeSize;
    private BridgeSize(String bridgeSize){
        validate(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    public int getBridgeSize() {
        return this.bridgeSize;
    }

    private void validate(String bridgeSize) {
        String pattern = "^[\\d]{1,2}";
        Pattern compile = Pattern.compile(pattern);
        isDigit(compile, bridgeSize);
        outRange(bridgeSize);
    }

    private void isDigit(Pattern compile, String bridgeSize) {
        if(!compile.matcher(bridgeSize).find()){
            throw new IllegalArgumentException(getMessage(NOT_INTEGER_ERROR));
        }
    }
    private void outRange(String bridgeSize){
        int size = Integer.parseInt(bridgeSize);
        if(size > MAX || size < MIN){
            throw new IllegalArgumentException(getMessage(OUTRANGE_ERROR));
        }
    }

    public static BridgeSize of(String bridgeSize){
        return new BridgeSize(bridgeSize);
    }
}
