package bridge.model.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String pattern = "^[1-9]{1}[0-9]{0,3}";

        Pattern compile = Pattern.compile(pattern);
        if(compile.matcher(bridgeSize).find()){
            return;
        }
        throw new IllegalArgumentException("[ERROR]입력 조건에 맞지 않습니다: 1~1000 :" + bridgeSize);
    }

    public static BridgeSize of(String bridgeSize){
        return new BridgeSize(bridgeSize);
    }
}
