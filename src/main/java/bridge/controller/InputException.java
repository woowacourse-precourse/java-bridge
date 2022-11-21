package bridge.controller;

import bridge.BridgeException;
import bridge.domain.GameKeySet;

public class InputException {
    void raiseBridgeSizeValidityException() throws IllegalArgumentException {
        throw new IllegalArgumentException(BridgeException.TOKEN.getMessage() + " 다리 길이는 3이상 20이하의 값만 입력 가능합니다.");
    }

    void raiseUserMoveValidityException() throws IllegalArgumentException {
        throw new IllegalArgumentException(BridgeException.TOKEN.getMessage() + " " + GameKeySet.UP.getKeySet() + "  혹은 " + GameKeySet.DOWN.getKeySet() + " 문자만 입력 가능합니다.");
    }

    void raiseRetryOrQuitValidityException() throws IllegalArgumentException {
        throw new IllegalArgumentException(BridgeException.TOKEN.getMessage() + " " + GameKeySet.RESTART.getKeySet() + "혹은 " + GameKeySet.QUIT.getKeySet() + " 문자만 입력 가능합니다.");
    }

    void raiseNumberFormatValidityException() throws IllegalArgumentException {
        throw new IllegalArgumentException(BridgeException.TOKEN.getMessage() + " 다리 길이는 숫자만 입력 가능합니다.");
    }
}
