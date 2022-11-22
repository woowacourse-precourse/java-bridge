package bridge.service;

import static bridge.rule.AnswerChecker.convert;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.dto.BridgeResponseDto;
import bridge.dto.BridgeResultResponseDto;
import java.util.List;

public class BridgeService {

    private final BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();

    private final BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);

    private final Player player = new Player();

    private final BridgeGame bridgeGame = new BridgeGame(player);

    public void generate(int size){
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame.generate(bridge);
    }

    public void move(String moving){
        bridgeGame.move(moving);
    }

    public BridgeResponseDto showBridge(){
        BridgeResponseDto bridgeResponseDto = new BridgeResponseDto();
        return bridgeResponseDto.showBridge(player);
    }

    public boolean isFailToAnswer(){
        return player.isFailToAnswer();
    }

    public boolean isAllAnswer(){
        return bridgeGame.isAllAnswer();
    }

    public void retry(){
        bridgeGame.retry();
    }

    public BridgeResultResponseDto showResult() {
        return new BridgeResultResponseDto(bridgeGame.showTryCount(), convert(bridgeGame.isAllAnswer()));
    }
}
