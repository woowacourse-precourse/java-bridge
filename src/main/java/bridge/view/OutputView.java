package bridge.view;

public class OutputView {

    public void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    public void printResult(String resultMessage, int tryCount) {
        System.out.println("\n최종 게임 결과");
        printMap();
        System.out.println(String.format("\n게임 성공 여부: %s", resultMessage));
        System.out.println(String.format("총 시도한 횟수: %d", tryCount));
    }
}
