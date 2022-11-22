package bridge.view;

import bridge.domain.enums.BridgePanel;
import bridge.view.enums.GuideMessage;
import bridge.view.enums.MapType;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder upSide;
    private StringBuilder downSide;

    public OutputView() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> movingChoices, List<Boolean> moveResults) {
        upSide = new StringBuilder(MapType.START.getType());
        downSide = new StringBuilder(MapType.START.getType());
        for (int index = 0; index < movingChoices.size(); index++) {
            makeUpSide(movingChoices.get(index), moveResults.get(index));
            makeDownSide(movingChoices.get(index), moveResults.get(index));
        }
        printWithDivision(upSide, downSide);
    }

    public void makeUpSide(String moving, boolean moveResult) {
        if (moving.equals(BridgePanel.UP_PANEL.getPosition())) {
            insertResult(upSide, moveResult);
        }
        if (!moving.equals(BridgePanel.UP_PANEL.getPosition())) {
            upSide.append(MapType.EMPTY.getType()).append(MapType.END.getType());
        }
    }

    public void makeDownSide(String moving, boolean moveResult) {
        if (moving.equals(BridgePanel.DOWN_PANEL.getPosition())) {
            insertResult(downSide, moveResult);
        }
        if (!moving.equals(BridgePanel.DOWN_PANEL.getPosition())) {
            downSide.append(MapType.EMPTY.getType()).append(MapType.END.getType());
        }
    }

    public void insertResult(StringBuilder builder, boolean moveResult) {
        if (moveResult) {
            builder.append(MapType.CAN_STEP.getType()).append(MapType.END.getType());
            return;
        }
        builder.append(MapType.CAN_NOT_STEP.getType()).append(MapType.END.getType());
    }

    public void insertDivision(StringBuilder builder) {
        for (int index = 0; index < builder.length() - 1; index++) {
            if (String.valueOf(builder.charAt(index)).equals(MapType.END.getType())) {
                builder.replace(index, index + 1, MapType.DIVISION.getType());
            }
        }
    }

    public void printWithDivision(StringBuilder upSide, StringBuilder downSide) {
        insertDivision(upSide);
        insertDivision(downSide);
        System.out.println(upSide);
        System.out.println(downSide);
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