package bridge.model;

import bridge.view.Sentence;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String UpDownRetryQuit;
    private static final int UP_DOWN_MODE = 1;
    private static final int RETRY_MODE = 2;

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
        if (!"UD".contains(userInput) || userInput.length() != 1) {
            throw new IllegalArgumentException(Sentence.INPUT_NOT_U_OR_D.getValue());
        }
    }

    private void checkRetryValidity(String userInput) {
        if (!"RQ".contains(userInput) || userInput.length() != 1) {
            throw new IllegalArgumentException(Sentence.INPUT_NOT_R_OR_Q.getValue());
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(BridgeAnswer bridgeAnswer) {
        BridgePiece bridgePiece = new BridgePiece(UpDownRetryQuit);
        return bridgePiece.compareWithAnswer(bridgeAnswer);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(BridgeAnswer bridgeAnswer) {
        BridgePiece.replayCurrentPlaceReset(bridgeAnswer);
        return UpDownRetryQuit.equals(Sentence.RETRY_CHUNK.getValue());
    }
}
