package bridge.system;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.controller.GameController;
import bridge.system.util.BridgeMaker;
import bridge.system.util.BridgeMessageMaker;
import bridge.system.util.BridgeNumberGenerator;
import bridge.system.util.BridgeRandomNumberGenerator;
import bridge.view.inputview.InputView;
import bridge.view.inputview.InputViewExceptionHandlingProxy;
import bridge.view.inputview.InputViewInterface;
import bridge.view.outputview.OutputView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DependencyContainer {
    public static GameController gameController() {
        return new GameController(inputView(), outputView(), bridgeMaker(), bridgeController());
    }

    public static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public static BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public static InputViewInterface inputView() {
        InvocationHandler invocationHandler = new InputViewExceptionHandlingProxy(new InputView(), outputView());
        return (InputViewInterface) Proxy.newProxyInstance(
                InputViewInterface.class.getClassLoader(),
                new Class[]{InputViewInterface.class},
                invocationHandler);
    }

    public static BridgeMessageMaker bridgeMessageMaker() {
        return new BridgeMessageMaker();
    }

    public static OutputView outputView() {
        return new OutputView(bridgeMessageMaker());
    }

    public static BridgeGame bridgeGame() {
        return new BridgeGame();
    }

    public static BridgeController bridgeController() {
        return new BridgeController(outputView(), inputView(), bridgeGame());
    }
}
