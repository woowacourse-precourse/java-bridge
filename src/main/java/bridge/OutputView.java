package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    BridgeGame bridgeGame = BridgeGame.getInstance();
    private static final Controller controller = Controller.getInstance();
    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    @Override
    public String toString() {
        String result = bridgeGame.getTopMap().toString() + "\n";
        result += bridgeGame.getDownMap().toString();

        result = result.replace("[","[ ");
        result = result.replace("]"," ]");
        result = result.replace(", "," | ");

        return result;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printMap() {
        System.out.println(this);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count) {
        System.out.println("최종 게임 결과");
        printMap();
        printClearOrFail();
        System.out.println("총 시도한 횟수: "+count);
    }

    private void printClearOrFail() {
        printSucces();
        printFail();
    }

    private void printSucces() {
        if(bridgeGame.isClear(controller.getBridgeSize())) {
            System.out.println("게임 성공 여부: 성공");
        }
    }

    private void printFail() {
        if(bridgeGame.isPlayerDead()) {
            System.out.println("게임 성공 여부: 실패");
        }
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작 합니다.\n");
    }

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputUpOrDown() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInputRestartOrQuit() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
