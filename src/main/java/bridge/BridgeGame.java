package bridge;

import bridge.InputControl.BridgeInputControl;
import bridge.Vaildator.VaildatorRetryQuit;
import bridge.Vaildator.VaildatorUpDown;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static StringBuilder mapUp = new StringBuilder(Constant.EMPTY_BLOCK);
    private static StringBuilder mapDown = new StringBuilder(Constant.EMPTY_BLOCK);
    private static String ox;
    String addOxContour;
    String emptyContour;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String bridgeAnswer, int order) {
        BridgeInputControl.setUpDown();
        String upDownUserInput = VaildatorUpDown.userInputUpDown;
        ox = compare(bridgeAnswer, upDownUserInput);
        makeAddWord(order);
        makeMap(upDownUserInput);
    }

    private String compare(String bridgeAnswer, String upDownUserInput) {
        if (bridgeAnswer.equals(upDownUserInput)) {
            return Constant.RIGHT;
        }
        return Constant.WRONG;
    }

    public String getOX() {
        return ox;
    }

    /**
     * 여기부턴 map 만들어지는 메소드
     **/


    private void makeAddWord(int order) {
        this.addOxContour = Constant.CONTOUR + ox;
        this.emptyContour = Constant.CONTOUR + Constant.EMPTY;

        if (order == Constant.ZERO) {
            this.addOxContour = ox;
            this.emptyContour = Constant.EMPTY;
        }
    }

    private StringBuilder makeMap(String upDownUserInput) {
        if (upDownUserInput.equals(Constant.UP)) {
            mapUp.insert(mapUp.length() - Constant.TWO, addOxContour);
            mapDown.insert(mapDown.length() - Constant.TWO, emptyContour);
            return new StringBuilder().append(mapUp).append(Constant.NEXT).append(mapDown).append(Constant.NEXT);
        }
        mapUp.insert(mapUp.length() - Constant.TWO, emptyContour);
        mapDown.insert(mapDown.length() - Constant.TWO, addOxContour);
        return new StringBuilder().append(mapUp).append(Constant.NEXT).append(mapDown).append(Constant.NEXT);
    }

    public StringBuilder getMap() {

        return new StringBuilder().append(mapUp).append(Constant.NEXT).append(mapDown).append(Constant.NEXT);
    }

    public void resetMap() {
        mapUp = new StringBuilder(Constant.EMPTY_BLOCK);
        mapDown = new StringBuilder(Constant.EMPTY_BLOCK);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String successFail) {
        if (successFail.equals(Constant.SUCCESS)) {
            return false;
        }
        BridgeInputControl.setRetryQuit();
        if (VaildatorRetryQuit.userInputRetryQuit.equals(Constant.QUIT)) {
            return false;
        }
        return true;
    }


}
