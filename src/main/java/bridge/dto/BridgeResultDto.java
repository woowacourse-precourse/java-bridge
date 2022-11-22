package bridge.dto;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveType;

import java.util.List;
import java.util.Map;

public class BridgeResultDto {

    private final List<String> upResult;
    private final List<String> downResult;

    public BridgeResultDto(List<String> upResult, List<String> downResult) {
        this.upResult = upResult;
        this.downResult = downResult;
    }

    public static BridgeResultDto of(Map<Square, List<String>> result) {
        return new BridgeResultDto(
                result.get(new Square(MoveType.UP)),
                result.get(new Square(MoveType.DOWN)));
    }

    public List<String> getUpResult() {
        return upResult;
    }

    public List<String> getDownResult() {
        return downResult;
    }
}
