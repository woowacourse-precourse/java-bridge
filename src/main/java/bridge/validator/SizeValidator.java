package bridge.validator;

public interface SizeValidator {
    boolean isSmallerThanMin(int target);

    boolean isBiggerThanMax(int target);
}
