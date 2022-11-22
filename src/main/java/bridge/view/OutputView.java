package bridge.view;

import bridge.model.BridgeResult;
import bridge.model.ResultFlag;

public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMessageForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMessageForMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printMessageForGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printMap(BridgeResult bridgeResult) {
        System.out.println(bridgeResult.getUpperLine());
        System.out.println(bridgeResult.getLowerLine());
        System.out.println();
    }
    public void printResult(BridgeResult bridgeResult, ResultFlag resultFlag, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(bridgeResult);
        System.out.printf("게임 성공 여부: %s%n",resultFlag.getMean());
        System.out.printf("총 시도한 횟수: %d", tryCount);
    }
}
