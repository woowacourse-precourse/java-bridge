package bridge.validator;

public interface SizeValidator extends NumberValidator {
    boolean isBiggerThanMin(int target);

    boolean isSmallerThanMax(int target);
}
