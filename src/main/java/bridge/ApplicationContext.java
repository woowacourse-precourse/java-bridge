package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.view.DefaultView;

public class ApplicationContext {

    private static ApplicationContext context;

    private final BridgeGame game;
    private final BridgeController controller;
    private final DefaultView view;

    public static ApplicationContext getContext(){
        if(context == null){
            context = new ApplicationContext();
        }

        return context;
    }

    private ApplicationContext(){
        this.game = new BridgeGame();
        this.controller = new BridgeController(this.game);
        this.view = new DefaultView(this.controller);
    }

    public BridgeController getController(){
        return controller;
    }

    public BridgeGame getGame(){
        return game;
    }

    public DefaultView getView(){
        return view;
    }
}
