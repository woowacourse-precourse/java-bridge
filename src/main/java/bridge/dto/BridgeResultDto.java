package bridge.dto;

import bridge.domain.move.MoveResult;

import java.util.List;
import java.util.stream.Collectors;

public class BridgeResultDto {

    private final List<String> upResult;
    private final List<String> downResult;

    public BridgeResultDto(List<String> upResult, List<String> downResult) {
        this.upResult = upResult;
        this.downResult = downResult;
    }

    public static BridgeResultDto of(List<MoveResult> upResult, List<MoveResult> downResult) {
        return new BridgeResultDto(toStringList(upResult), toStringList(downResult));
    }

    private static List<String> toStringList(List<MoveResult> result) {
        return result.stream()
                .map(MoveResult::symbol)
                .collect(Collectors.toList());
    }

    public List<String> getUpResult() {
        return upResult;
    }

    public List<String> getDownResult() {
        return downResult;
    }
}
