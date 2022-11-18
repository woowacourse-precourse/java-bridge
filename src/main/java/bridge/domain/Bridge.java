package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;

    public static final String BRIDGE_SIZE_EXCEPTION_MESSAGE = "[ERROR] 다리의 길이는 %d부터 %d 사이의 숫자여야 합니다.";

    private final List<Tile> bridgeTiles;

    private Bridge(List<Tile> bridgeTiles) {
        this.bridgeTiles = List.copyOf(bridgeTiles);
    }

    public static Bridge from(List<String> bridgePositions) {
        validateBridgePositions(bridgePositions);

        List<Tile> tiles = new ArrayList<>();
        for (String position : bridgePositions) {
            tiles.add(Tile.findByTilePosition(position));
        }

        return new Bridge(tiles);
    }

    private static void validateBridgePositions(List<String> bridgePositions) {
        if (bridgePositions.size() < MIN_SIZE || bridgePositions.size() > MAX_SIZE) {
            throw new IllegalArgumentException(String.format(BRIDGE_SIZE_EXCEPTION_MESSAGE, MIN_SIZE, MAX_SIZE));
        }
    }

    public boolean checkBridgeTileAt(int playerPosition, Tile nextTile) {
        if (bridgeTiles.get(playerPosition).equals(nextTile)) {
            return true;
        }
        return false;
    }

    public Tile getTileOf(int index) {
        return bridgeTiles.get(index);
    }

    public int getBridgeSize() {
        return bridgeTiles.size();
    }
}
