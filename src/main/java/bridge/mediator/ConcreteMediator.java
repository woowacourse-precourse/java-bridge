package bridge.mediator;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.controller.Controller;
import bridge.controller.NatureController;
import bridge.dto.BridgeStatusDto;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.mediator.Mediator;
import bridge.view.ViewFaçade;

import java.util.ArrayList;
import java.util.HashMap;

public class ConcreteMediator implements Mediator {
    private Controller controller=new NatureController((i->createBridgeGame(i)),this);
    private ViewFaçade viewFaçade=new ViewFaçade(this);

    public void start(){
        viewFaçade.start();
    }
    public void generateBridge(int size) {
        Runnable runnable = controller.generateBridge(size);
        runnable.run();
    }

    public void moveBridge(){
        Runnable runnable = viewFaçade.moveBride();
        runnable.run();
    }
    public Runnable moveBridge(String direction, HashMap<String, String> map) {
        return controller.moveBridge(direction, map);
    }

    public void replay() {
        viewFaçade.reply();
    }

    public void replay(String restartCommand) {
        Runnable replay = controller.replay(restartCommand);
        replay.run();
    }

    public void end(BridgeStatusDto bridgeStatusDto) {
        viewFaçade.end(bridgeStatusDto);
    }

    private static BridgeGame createBridgeGame(Integer integer) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new BridgeGame(bridgeMaker.makeBridge(integer), new ArrayList<>());
    }
}
