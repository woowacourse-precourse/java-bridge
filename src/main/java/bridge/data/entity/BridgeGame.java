package bridge.data.entity;

import static bridge.type.CommonConstantType.MAX_BRIDGE_SIZE;
import static bridge.type.CommonConstantType.MIN_BRIDGE_SIZE;
import static bridge.type.ErrorMessageDevType.BAD_BRIDGE_SIZE_MESSAGE;
import static bridge.type.ErrorMessageDevType.BAD_FAIL_MENU_COMMAND_REQUEST_MESSAGE;
import static bridge.type.ErrorMessageDevType.BAD_GAME_COMMAND_MESSAGE;
import static bridge.type.ErrorMessageDevType.BAD_MAP_COMPONENT_MESSAGE;

import bridge.type.FailMenuCommandType;
import bridge.type.InGameCommandType;
import bridge.type.MapComponentType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String sessionId;
    private final List<String> bridgeMap;
    private final List<String> moves;
    private Integer tryCount;

    public BridgeGame(List<String> bridgeMap) {
        validateMap(bridgeMap);
        this.sessionId = UUID.randomUUID().toString();
        this.bridgeMap = Collections.unmodifiableList(bridgeMap);
        this.moves = new ArrayList<>();
        this.tryCount = 1;
    }

    private static void validateMap(List<String> bridgeMap) {
        checkBridgeSize(bridgeMap);
        checkMapComponents(bridgeMap);
    }

    private static void checkBridgeSize(List<String> bridgeMap) {
        if (isBridgeSizeOutOfRange(bridgeMap)) {
            String exceptionMessage = String.format(BAD_BRIDGE_SIZE_MESSAGE.toString(), bridgeMap.size());
            throw new IllegalStateException(exceptionMessage);
        }
    }

    private static boolean isBridgeSizeOutOfRange(List<String> bridgeMap) {
        return bridgeMap.size() < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeMap.size();
    }

    private static void checkMapComponents(List<String> bridgeMap) {
        String badMapComponent = findBadMapComponent(bridgeMap);
        if (isPresent(badMapComponent)) {
            String exceptionMessage = String.format(BAD_MAP_COMPONENT_MESSAGE.toString(), badMapComponent);
            throw new IllegalStateException(exceptionMessage);
        }
    }

    private static String findBadMapComponent(List<String> bridgeMap) {
        return bridgeMap.stream().parallel()
                .filter(MapComponentType::isBadMapComponent)
                .findAny()
                .orElse(null);
    }

    private static boolean isPresent(Object nullable) {
        return nullable != null;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move(InGameCommandType command) {
        validateMovableState();
        moves.add(command.getInput());
    }

    private void validateMovableState() {
        if (isPlayerAlive()) {
            return;
        }
        throw new IllegalStateException(BAD_GAME_COMMAND_MESSAGE.toString());
    }

    private boolean isPlayerAlive() {
        int index = moves.size() - 1;
        return moves.isEmpty() || moves.get(index).equals(bridgeMap.get(index));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry(FailMenuCommandType command) {
        validateRetryableState();
        if (command == FailMenuCommandType.RETRY) {
            tryCount++;
            moves.clear();
        }
    }

    private void validateRetryableState() {
        if (isPlayerAlive()) {
            throw new IllegalStateException(BAD_FAIL_MENU_COMMAND_REQUEST_MESSAGE.toString());
        }
    }

    public String getSessionId() {
        return sessionId;
    }

    public List<String> getBridgeMap() {
        return bridgeMap;
    }

    public List<String> getMoves() {
        return moves;
    }

    public Integer getTryCount() {
        return tryCount;
    }

}
