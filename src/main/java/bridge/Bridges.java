package bridge;

import bridge.enums.BridgeMove;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridges {

    private static final String MAP_START = "[";
    private static final String MAP_FINISH = "]";
    private final List<BridgeMove> bridges;
    private final List<BridgeMove> playerMoves = new ArrayList<>();
    private final StringBuilder sb = new StringBuilder();

    public Bridges(List<String> inputBridges) {
        validateBridgeSize(inputBridges);
        bridges = inputBridges.stream().map(BridgeMove::getEnum)
                .collect(Collectors.toList());
    }

    public boolean tryPass(BridgeMove moving) {
        if (isAllPassed()) {
            return false;
        }
        playerMoves.add(moving);
        return BridgeMove.isMoveEqual(bridges.get(playerMoves.size() - 1), moving.getMove());
    }

    public boolean isAllPassed() {
        if (bridges.size() != playerMoves.size()) {
            return false;
        }
        return IntStream.range(0, bridges.size()).allMatch(
                i -> this.bridges.get(i) == playerMoves.get(i));
    }

    public void init() {
        this.playerMoves.clear();
        sb.setLength(0);
    }

    public List<BridgeMove> getPlayerMoves() {
        return this.playerMoves;
    }

    public List<BridgeMove> getBridges() {
        return this.bridges;
    }

    private void validateBridgeSize(List<String> inputBridges) {
        int size = inputBridges.size();
        if(!((3 <= size) && (size <= 20))) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        sb.setLength(0);
        for (BridgeMove bridgeLine : BridgeMove.values()) {
            appendMapLine(bridgeLine);
        }
        return sb.toString();
    }

    private void appendMapLine(BridgeMove bridgeMove) {
        sb.append(MAP_START);
        for (int i = 0; i < playerMoves.size(); i++) {
            appendRightMove(bridgeMove.getMove(), i);
        }
        appendWrongMove(bridgeMove.getMove());
        sb.deleteCharAt(sb.length() - 1);
        sb.append(MAP_FINISH + "\n");
    }

    private void appendRightMove(String move, int index) {
        if (playerMoves.get(index) == bridges.get(index)) {
            if (playerMoves.get(index) == BridgeMove.getEnum(move)) {
                sb.append(" O |");
            }
            if (!(playerMoves.get(index) == BridgeMove.getEnum(move))) {
                sb.append("   |");
            }
        }
    }

    private void appendWrongMove(String move) {
        if (playerMoves.isEmpty()) { return;}
        int index = playerMoves.size() - 1;
        if (!(playerMoves.get(index) == bridges.get(index))) {
            if (playerMoves.get(index) == BridgeMove.getEnum(move)) {
                sb.append(" X |");
            }
            if (!(playerMoves.get(index) == BridgeMove.getEnum(move))) {
                sb.append("   |");
            }
        }
    }
}
