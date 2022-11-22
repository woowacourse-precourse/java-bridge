package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;

    private static final String BRIDGE_SIZE_EXCEPTION_MESSAGE_FORMAT = "[ERROR] 다리의 길이는 %d부터 %d 사이의 숫자여야 합니다.";

    private final List<Tile> bridgeTiles;

    private Bridge(List<Tile> bridgeTiles) {
        this.bridgeTiles = List.copyOf(bridgeTiles);
    }

    public static Bridge from(List<String> tileDirectionSigns) {
        validateBridgeSize(tileDirectionSigns);

        List<Tile> tiles = new ArrayList<>();
        for (String directionSign : tileDirectionSigns) {
            tiles.add(Tile.findByDirectionSign(directionSign));
        }

        return new Bridge(tiles);
    }

    private static void validateBridgeSize(List<String> bridgeDirections) {
        if (bridgeDirections.size() < MIN_SIZE || bridgeDirections.size() > MAX_SIZE) {
            throw new IllegalArgumentException(String.format(BRIDGE_SIZE_EXCEPTION_MESSAGE_FORMAT, MIN_SIZE, MAX_SIZE));
        }
    }

    public boolean checkBridgeTileAt(int positionIndex, Tile tile) {
        return bridgeTiles.get(positionIndex).equals(tile);
    }

    public int size() {
        return bridgeTiles.size();
    }
}
