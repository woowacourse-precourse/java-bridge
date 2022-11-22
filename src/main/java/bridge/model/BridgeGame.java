package bridge.model;

import bridge.view.Sentence;

public class BridgeGame {

    private static final int UP_DOWN_MODE = 1;
    private static final int RETRY_MODE = 2;
    private static final int ONE = 1;

    private final String UpDownRetryQuit;

    private BridgeGame(final String userInput, final int mode) {
        validityInput(userInput, mode);
        this.UpDownRetryQuit = userInput;
    }

    public static BridgeGame from(final String userInput, final int mode) {
        return new BridgeGame(userInput, mode);
    }

    private void validityInput(final String userInput, final int mode) {
        if (mode == UP_DOWN_MODE) {
            checkUpDownValidity(userInput);
        }
        if (mode == RETRY_MODE) {
            checkRetryValidity(userInput);
        }
    }

    private void checkUpDownValidity(final String userInput) {
        if (!Sentence.UP_AND_DOWN.getValue().contains(userInput) || userInput.length() != ONE) {
            throw new IllegalArgumentException(Sentence.INPUT_NOT_U_OR_D.getValue());
        }
    }

    private void checkRetryValidity(final String userInput) {
        if (!Sentence.RETRY_AND_QUIT.getValue().contains(userInput) || userInput.length() != ONE) {
            throw new IllegalArgumentException(Sentence.INPUT_NOT_R_OR_Q.getValue());
        }
    }

    public int move(final BridgeAnswer bridgeAnswer) {
        BridgePiece bridgePiece = new BridgePiece(UpDownRetryQuit);
        return bridgePiece.compareWithAnswer(bridgeAnswer);
    }

    public boolean retry(final BridgeAnswer bridgeAnswer) {
        BridgePiece.replayCurrentPlaceReset(bridgeAnswer);
        return UpDownRetryQuit.equals(Sentence.RETRY_CHUNK.getValue());
    }
}
