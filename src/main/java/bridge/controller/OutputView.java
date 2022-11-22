package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeLane;

public class OutputView {
    private final String GAME_START_ALERT = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_LENGTH_INPUT_ALERT = "다리의 길이를 입력해주세요.";
    private final String NEXT_MOVEMENT_INPUT_ALERT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_INPUT_ALERT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final String LAST_MOVEMENT_RESULT_LABEL = "최종 게임 결과";

    private final String IF_IS_SUCCESS_PREFIX = "게임 성공 여부: ";
    private final String TRY_COUNT_PREFIX = "총 시도한 횟수: ";
    private final String ERROR_PREFIX = "[ERROR] ";

    private final String SUCCESS_TEXT = "성공";
    private final String FAIL_TEXT = "실패";

    private final String SAFE_SYMBOL = "O";
    private final String UNSAFE_SYMBOL = "X";

    private final String BLANK = " ";

    public void printGameStartAlert() {
        System.out.println(GAME_START_ALERT);
    }

    public void printBridgeSizeInputAlert() {
        System.out.println(BRIDGE_LENGTH_INPUT_ALERT);
    }

    public void printNextMovementInputAlert() {
        System.out.println(NEXT_MOVEMENT_INPUT_ALERT);
    }

    public void printRetryInputAlert() {
        System.out.println(RETRY_INPUT_ALERT);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printError(String errorText) {
        System.out.println(ERROR_PREFIX + errorText);
    }

    public void printMap(BridgeGame bridgeGame) {
        System.out.println(getMovementText(bridgeGame));
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(LAST_MOVEMENT_RESULT_LABEL);
        System.out.println(getMovementText(bridgeGame));
        System.out.println(getIfIsSuccessText(bridgeGame));
        System.out.println(getTryCountText(bridgeGame));
    }

    private String getMovementText(BridgeGame bridgeGame) {
        StringBuilder output = new StringBuilder();
        BridgeLane[] lineSpots = BridgeLane.values();
        for (BridgeLane lineSpot : lineSpots) {
            output.append(getOneLaneMovementText(bridgeGame, lineSpot));
            output.append("\n");
        }
        return output.toString();
    }

    private String getOneLaneMovementText(BridgeGame bridgeGame, BridgeLane bridgeLane) {
        StringBuilder output = new StringBuilder("[");
        for(int i = 1; i <= bridgeGame.getCurrentPosition(); i++) {
            output.append(getSpotText(bridgeGame, i, bridgeLane));
            if(i != bridgeGame.getCurrentPosition()) {
                output.append("|");
            }
        }
        output.append("]");
        return output.toString();
    }

    private String getIfIsSuccessText(BridgeGame bridgeGame) {
        if(bridgeGame.getStatus() == BridgeGame.Status.SUCCESS) {
            return IF_IS_SUCCESS_PREFIX + SUCCESS_TEXT;
        }
        return IF_IS_SUCCESS_PREFIX + FAIL_TEXT;
    }

    private String getTryCountText(BridgeGame bridgeGame) {
        return TRY_COUNT_PREFIX + bridgeGame.getTryCount();
    }

    private String getSpotText(BridgeGame bridgeGame, int index, BridgeLane spotInfo) {
        BridgeLane targetMovement = bridgeGame.getCurrentMovementAtPosition(index);
        if(targetMovement == spotInfo) {
            return BLANK + getSafetySymbol(bridgeGame, index, spotInfo) + BLANK;
        }
        return BLANK + BLANK + BLANK;
    }

    private String getSafetySymbol(BridgeGame bridgeGame, int index, BridgeLane spotInfo) {
        if(bridgeGame.isSafeSpot(index, spotInfo)) {
            return SAFE_SYMBOL;
        }
        return UNSAFE_SYMBOL;
    }
}
