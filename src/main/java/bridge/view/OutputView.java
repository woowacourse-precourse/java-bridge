package bridge.view;

import bridge.constant.ShowPrint;
import bridge.domain.BridgePrinting;
import bridge.util.Validate;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String Result) {
        System.out.println(Result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, BridgePrinting bridgePrinting, boolean isSuccess) {
        Validate validate = new Validate();
        System.out.println(ShowPrint.RESULT.getPrint());
        bridgePrinting.makeBridge();
        System.out.println(ShowPrint.RESULT_IS_SUCCESS.getPrint() + validate.validateFinalSuccess(isSuccess));
        System.out.println(ShowPrint.RESULT_GAME_COUNT.getPrint() + count);
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printSetSize() {
        System.out.println(ShowPrint.SET_SIZE.getPrint());
    }

    public void printStart() {
        System.out.println(ShowPrint.INIT_START.getPrint());
    }

    public void printMove() {
        System.out.println(ShowPrint.MOVE.getPrint());
    }


    public void printRestart() {
        System.out.println(ShowPrint.RESTART.getPrint());
    }


}
