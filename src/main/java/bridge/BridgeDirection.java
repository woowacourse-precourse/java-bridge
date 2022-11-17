package bridge;

import java.util.Arrays;
import java.util.Optional;

public enum BridgeDirection {
    DOWN("D", 0),
    UP("U", 1);
    
    private String select;
    private Integer generateNumber;
    
    BridgeDirection(String select, Integer generateNumber) {
        this.select = select;
        this.generateNumber = generateNumber;
    }
    
    public String getSelect() {
        return select;
    }
    
    /**
     * @param generateNumber 0 또는 1, 아니면 AssertionError
     * @return generateNumber에 매치되는 값
     */
    public static BridgeDirection generateByNumber(Integer generateNumber) {
        Optional<BridgeDirection> direction = findByGenerateNumber(generateNumber);
        return direction.orElseThrow(() -> new AssertionError("다리 생성 무작위 값이 잘못되었씁니다."));
    }
    
    private static Optional<BridgeDirection> findByGenerateNumber(Integer generateNumber) {
        return Arrays.stream(BridgeDirection.values())
                .filter(bridgeDirection -> bridgeDirection.generateNumber.equals(generateNumber))
                .findAny();
    }
}
