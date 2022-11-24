package bridge.validator;

public class PositionValidator implements SizeValidator {
    static final int minLength = 0;
    final int maxLength;

    public PositionValidator(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean isSmallerThanMin(int target) {
        return target < minLength;
    }

    @Override
    public boolean isBiggerThanMax(int target) {
        return target > maxLength;
    }

    public void validatePosition(int position) {
        if (isSmallerThanMin(position) || isBiggerThanMax(position)) {
            throw new IllegalArgumentException(String.format("[ERROR] 포지션은 %d이상 %d이하의 수여야합니다.", minLength, maxLength));
        }
    }
}
