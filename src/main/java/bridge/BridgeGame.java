package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final BridgeLengthValidator bridgeLengthValidator;

    public BridgeGame() {
        this.inputView = new InputView();
        this.bridgeLengthValidator = new BridgeLengthValidator();
    }

    public void runGame() {
        notifyGameStart();
        System.out.println();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void notifyGameStart() {
        this.inputView.printGameStart();
    }

    public int getBridgeLength() throws IllegalArgumentException {
        this.inputView.printPromptForBridgeLength();
        String input = inputView.readBridgeLength();

        BridgeLengthValidationCode validationResult = this.bridgeLengthValidator.validateBridgeLength(input);

        if (validationResult != BridgeLengthValidationCode.VALID) {
            throw new IllegalArgumentException(validationResult.getErrorMessage());
        }

        return Integer.parseInt(input);
    }
}
