package bridge.view;

import bridge.vo.Commend;

public class Validator {

    public void inputSizeValidator(String size) {
        if(!size.matches("[0-9]+")){
            throw new IllegalArgumentException("Error");
        }
    }

    public void validatorBridgeSizeRange(String size) {
        int len = Integer.parseInt(size);
        if(len < 1 || len > 20){
            throw new IllegalArgumentException("Error range");
        }
    }

    public void validateMoving(String moving) {
        if(!(moving.equals(Commend.UP) || moving.equals(Commend.DOWN))){
            throw new IllegalArgumentException("위 아래 다시 입력");
        }
    }

    public void validateRetryCommand(String command) {
        if(!(command.equals(Commend.RETRY) || command.equals(Commend.QUIT))){
            throw new IllegalArgumentException("종료 다시 입력");
        }
    }
}
