package bridge.view;

import bridge.domain.Bridge;

public class OutputView {
    static StringBuilder upStringBuilder;
    static StringBuilder downStringBuilder;

    public void printMap(Bridge bridge) {
        initStringBuilder();
        int crossBridgeSize = bridge.getUpBridge().size();

        upStringBuilder.append("[");
        downStringBuilder.append("[");

        for (int i = 0; i < crossBridgeSize; i++) {
            upStringBuilder.append(bridge.getUpBridge().get(i));
            downStringBuilder.append(bridge.getDownBridge().get(i));
            if (i != crossBridgeSize - 1) {
                upStringBuilder.append('|');
                downStringBuilder.append('|');
            }
        }
        upStringBuilder.append("]");
        upStringBuilder.append('\n');

        downStringBuilder.append("]");
        downStringBuilder.append('\n');

        bridge.setLastBridge(upStringBuilder + downStringBuilder.toString());
        System.out.println(upStringBuilder + downStringBuilder.toString());
    }

    private void initStringBuilder() {
        upStringBuilder = new StringBuilder();
        downStringBuilder = new StringBuilder();

        upStringBuilder.append("[");
        downStringBuilder.append("[");
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

    public void printEnterBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printSelectMoveDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printEnterGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
