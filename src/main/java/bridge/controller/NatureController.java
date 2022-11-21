package bridge.controller;

import bridge.BridgeGame;
import bridge.mediator.Mediator;
import bridge.dto.BridgeStatusDto;

import java.util.HashMap;
import java.util.function.Function;

public class NatureController implements Controller {

    private BridgeGame bridgeGame;
    private Mediator mediator;
    private Function<Integer, BridgeGame> function;

    public NatureController(Function<Integer, BridgeGame> function,Mediator mediator) {
        this.mediator=mediator;
        this.function = function;
    }

    public void initBridgeGame(int size){
        bridgeGame = function.apply(size);
    }
    @Override
    public Runnable generateBridge(int size) {
        initBridgeGame(size);
        return () -> mediator.moveBridge();
    }

    @Override
    public Runnable moveBridge(String direction, HashMap<String, String> map) {
        BridgeStatusDto bridgeStatusDto = bridgeGame.move(direction);
        map.put("bridge", bridgeStatusDto.getBridge());

        if (bridgeGame.isOverallSuccess()) {
            return () -> mediator.end(bridgeStatusDto);
        }
        if (bridgeGame.isUnitSuccess()) return () -> mediator.moveBridge();
        return () -> mediator.replay();
    }

    @Override
    public Runnable replay(String restartCommand) {
        if (bridgeGame.retry(restartCommand)) {
            bridgeGame.clearFootprints();
            return () -> mediator.moveBridge();
        }

        BridgeStatusDto bridgeStatusDto = bridgeGame.makeFailBridgeStatusDto();
        return () -> mediator.end(bridgeStatusDto);
    }
}
