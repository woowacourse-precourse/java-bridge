package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int size;
    private static InputView userInput;
    private static Bridge bridge;
    private static String moving;

    static void init () {
        userInput = new InputView();
        size = initBridgeSize();
        bridge = initBridge();
    }

    static int readValidBridgeSize() {
        try {
            return userInput.readBridgeSize();
        } catch (IllegalArgumentException e) {
            ExceptionHandler.printException(e);
            return ExceptionHandler.ERROR;
        }
    }

    static int initBridgeSize() {
        int size = readValidBridgeSize();
        while(size == ExceptionHandler.ERROR) {
            size = readValidBridgeSize();
        }
        return size;
    }

    static Bridge initBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(bridge, size);
    }

    static String readValidMoving() {
        try {
            return userInput.readMoving();
        } catch (IllegalArgumentException e) {
            ExceptionHandler.printException(e);
            return null;
        }
    }

    static String setNextMoving() {
        String moving = readValidMoving();
        while(moving == null) {
            moving = readValidMoving();
        }
        return moving;
    }

    public static void main(String[] args) {
        init();
        setNextMoving();
    }
}
