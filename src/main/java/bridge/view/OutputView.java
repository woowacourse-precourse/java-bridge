package bridge.view;


import bridge.model.Direction;
import bridge.model.GameResult;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String CORRECT = "O";
    private static final String MISS = "X";
    private static final String SPACE = " ";
    private static final String PREFIX = "[ ";
    private static final String DELIMITER = " | ";
    private static final String SUFFIX = " ]";
    private static final String FAIL = "실패";
    private static final String SUCCESS = "성공";

    private List<String> upBridge;
    private List<String> downBridge;

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printMap(List<String> bridge, List<Boolean> gameResult) {
        initBridge();
        convertBridge(bridge, gameResult);
        printBridge(upBridge);
        printBridge(downBridge);
        System.out.println();
    }

    private void initBridge() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    private void convertBridge(List<String> bridge, List<Boolean> gameResult) {
        for (int index = 0; index < gameResult.size(); index++) {
            addCorrectResult(bridge, gameResult, index);
            addMissResult(bridge, gameResult, index);
        }
    }

    private void addCorrectResult(List<String> bridge, List<Boolean> gameResult, int index) {
        if (gameResult.get(index)) {
            addCorrectUpResult(bridge, index);
            addCorrectDownResult(bridge, index);
        }
    }

    private void addCorrectUpResult(List<String> bridge, int index) {
        if (Direction.UP.isSame(bridge.get(index))) {
            upBridge.add(CORRECT);
            downBridge.add(SPACE);
        }
    }

    private void addCorrectDownResult(List<String> bridge, int index) {
        if (Direction.DOWN.isSame(bridge.get(index))) {
            upBridge.add(SPACE);
            downBridge.add(CORRECT);
        }
    }

    private void addMissResult(List<String> bridge, List<Boolean> gameResult, int index) {
        if (!gameResult.get(index)) {
            addMissUpResult(bridge, index);
            addMissDownResult(bridge, index);
        }
    }

    private void addMissDownResult(List<String> bridge, int index) {
        if (Direction.DOWN.isSame(bridge.get(index))) {
            upBridge.add(MISS);
            downBridge.add(SPACE);
        }
    }

    private void addMissUpResult(List<String> bridge, int index) {
        if (Direction.UP.isSame(bridge.get(index))) {
            upBridge.add(SPACE);
            downBridge.add(MISS);
        }
    }

    private void printBridge(List<String> bridge) {
        System.out.println(PREFIX + String.join(DELIMITER, bridge) + SUFFIX);
    }


    public void printResult(GameResult result, List<String> bridge, int tryNumber) {
        System.out.println("최종 게임 결과");
        printMap(bridge, result.getGameResult());
        System.out.println("게임 성공 여부: " + getResult(result));
        System.out.println("총 시도한 횟수: " + tryNumber);
    }

    private String getResult(GameResult result) {
        if (result.isGameOver()) {
            return FAIL;
        }
        return SUCCESS;
    }
}
