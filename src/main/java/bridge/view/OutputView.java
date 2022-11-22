package bridge.view;

import bridge.domain.Bridge;
import bridge.utils.Constants;

public class OutputView {
    static StringBuilder upStringBuilder;
    static StringBuilder downStringBuilder;

    public void printMap(Bridge bridge) {
        initStringBuilder();
        int crossBridgeSize = bridge.getUpBridge().size();

        setPrintMap(crossBridgeSize, bridge);
        finishStringBuilder();

        bridge.setLastBridge(upStringBuilder + downStringBuilder.toString());
        System.out.println(bridge.getLastBridge());
    }

    private void setPrintMap(int crossBridgeSize, Bridge bridge) {
        for (int crossPoint = 0; crossPoint < crossBridgeSize; crossPoint++) {
            upStringBuilder.append(bridge.getUpBridge().get(crossPoint));
            downStringBuilder.append(bridge.getDownBridge().get(crossPoint));

            upStringBuilder.append(Constants.MIDDLE_PARTITION_BRIDGE);
            downStringBuilder.append(Constants.MIDDLE_PARTITION_BRIDGE);
        }
    }

    private void initStringBuilder() {
        upStringBuilder = new StringBuilder();
        downStringBuilder = new StringBuilder();

        upStringBuilder.append(Constants.FIRST_PARTITION_BRIDGE);
        downStringBuilder.append(Constants.FIRST_PARTITION_BRIDGE);
    }

    private void finishStringBuilder() {
        upStringBuilder.setLength(upStringBuilder.length() - Constants.LAST_CHARACTER);
        upStringBuilder.append(Constants.LAST_PARTITION_BRIDGE);

        downStringBuilder.setLength(downStringBuilder.length() - Constants.LAST_CHARACTER);
        downStringBuilder.append(Constants.LAST_PARTITION_BRIDGE);
    }

    public void printResult(String gameResult, int gameTryCount, String lastMapResult) {
        printGameFinalBridgeResult();
        System.out.println(lastMapResult);

        printGameSuccessOrFailure(gameResult);
        printGameTotalTryCount(gameTryCount);
    }

    public void printGameFinalBridgeResult() {
        System.out.println("최종 게임 결과");
    }

    public void printGameSuccessOrFailure(String gameResult) {
        System.out.println("게임 성공 여부: " + gameResult);
    }

    public void printGameTotalTryCount(int gameTryCount) {
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }

    public void printStartBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printEnterBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printSelectMoveDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printEnterGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
