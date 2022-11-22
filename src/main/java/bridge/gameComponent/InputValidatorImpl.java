package bridge.gameComponent;

import bridge.exception.ExceptionMessage;
import bridge.exception.ExceptionPrinter;
import bridge.util.BridgeSizeRule;
import bridge.util.Converter;
import bridge.util.UserInput;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputValidatorImpl implements InputValidator {
    public void validateBridgeSize(String size) {
        Integer sizeAsInt = Converter.stringToInt(size);
        if(sizeAsInt < BridgeSizeRule.BRIDGE_MIN_SIZE.getSize() || sizeAsInt > BridgeSizeRule.BRIDGE_MAX_SIZE.getSize()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public  void validateMove(String move) {
        if(!(move.equals(UserInput.UP.getInputValue()) || move.equals(UserInput.DOWN.getInputValue()))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }

    public void validateRetry(String retryQuit) {
        if(!(retryQuit.equals(UserInput.RETRY.getInputValue()) || retryQuit.equals(UserInput.QUIT.getInputValue()))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }

    public String inputTemplate(String validateMethod) {
        Method method = getValidatorMethodWithName(validateMethod);
        while(true) {
            try {
                String input = Console.readLine();
                method.invoke(this, input);
                return input;
            } catch (InvocationTargetException | IllegalAccessException e) {
                ExceptionPrinter.printExceptionWithException(e);
            }
        }
    }
    private Method getValidatorMethodWithName(String name) {
        try {
            Class[] methodParamClass = new Class[] {String.class};
            Class clazz = this.getClass();
            return clazz.getMethod(name, methodParamClass);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALIDATE_METHOD_NAME.getMessage());
        }
    }
}
