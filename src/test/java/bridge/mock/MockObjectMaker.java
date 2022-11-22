package bridge.mock;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeController;
import bridge.controller.GameController;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.system.util.BridgeMessageMaker;
import bridge.view.inputview.InputViewExceptionHandlingProxy;
import bridge.view.inputview.InputViewInterface;
import bridge.view.outputview.OutputView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class MockObjectMaker {
    public static GameController makeMockGameController(List<Integer> answers, List<String> mockInputs) {
        OutputView outputView = new OutputView(new BridgeMessageMaker());
        InputViewInterface inputView = makeMockProxyInputView(mockInputs);
        BridgeService bridgeService = new BridgeService(new BridgeGame(), makeMockBridgeMaker(answers));

        return new GameController(
                outputView,
                new BridgeController(outputView, inputView, bridgeService)
        );
    }

    public static BridgeController makeMockBridgeController(List<String> mockInputs) {
        return new BridgeController(
                new OutputView(new BridgeMessageMaker()),
                makeMockProxyInputView(mockInputs),
                new BridgeService(new BridgeGame(), new BridgeMaker(new BridgeRandomNumberGenerator()))
        );
    }

    private static BridgeMaker makeMockBridgeMaker(List<Integer> answers) {
        return new BridgeMaker(new MockNumberGenerator(answers));
    }

    public static InputViewInterface makeMockProxyInputView(List<String> mockInputs) {
        InputViewInterface target = new MockInputView(mockInputs);
        InvocationHandler invocationHandler
                = new InputViewExceptionHandlingProxy(target, new OutputView(new BridgeMessageMaker()));
        return (InputViewInterface) Proxy.newProxyInstance(
                InputViewInterface.class.getClassLoader(),
                new Class[]{InputViewInterface.class},
                invocationHandler);
    }
}