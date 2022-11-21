package bridge.data.entity;

import static bridge.type.CommonConstantType.MAX_BRIDGE_SIZE;
import static bridge.type.CommonConstantType.MIN_BRIDGE_SIZE;
import static bridge.type.ErrorMessageDevType.BAD_BRIDGE_SIZE_MESSAGE;
import static bridge.type.ErrorMessageDevType.BAD_MAP_COMPONENT_MESSAGE;

import bridge.type.MapComponentType;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String sessionId;
    private final List<String> bridgeMap;
    private Integer nextColumn;
    private Integer tryCount;

    public BridgeGame(List<String> bridgeMap) {
        validate(bridgeMap);
        this.sessionId = UUID.randomUUID().toString();
        this.bridgeMap = Collections.unmodifiableList(bridgeMap);
        this.nextColumn = 0;
        this.tryCount = 0;
    }

    public String getSessionId() {
        return sessionId;
    }

    private static void validate(List<String> bridgeMap) {
        validateBridgeSize(bridgeMap);
        validateMapComponents(bridgeMap);
    }

    private static void validateBridgeSize(List<String> bridgeMap) {
        if (bridgeMap.size() < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeMap.size()) {
            String exceptionMessage = String.format(BAD_BRIDGE_SIZE_MESSAGE.toString(), bridgeMap.size());
            throw new IllegalStateException(exceptionMessage);
        }
    }

    private static void validateMapComponents(List<String> bridgeMap) {
        String badMapComponent = bridgeMap.stream().parallel()
                .filter(MapComponentType::isBadMapComponent)
                .findAny()
                .orElse(null);
        if (badMapComponent != null) {
            String exceptionMessage = String.format(BAD_MAP_COMPONENT_MESSAGE.toString(), badMapComponent);
            throw new IllegalStateException(exceptionMessage);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move() {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {

    }
}
