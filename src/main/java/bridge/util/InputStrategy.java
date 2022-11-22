package bridge.util;

import bridge.validation.InputValidationChain;

public interface InputStrategy <T> {

    T executeInput(InputValidationChain validator) throws IllegalArgumentException;
}
