package bridge;

import bridge.Setting.BridgeSideIndex;
import bridge.Setting.BridgeSidePrintIndex;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final List<List<String>> sideIndies;
    private int tryTime;

    static final String OUTPUT_BRIDGE_SIDE = "[ %s ]" + System.lineSeparator();
    static final String FINAL_RESULT = "최종 게임 결과" + System.lineSeparator();
    static final String OUTPUT_TRY_TIME = "총 시도한 횟수: %d" + System.lineSeparator();
    static final String OUTPUT_CHECK_SUCCESS = "게임 성공 여부: %s" + System.lineSeparator();
    static final String OUTPUT_BRIDGE_SIDE_SEPARATOR = " | ";
    static final String CHANGE_STRING = "%s";
    static final String CHANGE_INT = "%d";
    static final String OUTPUT_RESULT_SUCCESS = "성공";
    static final String OUTPUT_RESULT_FAIL = "실패";

    public BridgeResult() {
        sideIndies = new ArrayList<>();
        for (int index = 0; index < BridgeSideIndex.values().length; index++) {
            sideIndies.add(new ArrayList<>());
        }
        tryTime = 1;
    }

    public void addSideIndies(List<String> bridge, String move) {
        int eachSideIndiesSize = getEachSideIndiesSize();
        List<BridgeSideIndex> bridgeSideIndices = List.of(BridgeSideIndex.values());
        for (int index = 0; index < bridgeSideIndices.size(); index++) {
            String printIndex = getPrintIndex(bridgeSideIndices.get(index).getLabel()
                    , bridge.get(eachSideIndiesSize)
                    , move);
            sideIndies.get(index).add(printIndex);
        }
    }

    public String getPrintIndex(String bridgeSideIndex, String bridgeIndex, String move) {
        if (bridgeSideIndex.equals(move)) {
            if (bridgeIndex.equals(bridgeSideIndex)) {
                return BridgeSidePrintIndex.CORRECT.getLabel();
            }
            return BridgeSidePrintIndex.WRONG.getLabel();
        }
        return BridgeSidePrintIndex.BLANK.getLabel();
    }

    public void retryResult() {
        int eachSideIndiesLastIndex = getEachSideIndiesSize() - 1;
        if (eachSideIndiesLastIndex < 0) {
            return;
        }
        for (List<String> eachSideIndies : sideIndies) {
            eachSideIndies.remove(eachSideIndiesLastIndex);
        }
        tryTime += 1;
    }

    public String getMap() {
        StringBuilder map = new StringBuilder();
        for (List<String> eachSideIndies : sideIndies) {
            String eachSideMap = String.join(OUTPUT_BRIDGE_SIDE_SEPARATOR, eachSideIndies);
            map.append(OUTPUT_BRIDGE_SIDE.replace(CHANGE_STRING, eachSideMap));
        }
        return map.toString();
    }

    public String getResult(int bridgeLength) {
        return FINAL_RESULT +
                getMap() + System.lineSeparator() +
                getSuccessResult(bridgeLength) +
                getTryResult();
    }

    public int getEachSideIndiesSize() {
        return sideIndies.get(0).size();
    }

    public boolean lastBridgeCorrect() {
        for (List<String> eachSideIndies : sideIndies) {
            if (eachSideIndies.contains(BridgeSidePrintIndex.WRONG.getLabel()))
                return false;
        }
        return true;
    }

    private String getTryResult() {
        return OUTPUT_TRY_TIME.replace(CHANGE_INT, String.valueOf(tryTime));
    }

    private String getSuccessResult(int bridgeLength) {
        String successResult = OUTPUT_CHECK_SUCCESS;
        if (bridgeLength == getEachSideIndiesSize()) {
            return successResult.replace(CHANGE_STRING, OUTPUT_RESULT_SUCCESS);
        }
        return successResult.replace(CHANGE_STRING, OUTPUT_RESULT_FAIL);
    }

}
