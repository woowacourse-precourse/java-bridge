package bridge.service;

import bridge.dto.BridgeDto;
import bridge.repository.BridgeRepository;

public class BridgeService {
    private final BridgeRepository bridgeRepository = BridgeRepository.getInstance();

    public void initBridge(BridgeDto bridgeDto) {
        bridgeRepository.save(bridgeDto.toEntity());
    }

    public int getBridgeSize() {
        return bridgeRepository.getBridgeSize();
    }

    public boolean isPassable(int distance, String direction) {
        String passableDirection = bridgeRepository.getPassableDirectionAt(distance);
        return direction.equals(passableDirection);
    }
}
