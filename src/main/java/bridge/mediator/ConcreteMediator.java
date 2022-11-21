package bridge;

import bridge.controller.Controller;
import bridge.controller.NatureController;
import bridge.dto.BridgeStatusDto;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.ViewFaçade;

import java.util.ArrayList;
import java.util.HashMap;

public class ConcreteMediator{
    private Controller controller=new NatureController((i->createBridgeGame(i)),this);
    private ViewFaçade viewFaçade=new ViewFaçade(this);

    public void start(){
        viewFaçade.start();
    }
    public void generateBridge(int i) {
        Runnable runnable = controller.generateBridge(i);
        runnable.run();
    }

    public void moveBridge(){
        Runnable runnable = viewFaçade.moveBride();
        runnable.run();
    }
    public Runnable moveBridge(String s, HashMap<String, String> map) {
        return controller.moveBridge(s, map);
    }

    public void replay() {
        viewFaçade.reply();
    }

    public void replay(String readGameCommand) {
        Runnable replay = controller.replay(readGameCommand);
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
