package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String PASS = "O";
    private static final String FAIL = "X";
    private static final String NONE = " ";
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_DELIMITER = " | ";


    public void askRetry() {
        System.out.printf("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n", Command.RETRY.getSymbol(), Command.QUIT.getSymbol());
    }

    public void askSize() {
        System.out.println("다리의 길이를 입력해주세요.");
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
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printHistory(bridgeGame.getHistory());

        System.out.print("게임 성공 여부: ");
        if(bridgeGame.isSuccess()){
            System.out.println("성공");
        }
        if(!bridgeGame.isSuccess()){
            System.out.println("실패");
        }

        System.out.printf("총 시도한 횟수: %d%n", bridgeGame.getTrial());
    }

    public void printBegin() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        newLine();
    }

    public void askDirection() {
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n", Direction.UP.getSymbol(), Direction.DOWN.getSymbol());
    }

    public void printHistory(List<Round> history) {
        printHistoryDirection(history, Direction.UP);
        printHistoryDirection(history, Direction.DOWN);
        newLine();
    }

    public void newLine(){
        System.out.println();
    }

    private void printHistoryDirection(List<Round> history, Direction direction) {
        List<String> historyDirection = new ArrayList<>();
        for (Round round : history) {
            if (round.getSelection().equals(direction)) {
                if (round.isPass()) {
                    historyDirection.add(PASS);
                }
                if (!round.isPass()) {
                    historyDirection.add(FAIL);
                }
                continue;
            }
            historyDirection.add(NONE);
        }

        System.out.println(BRIDGE_START + String.join(BRIDGE_DELIMITER, historyDirection) + BRIDGE_END);
    }
}
