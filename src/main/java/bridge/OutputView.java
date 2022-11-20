package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 게임 시작을 위한 문구를 출력한다.
     */
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 다리 길이 입력을 위한 문구를 출력한다.
     */
    public void printBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸을 선택하라는 문구를 출력한다.
     */
    public void printChoiceMove() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

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
    public void printResult() {
    }
}
