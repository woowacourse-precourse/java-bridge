package bridge.view;

import bridge.domain.Player;
import bridge.domain.enums.BridgePanel;
import bridge.view.enums.GuideMessage;
import bridge.view.enums.MapType;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder up;
    private StringBuilder down;

    public OutputView() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player, boolean moveResult) {
        up = new StringBuilder(MapType.START.getType());
        down = new StringBuilder(MapType.START.getType());
        for (int index = 0; index <= player.informMovingIndex(); index++) {
            makeUpSide(player, moveResult);
            makeDownSide(player, moveResult);
        }
        printWithDivision(up, down);
    }

    public void makeUpSide(Player player, boolean moveResult) {
        List<String> movingChoices = player.getMovingInputs();
        if (movingChoices.get(player.informMovingIndex()).equals(BridgePanel.UP_PANEL.getPosition())) {
            if (moveResult) {
                up.append(MapType.CAN_STEP.getType()).append(MapType.END.getType());
                return;
            }
            up.append(MapType.CAN_NOT_STEP.getType()).append(MapType.END.getType());
            return;
        }
        up.append(MapType.EMPTY.getType()).append(MapType.END.getType());
    }

    public void makeDownSide(Player player, boolean moveResult) {
        List<String> movingChoices = player.getMovingInputs();
        if (movingChoices.get(player.informMovingIndex()).equals(BridgePanel.DOWN_PANEL.getPosition())) {
            if (moveResult) {
                down.append(MapType.CAN_STEP.getType()).append(MapType.END.getType());
                return;
            }
            down.append(MapType.CAN_NOT_STEP.getType()).append(MapType.END.getType());
            return;
        }
        down.append(MapType.EMPTY.getType()).append(MapType.END.getType());
    }

    public void insertDivision(StringBuilder builder) {
        for (int index = 0; index < builder.length() - 1; index++) {
            if (String.valueOf(builder.charAt(index)).equals(MapType.END.getType())) {
                builder.replace(index, index + 1, MapType.DIVISION.getType());
            }
        }
    }

    public void printWithDivision(StringBuilder up, StringBuilder down) {
        insertDivision(up);
        insertDivision(down);
        System.out.println(up);
        System.out.println(down);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String successOrNot, int attempts) {
        System.out.printf(GuideMessage.SUCCESS_OR_NOT_MESSAGE.getMessage(), successOrNot);
        System.out.printf(GuideMessage.ATTEMPTS_MESSAGE.getMessage(), attempts);
    }
}
