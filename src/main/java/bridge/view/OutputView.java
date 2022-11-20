package bridge.view;

import static bridge.KeyBoardEvent.UP;
import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_BLANK;
import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_FAIL;
import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_SUCCESS;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_BLANK;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_FAIL;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_SUCCESS;
import static bridge.constant.NumberConstant.FIRST_ROW;
import static bridge.constant.NumberConstant.SECOND_ROW;

import bridge.CompareResult;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. 제공된 OutputView 클래스를 활용해 구현해야 한다. OutputView의 패키지는 변경할 수 있다. OutputView의 메서드의 이름은 변경할
 * 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다. 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {

    List<String> storedMap;

    public OutputView() {
        this.storedMap = new ArrayList<>();

        for (int i = FIRST_ROW.getCode(); i <= SECOND_ROW.getCode(); ++i) {
            storedMap.add("");
        }
    }

    public void printMap(CompareResult compareResult) {
        analyzePrintType(compareResult);

        System.out.println("[" + storedMap.get(FIRST_ROW.getCode()) + "]");
        System.out.println("[" + storedMap.get(SECOND_ROW.getCode()) + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void analyzePrintType(CompareResult compareResult) {
        if (storedMap.get(FIRST_ROW.getCode()).isEmpty()) {
            oneDepthToAnalyze(compareResult.getReadDirection(), compareResult.isAppropriate());
            return;
        }

        reverseOneDepthToAnalyze(compareResult.getReadDirection(), compareResult.isAppropriate());
    }

    private void oneDepthToAnalyze(String readDirection, boolean appropriate) {
        if (appropriate) {
            twoDepthToAnalyzeFirstType(readDirection);
            return;
        }
        reverseTwoDepthToAnalyzeFirstType(readDirection);
    }

    private void twoDepthToAnalyzeFirstType(String readDirection) {
        upTypeFirst(readDirection, FIRST_TYPE_SUCCESS.getBridgeMaterial());
    }

    private void reverseTwoDepthToAnalyzeFirstType(String readDirection) {
        upTypeFirst(readDirection, FIRST_TYPE_FAIL.getBridgeMaterial());
    }

    private void upTypeFirst(String readDirection, String firstType) {
        if (readDirection.equals(UP.getFirstLetter())) {
            this.storedMap.set(FIRST_ROW.getCode(), storedMap.get(FIRST_ROW.getCode()) + firstType);
            this.storedMap.set(SECOND_ROW.getCode(),
                    storedMap.get(SECOND_ROW.getCode()) + FIRST_TYPE_BLANK.getBridgeMaterial());
            return;
        }

        this.storedMap.set(FIRST_ROW.getCode(),
                storedMap.get(FIRST_ROW.getCode()) + FIRST_TYPE_BLANK.getBridgeMaterial());
        this.storedMap.set(SECOND_ROW.getCode(), storedMap.get(SECOND_ROW.getCode()) + firstType);
    }

    private void reverseOneDepthToAnalyze(String readDirection, boolean appropriate) {
        if (appropriate) {
            twoDepthToAnalyzeSecondType(readDirection);
            return;
        }

        reverseTwoDepthToAnalyzeSecondType(readDirection);
    }

    private void twoDepthToAnalyzeSecondType(String readDirection) {
        upTypeSecond(readDirection, SECOND_TYPE_SUCCESS.getBridgeMaterial());
    }

    private void reverseTwoDepthToAnalyzeSecondType(String readDirection) {
        upTypeSecond(readDirection, SECOND_TYPE_FAIL.getBridgeMaterial());
    }

    private void upTypeSecond(String readDirection, String secondTypeFail) {
        if (readDirection.equals(UP.getFirstLetter())) {
            this.storedMap.set(FIRST_ROW.getCode(), storedMap.get(FIRST_ROW.getCode()) + secondTypeFail);
            this.storedMap.set(SECOND_ROW.getCode(),
                    storedMap.get(SECOND_ROW.getCode()) + SECOND_TYPE_BLANK.getBridgeMaterial());
            return;
        }

        this.storedMap.set(FIRST_ROW.getCode(),
                storedMap.get(FIRST_ROW.getCode()) + SECOND_TYPE_BLANK.getBridgeMaterial());
        this.storedMap.set(SECOND_ROW.getCode(), storedMap.get(SECOND_ROW.getCode()) + secondTypeFail);
    }

}
