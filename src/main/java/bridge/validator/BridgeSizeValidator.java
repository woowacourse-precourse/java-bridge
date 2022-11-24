package bridge.validator;

public class BridgeSizeValidator implements SizeValidator, NumberValidator {
    static final int MIN_LENGTH = 3;
    static final int MAX_LENGTH = 20;


    @Override
    public boolean isSmallerThanMin(int target) {
        return target < MIN_LENGTH;
    }

    @Override
    public boolean isBiggerThanMax(int target) {
        return target > MAX_LENGTH;
    }

    private boolean isConvertible(String target){
        int bridgeSize;
        try{
            bridgeSize = convertTarget(target);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private int convertTarget(String target) throws NumberFormatException{
        return Integer.parseInt(target);
    }

    private void checkNumeric(String target){
        if (!isNumeric(target)) {
            throw new IllegalArgumentException("[ERROR] 다리 사이즈는 숫자만 입력할 수 있습니다.");
        }
    }

    private boolean isValidRange(int bridgeSize){
        if(isSmallerThanMin(bridgeSize) || isBiggerThanMax(bridgeSize)){
            return false;
        }
        return true;
    }

    public int getValidBridgeSize(String target) {
        checkNumeric(target);
        if (!isConvertible(target) || !isValidRange(convertTarget(target))) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 다리 사이즈는 %d이상 %d이하의 수여야합니다.", MIN_LENGTH, MAX_LENGTH));
        }
        return convertTarget(target);
    }
}
