package bridge.exception;

import static bridge.constant.ErrorConstant.INPUT_DIRECTION_EXCEPTION;
import static bridge.constant.ErrorConstant.INPUT_NUMBER_EXCEPTION;
import static bridge.constant.ErrorConstant.NOT_FOUND_CODE;

import java.util.NoSuchElementException;

public enum ExceptionHandler {
    BRIDGE_SIZE {
        @Override
        public void error() {
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION.getMessage());
        }
    },

    NO_SUCH_ELEMENT {
        @Override
        public void error() {
            throw new NoSuchElementException(NOT_FOUND_CODE.getMessage());
        }
    },

    INPUT_DIRECTION {
        @Override
        public void error() {
            throw new IllegalArgumentException(INPUT_DIRECTION_EXCEPTION.getMessage());
        }
    };

    public abstract void error();

}