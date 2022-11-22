package bridge.UI;

import bridge.Domain.BridgeGame;
import bridge.UI.Resource.GameResource;
import bridge.UI.Resource.Message;
import bridge.UI.Resource.UpDownCommand;

import java.util.List;

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
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        String upperRow = createRow(UpDownCommand.UP.command(), bridgeGame.getUser_bridge(), bridgeGame.getAnswer_bridge());
        String bottomRow = createRow(UpDownCommand.DOWN.command(), bridgeGame.getUser_bridge(), bridgeGame.getAnswer_bridge());

        System.out.println(upperRow + bottomRow);
    }

    private String createRow(String UorD, List<String> user, List<String> ans) {
        String row = GameResource.ROW_OPEN.content();

        for (int index = 0; index < user.size(); index++) {
            row += getSign(UorD, user.get(index), ans.get(index));
            row += GameResource.ROW_MID.content();
        }

        row = row.substring(0, row.length() - 1);
        row += GameResource.ROW_CLOSE.content();
        return row;
    }

    private String getSign(String UorD, String user, String ans) {
        if (user.equals(UorD)) {
            if (user.equals(ans))
                return GameResource.GUESS_RIGHT.content();
            return GameResource.GUESS_WRONG.content();
        }
        return GameResource.GUESS_NOTHING.content();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, BridgeGame bridgeGame, int trials) {
        System.out.println(Message.ResultMessage.getMessage());
        printMap(bridgeGame);
        System.out.println(Message.GameResult.getMessage() + result);
        System.out.println(Message.Trials.getMessage() + trials);
    }

}
