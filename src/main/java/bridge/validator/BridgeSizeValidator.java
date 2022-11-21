package bridge.validator;

public class BridgeSizeValidator implements SizeValidator {
    static final int minLength = 3;
    static final int maxLength = 20;

    @Override
    public boolean isNumeric(String target) {
        return SizeValidator.super.isNumeric(target);
    }

    @Override
    public boolean isSmallerThanMin(int target) {
        return target < minLength;
    }

    @Override
    public boolean isBiggerThanMax(int target) {
        return target > maxLength;
    }

    public int convertTarget(String target) {
        return Integer.parseInt(target);
    }

    public int getValidBridgeSize(String target) {
        if (!isNumeric(target)) {
            throw new IllegalArgumentException("[ERROR] 다리 사이즈는 숫자만 입력할 수 있습니다.");
        }
        int bridgeSize = convertTarget(target);
        if (isSmallerThanMin(bridgeSize) || isBiggerThanMax(bridgeSize)) {
            throw new IllegalArgumentException(String.format("[ERROR] 다리 사이즈는 %d이상 %d이하의 수여야합니다.", minLength, maxLength));
        }
        return bridgeSize;
    }
}
