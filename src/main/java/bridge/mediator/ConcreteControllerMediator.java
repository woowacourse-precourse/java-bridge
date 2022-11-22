package bridge.mediator;

import bridge.ControllerFactory;
import bridge.controller.Controller;
import bridge.dto.BridgeStatusDto;
import bridge.view.ErrorView;
import bridge.view.ViewFacade;

import java.util.HashMap;

public class ConcreteControllerMediator implements ControllerMediator, ViewMediator {
    private Controller controller = ControllerFactory.makeController(this);
    private ViewFacade viewFacade = new ViewFacade(this);

    @Override
    public void start() {
        try {
            viewFacade.start();
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
            Runnable runnable = viewFacade.moveBride();
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
            viewFacade.reply();
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
        viewFacade.end(bridgeStatusDto);
    }

}
