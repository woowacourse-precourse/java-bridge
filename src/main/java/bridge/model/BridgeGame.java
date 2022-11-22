package bridge.model;

import bridge.view.Sentence;

public class BridgeGame {

    private final String UpDownRetryQuit;

    private static final int UP_DOWN_MODE = 1;
    private static final int RETRY_MODE = 2;
    private static final int ONE = 1;

    private BridgeGame(String userInput, int mode) {
        validityInput(userInput, mode);
        this.UpDownRetryQuit = userInput;
    }

    public static BridgeGame from(final String userInput, int mode) {
        return new BridgeGame(userInput, mode);
    }

    private void validityInput(String userInput, int mode) {
        if (mode == UP_DOWN_MODE) {
            checkUpDownValidity(userInput);
        }
        if (mode == RETRY_MODE) {
            checkRetryValidity(userInput);
        }
    }

    private void checkUpDownValidity(String userInput) {
        if (!"UD".contains(userInput) || userInput.length() != ONE) {
            throw new IllegalArgumentException(Sentence.INPUT_NOT_U_OR_D.getValue());
        }
    }

    private void checkRetryValidity(String userInput) {
        if (!"RQ".contains(userInput) || userInput.length() != ONE) {
            throw new IllegalArgumentException(Sentence.INPUT_NOT_R_OR_Q.getValue());
        }
    }

    public int move(BridgeAnswer bridgeAnswer) {
        BridgePiece bridgePiece = new BridgePiece(UpDownRetryQuit);
        return bridgePiece.compareWithAnswer(bridgeAnswer);
    }

    public boolean retry(BridgeAnswer bridgeAnswer) {
        BridgePiece.replayCurrentPlaceReset(bridgeAnswer);
        return UpDownRetryQuit.equals(Sentence.RETRY_CHUNK.getValue());
    }
}
