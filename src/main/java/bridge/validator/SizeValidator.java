package bridge.validator;

public interface SizeValidator extends NumberValidator {
    boolean isSmallerThanMin(int target);

    boolean isBiggerThanMax(int target);
}
