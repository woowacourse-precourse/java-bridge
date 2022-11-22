package bridge.view;

import bridge.domain.BridgeResult;
import bridge.domain.ResultSymbol;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printNewLine() {
        System.out.println();
    }

    public void gameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        printNewLine();
    }

    public void inputBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void inputMoveCommandMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void inputRetryCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeResult bridgeResult) {
        System.out.println(bridgeResult.getUpLine());
        System.out.println(bridgeResult.getDownLine());
        printNewLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeResult bridgeResult, ResultSymbol resultSymbol, int gameTryCount) {
        System.out.println("최종 게임 결과");
        printMap(bridgeResult);
        System.out.printf("게임 성공 여부: %s\n", resultSymbol.getStatus());
        System.out.printf("총 시도한 횟수: %d", gameTryCount);
    }
}
