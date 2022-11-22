package bridge.mediator;

import bridge.ControllerFactory;
import bridge.controller.Controller;
import bridge.dto.BridgeStatusDto;
import bridge.view.ErrorView;
import bridge.view.ViewFaçade;

import java.util.HashMap;

public class ConcreteControllerMediator implements ControllerMediator, ViewMediator {
    private Controller controller = ControllerFactory.makeController(this);
    private ViewFaçade viewFaçade = new ViewFaçade(this);

    @Override
    public void start() {
        try {
            viewFaçade.start();
        } catch (IllegalArgumentException e) {
            new ErrorView().printErrorMessage(e.getMessage());
            start();
        }

    }

    @Override
    public void generateBridge(int size) {
        Runnable runnable = controller.generateBridge(size);
        runnable.run();
    }

    @Override
    public void moveBridge() {
        try {
            Runnable runnable = viewFaçade.moveBride();
            runnable.run();
        } catch (IllegalArgumentException e) {
            new ErrorView().printErrorMessage(e.getMessage());
            moveBridge();
        }
    }

    @Override
    public Runnable moveBridge(String direction, HashMap<String, String> map) {
        return controller.moveBridge(direction, map);
    }

    @Override
    public void replay() {
        try {
            viewFaçade.reply();
        } catch (IllegalArgumentException e) {
            new ErrorView().printErrorMessage(e.getMessage());
            replay();
        }
    }

    @Override
    public void replay(String restartCommand) {

        Runnable replay = controller.replay(restartCommand);
        replay.run();

    }

    @Override
    public void end(BridgeStatusDto bridgeStatusDto) {
        viewFaçade.end(bridgeStatusDto);
    }

}
