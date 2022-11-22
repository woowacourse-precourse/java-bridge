package bridge.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다");
    }

    public void printBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGameCommand(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q");
    }

    public void printError(String errMsg) {
        System.out.println("[ERROR] " + errMsg);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeResult) {
        String currentBridgeResult = "[ ";
        for (int i = 0; i < bridgeResult.size(); i++) {
            currentBridgeResult += bridgeResult.get(i);
            if (i == bridgeResult.size() - 1) {
                currentBridgeResult += " ]";
            }
            if (i != bridgeResult.size() - 1) {
                currentBridgeResult += " | ";
            }
        }
        System.out.println(currentBridgeResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {}
}
