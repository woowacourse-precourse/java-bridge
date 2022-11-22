package bridge.model.entity;

import bridge.model.value.BridgeRange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bridge.model.value.BridgeRange.*;

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
            throw new IllegalArgumentException("[ERROR] 입력값이 정수가 아닙니다. 다시 입력해주세요 :" + bridgeSize);
        }
    }
    private void outRange(String bridgeSize){
        int size = Integer.parseInt(bridgeSize);
        if(size > MAX || size < MIN){ // TODO: 사이즈 MagicNum
            throw new IllegalArgumentException("[ERROR] 입력값이 범위에서 벗어났습니다 3 ~ 20 다시 입력해주세요 :" + bridgeSize);
        }
    }

    public static BridgeSize of(String bridgeSize){
        return new BridgeSize(bridgeSize);
    }
}
