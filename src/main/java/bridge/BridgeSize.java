package bridge;

public class BridgeSize {

    private final int size;

    public BridgeSize(String size) {
        ValidBridgeSize(size);
        this.size = Integer.parseInt(size);
    }

    private void ValidBridgeSize(String size){
        if(!isBridgeInteger(size)){
            throw new IllegalArgumentException("입력한 값이 숫자가 아닙니다.");
        }
        if(!isBridgeSize(Integer.parseInt(size))){
            throw new IllegalArgumentException("다리의 길이는 3이상 20이하여야 합니다.");
        }
    }

    private boolean isBridgeInteger(String size){
        return size.chars().allMatch(Character::isDigit);
    }

    private boolean isBridgeSize(int size) {
        return size < 3 || size > 20;
    }

    public int getBridgeSize(){
        return size;
    }

}
