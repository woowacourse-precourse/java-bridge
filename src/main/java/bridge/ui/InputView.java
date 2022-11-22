package bridge.ui;

import bridge.constant.ErrorCode;
import bridge.constant.MatchConst.Button;
import bridge.constant.MatchConst.InputMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class InputView {

    public int readBridgeSize() {
        System.out.print("다리 건너기 게임을 시작합니다.\n\n");
        System.out.println("다리 길이를 입력해주세요.");
        String input = Console.readLine();
        validationBridgeSize(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println(InputMessage.CHOOSE_UPDOWN);
        String result = Console.readLine();
        validationMoving(result);
        return result;
    }

    public String readGameCommand() {
        System.out.println(InputMessage.CHOOSE_RETRY);
        String result = Console.readLine();
        validationGamieCommand(result);
        return result;
    }

    private void validationBridgeSize(String size){
        if(!size.matches("\\d+")){
            throw new IllegalArgumentException(ErrorCode.WRONG_INPUT.getMessage());
        }
    }

    private void validationMoving(String moving){
        if(!Objects.equals(moving, Button.UP_BUTTON) && !Objects.equals(moving, Button.DOWN_BUTTON)){
            throw new IllegalArgumentException(ErrorCode.WRONG_INPUT.getMessage());
        }
    }

    private void validationGamieCommand(String gameCommand){
        if(!Objects.equals(gameCommand, Button.RETRY_BUTTON) && !Objects.equals(gameCommand, Button.END_BUTTON)){
            throw new IllegalArgumentException(ErrorCode.WRONG_INPUT.getMessage());
        }
    }
}
