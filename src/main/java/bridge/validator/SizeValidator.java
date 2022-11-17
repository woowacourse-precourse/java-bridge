package bridge.validator;

public interface SizeValidator extends NumberValidator{
    public boolean isBiggerThanMin(int target);

    public boolean isSmallerThanMax(int target);
}
