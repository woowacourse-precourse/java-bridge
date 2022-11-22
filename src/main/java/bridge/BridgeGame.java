package bridge;

import bridge.InputControl.BridgeInputControl;
import bridge.Vaildator.VaildatorRetryQuit;
import bridge.Vaildator.VaildatorUpDown;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    OutputView outputView = new OutputView();

    private static StringBuilder mapUp = new StringBuilder("[  ]");
    private static StringBuilder mapDown = new StringBuilder("[  ]");
    private static final String CONTOUR = " | ";
    private static String str;
    private static String ox;

    String addOxContour;
    String emptyContour;

    private static CorrectWrong origin;

    public enum CorrectWrong {
        CORRECT("O", "성공"),
        WRONG("X", "실패");

        String ox;
        String successFail;

        CorrectWrong( String ox, String successFail) {
            this.ox = ox;
            this.successFail = successFail;
        }

        public String getOx() {
            return ox;
        }
        public String getSuccessFail() {
            return successFail;
        }
    }


    public String mainGame(List<String> bridgeList){
        for (int order = 0; order < bridgeList.size(); order++){
            move(bridgeList.get(order), order);
            outputView.printMap(str);
            if (judgementFail()){
                return origin.getSuccessFail();
            }
        }
        return origin.getSuccessFail();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String bridgeAnswer, int order) {
        BridgeInputControl.setUpDown();
        String upDownUserInput = VaildatorUpDown.userInputUpDown;
        boolean oxResult = compare(bridgeAnswer, upDownUserInput);//get 메소드?

        origin = selectFromOrigin(oxResult);
        this.ox = origin.getOx();
        makeAddWord(order);
        makeMap(upDownUserInput);
    }

    private boolean compare(String bridgeAnswer, String upDownUserInput ){
        return bridgeAnswer.equals(upDownUserInput);
    }

    private CorrectWrong selectFromOrigin(boolean oxResult) {
        if (oxResult = true) {
            return CorrectWrong.CORRECT;
        }
        return CorrectWrong.WRONG;
    }


    private boolean judgementFail(){
        if (this.ox == "X"){
            return true;
        }
        return false;
    }


    /** 여기부턴 map 만들어지는 메소드 **/


    private void makeAddWord(int order) {

        this.addOxContour = CONTOUR + this.ox;
        this.emptyContour = CONTOUR + " ";

        if (order == 0) {
            this.addOxContour = this.ox;
            this.emptyContour = " ";
        }
    }

    private void makeMap(String upDownUserInput) {
        if (upDownUserInput.equals("U")) {
            mapUp.insert(mapUp.length()-2, addOxContour);
            mapDown.insert(mapDown.length()-2, emptyContour);
        } else if (upDownUserInput.equals("D")) {
            mapUp.insert(mapUp.length()-2, emptyContour);
            mapDown.insert(mapDown.length()-2, addOxContour);
        } // else if 수정
        str = mapUp.toString() + "\n" + mapDown.toString() +"\n";
    }

    public void resetMap() {
        this.mapUp = new StringBuilder("[  ]");
        this.mapDown = new StringBuilder("[  ]");
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String successFail) {
        if (successFail.equals("성공")){
            return false;
        }
        BridgeInputControl.setRetryQuit();
        if (VaildatorRetryQuit.userInputRetryQuit.equals("Q")) {
            return false;
        }
        return true;
    }


}
