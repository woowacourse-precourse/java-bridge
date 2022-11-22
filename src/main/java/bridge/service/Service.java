package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.utils.Converter;

import java.util.List;

public class Service {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final Converter converter = new Converter();
    private final Record record = new Record();
    private BridgeGame game;

    public void prepareGame(String bridgeSizeInput) {
        int bridgeSize = converter.toIntFromString(bridgeSizeInput);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        User user = new User();
        Result result = new Result();
        game = new BridgeGame(answerBridge, user, result);
    }

    public void move(String moveInput) {
        boolean moveSuccess = game.move(moveInput);
        record.write(moveInput, moveSuccess);
    }

    public List<String> getCurrentResult() {
        return record.getRecordedMap();
    }

    public String getPlayResult() {
        return game.getPlayResult();
    }

    public List<String> getFinalResult() {
        return game.getFinalResult();
    }

    public void resetForRetry() {
        game.retry();
        record.initialize();
    }
}
