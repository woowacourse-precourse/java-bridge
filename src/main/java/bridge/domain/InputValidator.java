package bridge.domain;

import bridge.domain.game.GameMode;
import bridge.domain.generator.Step;
import bridge.message.ErrorMessage;

public class InputValidator {
    private static final int NUMBER_MIN_RANGE = 3;
    private static final int NUMBER_MAX_RANGE = 20;

    public void checkUpDown(String upDown){
        if (!upDown.equals(Step.UPPER_STEP.getStepTxt()) && !upDown.equals(Step.LOWER_STEP.getStepTxt())){
            throw new IllegalArgumentException(ErrorMessage.UPDOWN_ERROR.get());
        }
    }

    public void checkRetry(String input){
        if (!input.equals(GameMode.QUIT.getKey()) && !input.equals(GameMode.RETRY.getKey())){
            throw new IllegalArgumentException(ErrorMessage.RETRY_ERROR.get());
        }
    }

    //다리 길이 입력 요청 시 숫자인지 아닌지 확인
    private void checkNum(String inputNum){
        for (int i = 0; i < inputNum.length(); i++) {
            if (!Character.isDigit(inputNum.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.get());
            }
        }
    }

    //다리 길이 범위 확인
    private void validateNumRange(int inputN) {
        if (inputN > NUMBER_MAX_RANGE || inputN < NUMBER_MIN_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERROR.get());
        }
    }


    public int returnNum(String inputNum){
        checkNum(inputNum);
        int result = Integer.parseInt(inputNum);
        validateNumRange(result);
        return result;
    }

}
