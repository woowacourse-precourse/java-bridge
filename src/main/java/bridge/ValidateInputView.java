package bridge;

public class ValidateInputView {
    final OutputView outputView;

    public ValidateInputView() {
        outputView = new OutputView();
    }

    /**
     * 다리의 길이가 적절한 값인지 판단한다.
     * 예외 발생시 IllegalArgumentException을 발생시킨다.
     *
     * @param userInput 사용자가 입력한 문자열
     * @return <p>[3,20] - 올바른 값
     * <p>-1 - 올바르지 않은 값
     */
    public int validateBridgeSize(String userInput) {
        try {
            int number = Integer.parseInt(userInput);
            if (3 <= number && number <= 20) return number;
            outputView.printErrorMessage("다리 크기는 3이상 20이하의 자연수여야 합니다.");
        } catch (NumberFormatException e) {
            outputView.printErrorMessage("다리 크기는 정수여야 합니다.");
        }
        throw new IllegalArgumentException();
    }


    /**
     * 이동할 칸의 입력이 적절한지 판단한다.
     * 예외 발생시 IllegalArgumentException을 발생시킨다.
     *
     * @param userInput 사용자가 입력한 문자열
     * @return <p>[U,D] - 올바른 값
     * <p>-1 - 올바르지 않은 값
     */
    public void validateMove(String userInput) {
        if (userInput.equals("U") || userInput.equals("D")) return;
        outputView.printErrorMessage("입력 값은 \"U\" 또는 \"D\"여야 합니다.");
        throw new IllegalArgumentException();
    }

    /**
     * 다시 시도 입력값이 적절한지 판단한다.
     * 예외 발생시 IllegalArgumentException을 발생시킨다.
     *
     * @param userInput 사용자가 입력한 문자열
     * @return [R, Q] - 올바른 값
     */
    public void validateGameCommand(String userInput) {
        if (userInput.equals("R") || userInput.equals("Q")) return;
        outputView.printErrorMessage("입력 값은 \"R\" 또는 \"Q\"여야 합니다.");
        throw new IllegalArgumentException();
    }
}
