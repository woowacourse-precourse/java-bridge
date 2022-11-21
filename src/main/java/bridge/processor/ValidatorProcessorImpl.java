package bridge.processor;

public class ValidatorProcessorImpl implements ValidatorProcessor{
    @Override
    public Integer validateBridgeSizeInput(String input) {
        int inputInt = Integer.parseInt(input);
        if (inputInt < 3 || inputInt > 20) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return inputInt;
    }

    @Override
    public String validateRetryInput(String input) {
        return null;
    }

    @Override
    public String validateCommandInput(String input) {
        return null;
    }
}
