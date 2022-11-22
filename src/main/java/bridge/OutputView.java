package bridge.ui;

import static bridge.ui.UserInterface.INSERT_SIZE;
import static bridge.ui.UserInterface.RESULT;
import static bridge.ui.UserInterface.RE_TRY;
import static bridge.ui.UserInterface.SELECT_ROW;
import static bridge.ui.UserInterface.START;
import static bridge.ui.UserInterface.SUCCESSFUL;
import static bridge.ui.UserInterface.TRY_COUNT;

import bridge.FrontController;
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

        System.out.println(RESULT.interact());

        System.out.println(SUCCESSFUL.interact());

        System.out.println(TRY_COUNT.interact());

        return userInterface;
    }

    public void start() {
        System.out.println(START.interact());
    }

    public void insertBridgeSize() {
        System.out.println(INSERT_SIZE.interact());
    }

    public void selectRow() {
        System.out.println(SELECT_ROW.interact());
    }

    public void chooseRetry(){
        System.out.println(RE_TRY.interact());
    }

}
