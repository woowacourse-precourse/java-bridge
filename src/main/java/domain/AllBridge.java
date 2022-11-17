package domain;


public class AllBridge {
    public void checkBridgeLength(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if(size > 20 || size < 3) {
                throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
        }
    }

}
