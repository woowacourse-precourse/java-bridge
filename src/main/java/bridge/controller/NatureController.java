package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.dto.BridgeStatusDto;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.ViewFaçade;

import java.util.ArrayList;
import java.util.HashMap;

public class NatureController implements Controller {

    private BridgeGame bridgeGame;

    @Override
    public Runnable generateBridge(ViewFaçade viewFaçade, int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size), new ArrayList<>());
        return () -> viewFaçade.moveBride();
    }

    @Override
    public Runnable moveBridge(ViewFaçade viewFaçade, String direction, HashMap<String, String> map) {
        BridgeStatusDto bridgeStatusDto = bridgeGame.move(direction);
        map.put("bridge", bridgeStatusDto.getBridge());

        if (bridgeGame.isOverallSuccess()) {
            return () -> viewFaçade.end(bridgeStatusDto);
        }
        if (bridgeGame.isUnitSuccess()) return () -> viewFaçade.moveBride();
        return () -> viewFaçade.reply();
    }

    @Override
    public Runnable replay(ViewFaçade viewFaçade, String restartCommand) {
        if (bridgeGame.retry(restartCommand)) {
            bridgeGame.clearFootprints();
            return () -> viewFaçade.moveBride();
        }
        BridgeStatusDto bridgeStatusDto = bridgeGame.makeBridgeStatusDto();
        return () -> viewFaçade.end(bridgeStatusDto);
    }
}
