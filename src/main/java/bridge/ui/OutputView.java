package bridge.ui;

import bridge.domain.BridgeGame;
import bridge.ui.resource.Message;
import bridge.ui.resource.UpDownCommand;

import static bridge.ui.PrintBridge.createRow;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void gameStartMessage() {
        System.out.println(Message.Game_Start.getMessage());
    }

    public void bridgeSizeMessage() {
        System.out.println(Message.Bridge_Size_Input.getMessage());
    }

    public void moveMessage() {
        System.out.println(Message.Move_Input.getMessage());
    }

    public void restartMessage() {
        System.out.println(Message.Restart_Input.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeGame bridgeGame) {
        String upperRow =
                createRow(UpDownCommand.UP.command(), bridgeGame.getUser_bridge(), bridgeGame.getAnswer_bridge());
        String bottomRow =
                createRow(UpDownCommand.DOWN.command(), bridgeGame.getUser_bridge(), bridgeGame.getAnswer_bridge());

        System.out.println(upperRow + bottomRow);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(String result, BridgeGame bridgeGame, int trials) {
        System.out.println(Message.ResultMessage.getMessage());
        printMap(bridgeGame);
        System.out.println(Message.GameResult.getMessage() + result);
        System.out.println(Message.Trials.getMessage() + trials);
    }

}
