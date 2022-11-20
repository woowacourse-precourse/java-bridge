package bridge.service;

import bridge.domain.bridge.Bridge;
import bridge.dto.BridgeDto;
import bridge.repository.BridgeRepository;

public class BridgeService {
    private final BridgeRepository bridgeRepository = BridgeRepository.getInstance();

    public void initBridge(BridgeDto bridgeDto) {
        bridgeRepository.update(bridgeDto.toEntity());
    }

    public int getBridgeSize() {
        Bridge bridge = bridgeRepository.get();
        return bridge.size();
    }

    public boolean isPassable(int distance, String movingDirection) {
        Bridge bridge = bridgeRepository.get();
        String passableDirection = bridge.passableDirectionAt(distance);

        return movingDirection.equals(passableDirection);
    }
}
