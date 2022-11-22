package bridge.util;

import bridge.validation.InputValidationChain;

public class InputContext {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public <T> T workWithInputStrategy(InputValidationChain validator, InputStrategy<T> inputStrategy) {
        T input = null;
        while (input == null) {
            try {
                input = inputStrategy.executeInput(validator);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
        return input;
    }
}
