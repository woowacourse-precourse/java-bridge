package bridge.view;

import bridge.model.ResultManager;

public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    public void printResult(ResultManager result) {
        System.out.println(result);
    }

    public void startGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void askMoveSpace() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
}
