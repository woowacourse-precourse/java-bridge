package bridge;

import bridge.Setting.BridgeRetryIndex;
import bridge.Setting.BridgeSideIndex;
import bridge.Setting.BridgeSidePrintIndex;
import bridge.Setting.OutputViewPrintEnum;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<Boolean> bridgeCorrect;
    private int tryTime;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator, int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeCorrect = new ArrayList<>();
        tryTime = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move() {
        while (keepMove()) {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            String readMoving = inputView.readMoving();

            addBridgeCorrect(readMoving);
            outputView.printMap(getMapLines());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        while (!lastBridgeCorrect()) {
            InputView inputView = new InputView();
            String gameCommand = inputView.readGameCommand();

            if (gameCommand.equals(BridgeRetryIndex.QUIT.getLabel())){
                return;
            }
            if (gameCommand.equals(BridgeRetryIndex.RETRY.getLabel())) {
                doRetry();
            }
        }
    }

    public boolean keepMove() {
        return !isEnd() && lastBridgeCorrect();
    }

    public void addBridgeCorrect(String readMoving) {
        bridgeCorrect.add(bridge.get(bridgeCorrect.size()).equals(readMoving));
    }


    public List<String> getMapLines() {
        List<String> lines = new ArrayList<>();
        List<BridgeSideIndex> bridgeSideIndices = List.of(BridgeSideIndex.values());
        for (int index = bridgeSideIndices.size() - 1; index >= 0; index--) {
            List<String> sideIndex = getSideIndex(bridgeSideIndices.get(index));
            String sideString = getSideString(sideIndex);
            lines.add(sideString);
        }
        return lines;
    }

    public void doRetry(){
        if (bridgeCorrect.size() > 0){
            bridgeCorrect.remove(bridgeCorrect.size() - 1);
        }
        tryTime += 1;
    }

    public List<String> getResultLines(){
        List<String> resultLines = new ArrayList<>();
        resultLines.add(OutputViewPrintEnum.FINAL_RESULT.getMessage());
        resultLines.addAll(getMapLines());
        resultLines.add(System.lineSeparator());
        resultLines.add(printSuccess());
        resultLines.add(printTryTime());
        return resultLines;
    }
    private String getSideString(List<String> sideIndex) {
        String sideString = String.join(OutputViewPrintEnum.OUTPUT_BRIDGE_SIDE_SEPARATOR.getMessage(), sideIndex);
        return OutputViewPrintEnum.OUTPUT_BRIDGE_SIDE.getMessage()
                .replace(OutputViewPrintEnum.CHANGE_STRING.getMessage(), sideString);
    }

    private List<String> getSideIndex(BridgeSideIndex bridgeSideIndex) {
        List<String> sideIndex = new ArrayList<>();
        for (int index = 0; index < bridgeCorrect.size(); index++) {
            String printEach = getPrintEach(bridgeSideIndex, bridge.get(index), bridgeCorrect.get(index));
            sideIndex.add(printEach);
        }
        return sideIndex;
    }

    private String getPrintEach(BridgeSideIndex bridgeSideIndex, String bridgeEach, boolean bridgeCorrectEach) {
        if (bridgeSideIndex.getLabel().equals(bridgeEach)) {
            if (bridgeCorrectEach) {
                return BridgeSidePrintIndex.CORRECT.getLabel();
            }
            return BridgeSidePrintIndex.WRONG.getLabel();
        }
        return BridgeSidePrintIndex.BLANK.getLabel();
    }


    private String printSuccess() {
        String line = OutputViewPrintEnum.OUTPUT_CHECK_SUCCESS.getMessage();
        if (isEnd()) {
            return line.replace(OutputViewPrintEnum.CHANGE_STRING.getMessage()
                    , OutputViewPrintEnum.OUTPUT_RESULT_SUCCESS.getMessage());
        }
        return line.replace(OutputViewPrintEnum.CHANGE_STRING.getMessage()
                , OutputViewPrintEnum.OUTPUT_RESULT_FAIL.getMessage());
    }

    private String printTryTime() {
        return OutputViewPrintEnum.OUTPUT_TRY_TIME.getMessage()
                .replace(OutputViewPrintEnum.CHANGE_INT.getMessage(), String.valueOf(tryTime));
    }

    private boolean isEnd() {
        return bridge.size() <= bridgeCorrect.size();
    }

    private boolean lastBridgeCorrect() {
        if (bridgeCorrect.size() == 0){
            return true;
        }
        return bridgeCorrect.get(bridgeCorrect.size() - 1);
    }
}
