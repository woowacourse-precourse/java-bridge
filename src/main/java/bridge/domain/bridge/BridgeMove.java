package bridge.domain.bridge;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum BridgeMove {
    UP("U", 1),
    DOWN("D", 0);
    
    private final String direction;
    private final Integer generateNumber;
    
    BridgeMove(String direction, Integer generateNumber) {
        this.direction = direction;
        this.generateNumber = generateNumber;
    }
    
    public String getDirection() {
        return direction;
    }
    
    public Integer getGenerateNumber() {
        return generateNumber;
    }
    
    public static boolean isContain(String direction) {
        return getDirectionList().contains(direction);
    }
    
    private static List<String> getDirectionList() {
        return Arrays.stream(BridgeMove.values()).map((BridgeMove::getDirection)).collect(
                Collectors.toList());
    }
    
    /**
     * @param generateNumber 0 또는 1, 아니면 AssertionError
     * @return generateNumber에 매치되는 값
     */
    public static BridgeMove generateByNumber(Integer generateNumber) {
        Optional<BridgeMove> bridgeMove = findByGenerateNumber(generateNumber);
        return bridgeMove.orElseThrow(() -> new AssertionError("다리 생성 무작위 값이 잘못되었씁니다."));
    }
    
    public static Optional<BridgeMove> findByDirection(String direction) {
        return Arrays.stream(BridgeMove.values())
                .filter(bridgeDirection -> bridgeDirection.direction.equals(direction))
                .findAny();
    }
    
    private static Optional<BridgeMove> findByGenerateNumber(Integer generateNumber) {
        return Arrays.stream(BridgeMove.values())
                .filter(bridgeDirection -> bridgeDirection.generateNumber.equals(generateNumber))
                .findAny();
    }
}
