package bridge;

import bridge.Application.correctWrong;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    OutputView outputView = new OutputView();
    boolean retryOrNot;
    private String failSuccess;
    private static List<String> mapUp = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    private static List<String> mapDown = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    private static final String CONTOUR = " | ";
    private static String str;
    String addOxContour;
    String emptyContour;

    private static int tryNumber = 0;
    private static String ox;
    private static String successFail;
    private boolean correctNot;

    public enum CorrectWrong {
        CORRECT(true, "O", "성공"),
        WRONG(false, "X", "실패");

        boolean trueFalse;
        String ox;
        String successFailEnum;


        CorrectWrong(boolean trueFalse, String ox, String successFailEnum) {
            this.trueFalse = trueFalse;
            this.ox = ox;
            this.successFailEnum = successFailEnum;
        }

        public boolean getTrueFalse() {
            return trueFalse;
        }

        public String getOx() {
            return ox;
        }

        public String getsuccessFailEnum() {
            return successFailEnum;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String bridgeAnswer, String upDownUserInput, int order) {
        boolean oxResult = compare(bridgeAnswer, upDownUserInput);//get 메소드?

        CorrectWrong origin = selectFromOrigin(oxResult);

        makeAddWord(origin.getOx(), order);

        makeMap(upDownUserInput);

        return new ArrayList<>(List.of(str, origin.getOx(), origin.getsuccessFailEnum()));
    }

    private CorrectWrong selectFromOrigin(boolean oxResult) {
        if (oxResult = true) {
            return CorrectWrong.CORRECT;
        }
        return CorrectWrong.WRONG;
    }

    private boolean compare(String bridgeAnswer, String upDownUserInput ){
        return bridgeAnswer.equals(upDownUserInput);
    }


    private void makeAddWord(String ox, int order) {
        this.addOxContour = CONTOUR + ox;
        this.emptyContour = CONTOUR + " ";

        if (order == 0) {
            this.addOxContour = ox;
            this.emptyContour = " ";
        }
    }

    private void makeMap(String upDownUserInput) {
        if (upDownUserInput.equals("U")) {
            this.mapUp.add(mapUp.size() - 1, addOxContour);
            this.mapDown.add(mapDown.size() - 1, emptyContour);
        } else if (upDownUserInput.equals("D")) {
            this.mapUp.add(mapUp.size() - 1, emptyContour);
            this.mapDown.add(mapDown.size() - 1, addOxContour);
        }
        this.str = String.join("", mapUp) + "\n" + String.join("", mapDown);
    }

    public void resetMap() {
        this.mapUp = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
        this.mapDown = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String retryUserInput = inputView.readGameCommand();
        if (retryUserInput.equals("R")) {
            return true;
        }
        return false;
    }
}
