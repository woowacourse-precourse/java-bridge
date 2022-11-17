package bridge.application;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.domain.repository.BridgeRepository;
import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.SelectMove;

public class GameService {
    private static final GameService instance=new GameService();
    private final BridgeRepository bridgeRepository;
    private final BridgeMaker bridgeMaker;
    private GameService(){
        bridgeRepository=BridgeRepository.getInstance();
        bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    public static GameService getInstance(){
        return instance;
    }
    public void generatorBridge(){
        bridgeRepository.updateBridge(bridgeMaker.makeBridge(bridgeRepository.getBridgeSize().getSize()));
    }
    public void saveBridgeSize(BridgeSize bridgeSize){
        bridgeRepository.saveBridgeSize(bridgeSize);
    }
    public void saveSelectMove(SelectMove selectMove){bridgeRepository.saveSelectMove(selectMove);}
}
