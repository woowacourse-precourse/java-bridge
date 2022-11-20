package bridge;

import bridge.domain.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 반환
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeTileDirectionSigns = new ArrayList<>();

        while (bridgeTileDirectionSigns.size() < size) {
            int bridgeTileCode = bridgeNumberGenerator.generate();
            Tile tile = Tile.findByCode(bridgeTileCode);
            bridgeTileDirectionSigns.add(tile.getDirectionSign());
        }

        return bridgeTileDirectionSigns;
    }
}
