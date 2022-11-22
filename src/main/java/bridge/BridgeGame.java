package bridge;

import bridge.InputControl.BridgeInputControl;
import bridge.Vaildator.VaildatorRetryQuit;
import bridge.Vaildator.VaildatorUpDown;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static StringBuilder mapUp = new StringBuilder("[  ]");
    private static StringBuilder mapDown = new StringBuilder("[  ]");
    private static final String CONTOUR = " | ";
    public static String str;
    private static String ox;

    String addOxContour;
    String emptyContour;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public StringBuilder move(String bridgeAnswer, int order) {
        BridgeInputControl.setUpDown();
        String upDownUserInput = VaildatorUpDown.userInputUpDown;
        ox = compare(bridgeAnswer, upDownUserInput);
        makeAddWord(order);
        return makeMap(upDownUserInput);
    }

    private String compare(String bridgeAnswer, String upDownUserInput) {
        if(bridgeAnswer.equals(upDownUserInput)){
            return "O";
        }
        return "X";
    }

    public String getOX(){
        return ox;
    }

    /**
     * 여기부턴 map 만들어지는 메소드
     **/


    private void makeAddWord(int order) {
        this.addOxContour = CONTOUR + ox;
        this.emptyContour = CONTOUR + " ";

        if (order == 0) {
            this.addOxContour = ox;
            this.emptyContour = " ";
        }
    }

    private StringBuilder makeMap(String upDownUserInput) {
        if (upDownUserInput.equals("U")) {
            mapUp.insert(mapUp.length() - 2, addOxContour);
            mapDown.insert(mapDown.length() - 2, emptyContour);
            return new StringBuilder().append(mapUp).append("\n").append(mapDown).append("\n");
        }
        mapUp.insert(mapUp.length() - 2, emptyContour);
        mapDown.insert(mapDown.length() - 2, addOxContour);
        return new StringBuilder().append(mapUp).append("\n").append(mapDown).append("\n");
    }

    public void resetMap() {
        mapUp = new StringBuilder("[  ]");
        mapDown = new StringBuilder("[  ]");
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String successFail) {
        if (successFail.equals("성공")) {
            return false;
        }
        BridgeInputControl.setRetryQuit();
        if (VaildatorRetryQuit.userInputRetryQuit.equals("Q")) {
            return false;
        }
        return true;
    }


}
