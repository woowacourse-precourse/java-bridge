package bridge.utils;// @ author ninaaano

import bridge.exception.Exception;
import bridge.view.InputView;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class Validator {
    private static final Logger logger = Logger.getLogger(InputView.class.getName());

    public static int validateBridgeLength(String bridgeLength) {
        try {
            Exception.checkString(bridgeLength);
            return Integer.parseInt(bridgeLength);
        } catch (IllegalArgumentException e) {
            //e.getStackTrace();
            logger.warning(getErrorSupplier(e));
            return InputView.readBridgeSize();
        }
    }
        //return


    public static String validateMove(String userInput) {
        return Exception.checkMove(userInput);
    }

    public static String validateRestartOrQuit(String userInput) {
        return Exception.checkRestartOrQuit(userInput);
    }

    private static Supplier<String> getErrorSupplier(IllegalArgumentException e) {
        return () -> {
            String message = e.getMessage();
            System.out.println(message);
            return message;
        };
    }
}
