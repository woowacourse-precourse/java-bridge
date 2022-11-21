package bridge.view;

import bridge.model.BridgeGameStage;
import bridge.model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.constant.BridgeGameConstant.*;

public class OutputView {

    private static final String SUCCESS_BRIDGE_BLOCK_VIEW = " O ";
    private static final String FAIL_BRIDGE_BLOCK_VIEW = " X ";
    private static final String EMPTY_BRIDGE_BLOCK_VIEW = "   ";
    private static final String BRIDGE_START_VIEW = "[";
    private static final String BRIDGE_END_VIEW = "]";
    private static final String BRIDGE_MIDDLE_VIEW = "|";

    public void printGameStartScript() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInputScript() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public void printMovingInputScript() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: " + UP_BRIDGE_BLOCK + ", 아래: " + DOWN_BRIDGE_BLOCK + ")");
    }

    public void printGameCommandInputScript() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + RETRY_COMMAND + ", 종료: " + QUIT_COMMAND + ")");
    }

    public void printGameResultScript() {
        System.out.println("\n최종 게임 결과");
    }

    public void printMap(List<BridgeGameStage> currentGameStages) {
        List<String> upBridgeBlockViews = new ArrayList<>(), downBridgeBlockViews = new ArrayList<>();
        for (BridgeGameStage gameStage : currentGameStages) {
            upBridgeBlockViews.add(getUpBridgeBlockView(gameStage.getBridgeBlock(), gameStage.getStatus()));
            downBridgeBlockViews.add(getDownBridgeBlockView(gameStage.getBridgeBlock(), gameStage.getStatus()));
        }
        System.out.println(buildBridgeView(upBridgeBlockViews));
        System.out.println(buildBridgeView(downBridgeBlockViews));
    }

    private String getUpBridgeBlockView(String bridgeBlock, Status blockStatus) {
        if (Objects.equals(bridgeBlock, UP_BRIDGE_BLOCK)) {
            if (blockStatus == Status.CROSSED) return SUCCESS_BRIDGE_BLOCK_VIEW;
            return EMPTY_BRIDGE_BLOCK_VIEW;
        }
        if (blockStatus == Status.NOT_CROSSED) return FAIL_BRIDGE_BLOCK_VIEW;
        return EMPTY_BRIDGE_BLOCK_VIEW;
    }

    private String getDownBridgeBlockView(String bridgeBlock, Status blockStatus) {
        if (Objects.equals(bridgeBlock, DOWN_BRIDGE_BLOCK)) {
            if (blockStatus == Status.CROSSED) return SUCCESS_BRIDGE_BLOCK_VIEW;
            return EMPTY_BRIDGE_BLOCK_VIEW;
        }
        if (blockStatus == Status.NOT_CROSSED) return FAIL_BRIDGE_BLOCK_VIEW;
        return EMPTY_BRIDGE_BLOCK_VIEW;
    }

    private String buildBridgeView(List<String> bridgeBlockViews) {
        StringBuilder builder = new StringBuilder();
        builder.append(BRIDGE_START_VIEW).append(bridgeBlockViews.remove(0));
        bridgeBlockViews.forEach(view -> builder.append(BRIDGE_MIDDLE_VIEW).append(view));
        builder.append(BRIDGE_END_VIEW);
        return builder.toString();
    }

    public void printResult(boolean isSuccess, int numberOfAttempt) {
        String gameResultPhrase = getGameResultPhrase(isSuccess);
        System.out.println("\n게임 성공 여부: " + gameResultPhrase);
        System.out.println("총 시도한 횟수: " + numberOfAttempt);
    }

    private String getGameResultPhrase(boolean isSuccess) {
        if (isSuccess) return "성공";
        return "실패";
    }
}
