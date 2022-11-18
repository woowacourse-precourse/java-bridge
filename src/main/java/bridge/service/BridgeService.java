package bridge.service;

import bridge.dto.BridgeDto;
import bridge.repository.BridgeRepository;

public class BridgeService {
    private static final BridgeRepository bridgeRepository = BridgeRepository.getInstance();

    public void initBridge(BridgeDto bridgeDto) {
        bridgeRepository.update(bridgeDto.toEntity());
    }
}
