package bridge.view;

import bridge.model.Model;
import camp.nextstep.edu.missionutils.*;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize(Model model) {
        System.out.println(MSG.INPUT_BRIDGE_SIZE.message);
        String bridgeSizeCommand = Console.readLine();
        try {
            validateBridgeSize(bridgeSizeCommand);
        }catch (IllegalArgumentException e) {
            //에러메시지 출력부
            readBridgeSize(model);
        }
        model.setBridgeSize(Integer.parseInt(bridgeSizeCommand));
    }
    public void validateBridgeSize(String bridgeSizeCommand) {
        String regex = "^[3-9]$|^[1][0-9]$|^20$";
        if (!bridgeSizeCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void readMoving(Model model) {
        System.out.println(MSG.INPUT_MOVING.message);
        String movingCommand = Console.readLine();
        try {
            validateMoving(movingCommand);
        }catch (IllegalArgumentException e) {
            //에러메시지 출력부
            readMoving(model);
        }
       model.addMovingCommands(movingCommand);
    }
    public void validateMoving(String movingCommand) {
        String regex = "[UD]";
        if (!movingCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(Model model) {
        System.out.println(MSG.INPUT_GAME.message);
        String gameCommand = Console.readLine();
        try {
            validateGame(gameCommand);
        }catch (IllegalArgumentException e) {
            //에러메시지 출력부
            readGameCommand(model);
        }
        model.increaseRunCounts();
        return gameCommand;
    }
    public void validateGame(String gameCommand) {
        String regex = "[RQ]";
        if (!gameCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
