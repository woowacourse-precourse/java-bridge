package bridge.view;

import bridge.model.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START_ALERT = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_LENGTH_INPUT_ALERT = "다리의 길이를 입력해주세요.";
    private final String NEXT_MOVEMENT_INPUT_ALERT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_INPUT_ALERT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final String LAST_MOVEMENT_RESULT_LABEL = "최종 게임 결과";

    private final String IF_IS_SUCCESS_PREFIX = "게임 성공 여부: ";
    private final String TRY_COUNT_PREFIX = " 총 시도한 횟수: ";
    private final String ERROR_PREFIX = "[ERROR] ";

    private final String SUCCESS_TEXT = "성공";
    private final String FAIL_TEXT = "실패";

    private final String SAFE_SYMBOL = "O";
    private final String UNSAFE_SYMBOL = "X";

    private final String BLANK = " ";

    public void printGameStartAlert() {
        System.out.println(GAME_START_ALERT);
    }
    public void printBridgeLengthInputAlert() {
        System.out.println(BRIDGE_LENGTH_INPUT_ALERT);
    }
    public void printNextMovementInputAlert() {
        System.out.println(NEXT_MOVEMENT_INPUT_ALERT);
    }
    public void printRetryInputAlert() {
        System.out.println(RETRY_INPUT_ALERT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        Bridge bridge = bridgeGame.getBridge();
        BridgeGameResult bridgeGameResult = bridgeGame.getResult();

        System.out.println(getBridgeMovementText(bridge, bridgeGameResult));

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, BridgeGameResult bridgeGameResult) {
        System.out.println(LAST_MOVEMENT_RESULT_LABEL);
        System.out.println(getBridgeMovementText(bridge, bridgeGameResult));
        System.out.println(getIfIsSuccessText(bridgeGameResult));
        System.out.println(getTryCountText(bridgeGameResult));
    }

    public void printError(String errorText) {
        System.out.println(ERROR_PREFIX + errorText);
    }

    private String getBridgeMovementText(Bridge bridge, BridgeGameResult bridgeGameResult) {
        StringBuilder output = new StringBuilder();
        SpotInfo[] lineSpots = SpotInfo.values();
        for (SpotInfo lineSpot : lineSpots) {
            output.append(getOneLineTextOnBridgeMovement(bridge, bridgeGameResult, lineSpot));
            output.append("\n");
        }
        return output.toString();
    }

    private String getOneLineTextOnBridgeMovement(Bridge bridge, BridgeGameResult bridgeGameResult, SpotInfo line) {
        StringBuilder oneLineOnBridge = new StringBuilder("[");
        for(int i = 1; i <= bridgeGameResult.getLastMovementCount(); i++) {
            oneLineOnBridge.append(getSpotText(bridge, bridgeGameResult, i, line));
            if(i != bridgeGameResult.getLastMovementCount()) {
                oneLineOnBridge.append("|");
            }
        }
        oneLineOnBridge.append("]");
        return oneLineOnBridge.toString();
    }

    private String getIfIsSuccessText(BridgeGameResult bridgeGameResult) {
        if(bridgeGameResult.isSuccess()) {
            return IF_IS_SUCCESS_PREFIX + SUCCESS_TEXT;
        }
        return IF_IS_SUCCESS_PREFIX + FAIL_TEXT;
    }

    private String getTryCountText(BridgeGameResult bridgeGameResult) {
        return TRY_COUNT_PREFIX + bridgeGameResult.getTryCount();
    }

    private String getSpotText(Bridge bridge, BridgeGameResult bridgeGameResult, int index, SpotInfo spotInfo) {
        SpotInfo targetMovement = bridgeGameResult.getLastMovementRecord(index);
        if(targetMovement == spotInfo) {
            return BLANK + getSafetySymbol(bridge, index, spotInfo) + BLANK;
        }
        return BLANK + BLANK + BLANK;
    }

    private String getSafetySymbol(Bridge bridge, int index, SpotInfo spotInfo) {
        if(bridge.isSafeSpot(index, spotInfo)) {
            return SAFE_SYMBOL;
        }
        return UNSAFE_SYMBOL;
    }
}
