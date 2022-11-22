package bridge.domain;

import bridge.domain.game.GameMode;
import bridge.message.ErrorMessage;

public class InputValidator {

    public boolean checkUpDown(String upDown){
        if (!upDown.equals(Step.UPPER_STEP.getStepTxt()) && !upDown.equals(Step.LOWER_STEP.getStepTxt())){
            throw new IllegalArgumentException(ErrorMessage.UPDOWN_ERROR.get());
        }
        return true;
    }

    public boolean checkRetry(String input){
        if (!input.equals(GameMode.QUIT.getKey()) && !input.equals(GameMode.RETRY.getKey())){
            throw new IllegalArgumentException(ErrorMessage.RETRY_ERROR.get());
        }
        return true;
    }

    //다리 길이 입력 요청 시 숫자인지 아닌지 확인
    public boolean checkNum(String inputNum){
        for (int i = 0; i < inputNum.length(); i++) {
            if (!Character.isDigit(inputNum.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.get());
            }
        }
        return true;
    }

    //다리 길이 범위 확인
    private boolean validateNumRange(int inputN) {
        if (inputN > 30 || inputN < 3) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERROR.get());
        }
        return true;
    }


    public int returnNum(String inputNum){
        checkNum(inputNum);
        int result = Integer.parseInt(inputNum);
        validateNumRange(result);
        return result;
    }

}
