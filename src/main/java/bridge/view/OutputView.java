package bridge.view;

import bridge.domain.BridgePlayer;

import static bridge.constant.BridgeConst.*;
import static bridge.constant.BridgeControl.QUIT;
import static bridge.constant.BridgeControl.RESTART;
import static bridge.constant.BridgeMove.DOWN;
import static bridge.constant.BridgeMove.UP;
import static bridge.constant.message.InputMessage.*;
import static bridge.constant.message.OutputMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final Integer FIRST_SIZE = 1;

    private final StringBuilder bridgeUpMap, bridgeDownMap;

    private final BridgePlayer bridgePlayer;

    public OutputView(BridgePlayer bridgePlayer) {
        // 맵은 가장 처음 '['으로 시작한다.
        bridgeUpMap = new StringBuilder(MAP_START.getIdentifier());
        bridgeDownMap = new StringBuilder(MAP_START.getIdentifier());
        this.bridgePlayer = bridgePlayer;
    }

    public void printStartMessage() {
        System.out.println(START.getMessage());
    }

    public void printBridgeLengthMessage() {
        System.out.println(BRIDGE_LENGTH.getMessage());
    }

    public void printPlayerMoveMessage() {
        System.out.printf(SELECT_MOVE.getMessage(), UP.getIdentifier(), DOWN.getIdentifier());
    }

    public void printPlayControlMessage() {
        System.out.printf(PLAY_CONTROL.getMessage(), RESTART.getIdentifier(), QUIT.getIdentifier());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(boolean isRetry) {
        deleteLastSeparator(isRetry);
        makeBridgeSeparator(isRetry);
        makeBridgePart();
        makeBridgeEnd();
        printCompleteBridgeMap();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(RESULT.getMessage());
        printCompleteBridgeMap();
        System.out.printf(SUCCESS_OR_FAILURE.getMessage(), getGameResult());
        System.out.printf(TOTAL_ATTEMPTS.getMessage(), bridgePlayer.getTryCount());
    }

    private void deleteLastSeparator(boolean isRetry) {
        if (isRetry) {
            deleteBridgeSeparatorByRetry();
            return;
        }
        deleteBridgeLastSeparator();
    }

    /**
     * 재시도했을 때 이전의 다리 기록에 대해서 삭제를 진행한다.
     */
    private void deleteBridgeSeparatorByRetry() {
        bridgeUpMap.delete(bridgeUpMap.length() - 4, bridgeUpMap.length());
        bridgeDownMap.delete(bridgeDownMap.length() - 4, bridgeDownMap.length());
    }

    /**
     * 첫 시도를 제외하고 이전의 시도에서 맵은 ']'로 끝나기 때문에, 추가를 위한 제거 작업을 진헹한다.
     */
    private void deleteBridgeLastSeparator() {
        if (bridgeUpMap.length() == FIRST_SIZE) {
            return;
        }
        bridgeUpMap.deleteCharAt(bridgeUpMap.length() - 1);
        bridgeDownMap.deleteCharAt(bridgeDownMap.length() - 1);
    }

    /**
     * 첫 시도, 재시도를 제외하고 이전의 시도에 덧붙이기 위해 '|'룰 추가한다.
     */
    private void makeBridgeSeparator(boolean isRetry) {
        if (bridgeUpMap.length() == FIRST_SIZE || isRetry) {
            return;
        }
        bridgeUpMap.append(MAP_SEPARATOR.getIdentifier());
        bridgeDownMap.append(MAP_SEPARATOR.getIdentifier());
    }

    /**
     * 사용자가 입력한 값에 따라서 결과를 표시한다.
     */
    private void makeBridgePart() {
        if (bridgePlayer.isMoveUp()) {
            makeBridgeUpPart();
            bridgeDownMap.append(MAP_BLANK.getIdentifier());
            return;
        }
        makeBridgeDownPart();
        bridgeUpMap.append(MAP_BLANK.getIdentifier());
    }

    /**
     * 결과에 따라 위쪽 다리에 표시를 진행한다.
     */
    private void makeBridgeUpPart() {
        if (bridgePlayer.isSuccess()) {
            bridgeUpMap.append(POSSIBLE.getIdentifier());
            return;
        }
        bridgeUpMap.append(IMPOSSIBLE.getIdentifier());
    }

    /**
     * 결과에 따라 아래쪽 다리에 표시를 진행한다.
     */
    private void makeBridgeDownPart() {
        if (bridgePlayer.isSuccess()) {
            bridgeDownMap.append(POSSIBLE.getIdentifier());
            return;
        }
        bridgeDownMap.append(IMPOSSIBLE.getIdentifier());
    }

    /**
     * 공백과 ']'를 추가하여 다리의 끝을 완성한다.
     */
    private void makeBridgeEnd() {
        bridgeUpMap.append(MAP_END.getIdentifier());
        bridgeDownMap.append(MAP_END.getIdentifier());
    }

    private String getGameResult() {
        if (bridgePlayer.isSuccess()) {
            return SUCCESS.getIdentifier();
        }
        return FAILURE.getIdentifier();
    }

    private void printCompleteBridgeMap() {
        System.out.println(bridgeUpMap.toString());
        System.out.println(bridgeDownMap.toString());
        System.out.println();
    }
}
