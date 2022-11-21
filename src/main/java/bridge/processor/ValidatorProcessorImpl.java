package bridge.processor;

import bridge.enummodel.CommandEnum;

public class ValidatorProcessorImpl implements ValidatorProcessor{
    @Override
    public Integer validateBridgeSizeInput(String input) {
        int inputInt = Integer.parseInt(input);
        if (inputInt < 3 || inputInt > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return inputInt;
    }

    @Override
    public void validateRetryInput(String input) {
        if (!CommandEnum.RESTART.getValue().equals(input) &&
                !CommandEnum.QUIT.getValue().equals(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력값 입니다.");
        }
    }

    @Override
    public void validateCommandInput(String input) {

    }
}
