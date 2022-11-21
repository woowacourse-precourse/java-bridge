package bridge.service;

import bridge.domain.*;
import bridge.utils.Converter;

import java.util.List;

public class Service {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    Converter converter = new Converter();
    Record record = new Record();
    BridgeGame game;

    public void prepareGame(String bridgeSizeInput) {
        int bridgeSize = converter.toIntFromString(bridgeSizeInput);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        User user = new User();
        game = new BridgeGame(answerBridge, user);
    }

    public void move(String moveInput) {
        boolean moveSuccess = game.move(moveInput);
        record.write(moveInput, moveSuccess);
    }

    public List<String> getCurrentResult() {
        return record.getResult();
    }

    public String getPlayResult() {
        return game.getPlayResult();
    }

    public List<String> getFinalResult() {
        return record.getFinalResultToString();
    }

    public void resetForRetry() {
        game.initialize();
        record.initialize();
        record.plusTryCount();
    }
}
