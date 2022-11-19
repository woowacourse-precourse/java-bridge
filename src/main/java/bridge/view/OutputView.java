package bridge.view;

import bridge.model.Diagram;
import bridge.model.FinalResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    // OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
    // 값 출력을 위해 필요한 메서드를 추가할 수 있다.

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Diagram diagram, FinalResult finalResult) {

        System.out.println("최종 게임 결과");
        diagram.printDiagrams();
        System.out.println("게임 성공 여부: " + finalResult.isFinalSuccess());
        System.out.println("총 시도한 횟수: " + finalResult.getAttempts());
    }

    public void printErrorMessage(IllegalArgumentException error) {
        System.out.println("[ERROR] " + error.getMessage());
    }

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInput() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoveInput() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
}
