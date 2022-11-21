package model;

public class BridgeSizeValidator {
    public final int bridgeSize;

    public BridgeSizeValidator(String bridgeSize) {
        allCheck(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    public void allCheck(String bridgeSize) {
        nullCheck(bridgeSize);
        bridgeSizeIsDigit(bridgeSize);
        bridgeSizeOver(bridgeSize);
    }
    public void nullCheck(String bridgeSize) {
        if(bridgeSize.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 널값이야 이놈ㅇ나");
        }
    }
    public void bridgeSizeIsDigit(String bridgeSize) {
        for(int i=0; i<bridgeSize.length(); i++) {
            if(!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 정수만 입력해주세요.");
            }
        }
    }

    public void bridgeSizeOver(String bridgeSize) {
        if(Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3~20 사이입니다.");
        }
    }
}
