package bridge.application;

import bridge.domain.repository.BridgeRepository;
import bridge.presentation.dto.BridgeSize;

public class GameService {
    private static final GameService instance=new GameService();
    private final BridgeRepository bridgeRepository;
    private GameService(){
        bridgeRepository=BridgeRepository.getInstance();
    }
    public static GameService getInstance(){
        return instance;
    }
    public void saveBridgeSize(BridgeSize bridgeSize){
        bridgeRepository.saveBridgeSize(bridgeSize);
    }
}
