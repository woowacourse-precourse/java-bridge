package bridge.controller;

import bridge.BridgeGame;
import bridge.dto.BridgeStatusDto;
import bridge.view.ViewFaçade;

import java.util.HashMap;
import java.util.function.Function;

public class NatureController implements Controller {

    private BridgeGame bridgeGame;
    private ViewFaçade viewFaçade;
    private Function<Integer, BridgeGame> function;

    public NatureController(Function<Integer, BridgeGame> function) {
        this.function = function;
    }

    @Override
    public Runnable generateBridge(ViewFaçade viewFaçade, int size) {
        bridgeGame = function.apply(size);
        this.viewFaçade = viewFaçade;
        return () -> viewFaçade.moveBride();
    }

    @Override
    public Runnable moveBridge(String direction, HashMap<String, String> map) {
        BridgeStatusDto bridgeStatusDto = bridgeGame.move(direction);
        map.put("bridge", bridgeStatusDto.getBridge());

        if (bridgeGame.isOverallSuccess()) {
            return () -> viewFaçade.end(bridgeStatusDto);
        }
        if (bridgeGame.isUnitSuccess()) return () -> viewFaçade.moveBride();
        return () -> viewFaçade.reply();
    }

    @Override
    public Runnable replay(String restartCommand) {
        if (bridgeGame.retry(restartCommand)) {
            bridgeGame.clearFootprints();
            return () -> viewFaçade.moveBride();
        }

        BridgeStatusDto bridgeStatusDto = bridgeGame.makeFailBridgeStatusDto();
        return () -> viewFaçade.end(bridgeStatusDto);
    }
}
