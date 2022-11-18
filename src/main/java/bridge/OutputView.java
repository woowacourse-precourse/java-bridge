package bridge;

import static bridge.UserInterface.INSERT_SIZE;
import static bridge.UserInterface.RETRY;
import static bridge.UserInterface.SELECT_ROW;
import static bridge.UserInterface.START;
import static bridge.UserInterface.SUCCESSFUL;
import static bridge.UserInterface.TRY_COUNT;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private String guideLine;
    FrontController frontController;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> printMap() {
        return frontController.bridgeRepository();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printResult(String userInterface) {

        return userInterface;
    }


    public void setPrint() {
        printResult(START.interact());
        printResult(INSERT_SIZE.interact());
        printResult(SELECT_ROW.interact());
        printResult(RETRY.interact());
        printResult(SUCCESSFUL.interact());
        printResult(TRY_COUNT.interact());
    }
}
