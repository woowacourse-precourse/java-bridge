package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView extends IOPrinter {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param s
     */
    public void printMap(String recordedHistory) {
        this.println(recordedHistory);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param clear
     * @param repeatCount
     */
    public void printResult(String recordedHistory, String status, Integer repeatCount) {
        this.println("최종 게임 결과");
        this.printMap(recordedHistory);
        this.println("게임 성공 여부: " + status);
        this.println("총 시도한 횟수: " + repeatCount);
    }

    public void printGameStartMessage() {
        println("다리 건너기 게임을 시작합니다.");
    }
}
