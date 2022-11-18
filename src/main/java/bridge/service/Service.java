package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.utils.Converter;

import java.util.List;

public class Service {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    Converter converter = new Converter();
    BridgeGame game;

    public void prepareGame(String bridgeSizeInput) {
        int bridgeSize = converter.toIntFromString(bridgeSizeInput);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        game = new BridgeGame(answerBridge);
    }
}
