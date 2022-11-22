package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {



    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.valueOf(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        validateMovingCommand(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }

    private void validateBridgeSize(String input) {
        try {
            int value = Integer.valueOf(input);
            if (value < 3 || value > 20)
                throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 정수여야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 정수여야 합니다.");
        }
    }

    private void validateMovingCommand(String input) {
        if (!MovingCommand.hasCommandOf(input))
            throw new IllegalArgumentException("이동할 칸은 U 또는 D로 이동할 수 있습니다.");
    }

    private void validateGameCommand(String input) {
        if (!GameCommand.hasCommandOf(input))
            throw new IllegalArgumentException("재시도 여부는 R 또는 Q로 입력해주세요.");
    }

}
