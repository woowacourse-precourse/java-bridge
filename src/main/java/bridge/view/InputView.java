package bridge.view;

import bridge.domain.bridge.BridgeMove;
import bridge.domain.game.BridgeGameCommand;
import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    
    private <T> T retryInput(Supplier<T> input) {
        try {
            return input.get();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return retryInput(input);
        }
    }
    
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return retryInput(this::inputBridgeSize);
    }
    
    private int inputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int numberInput = getNumber();
        validateBridgeSize(numberInput);
        return numberInput;
    }
    
    private void validateBridgeSize(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("다리 길이는 1이상이어야 합니다.");
        }
    }
    
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeMove readMoving() {
        return retryInput(this::inputMoving);
    }
    
    public BridgeMove inputMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        validateReadMovingInput(input);
        return BridgeMove.findByDirection(input).orElseThrow();
    }
    
    
    private void validateReadMovingInput(String input) {
        if (!BridgeMove.isContain(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다. U, D 중의 하나의 명령을 입력하세요.");
        }
    }
    
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public BridgeGameCommand readGameCommand() {
        return retryInput(this::inputGameCommand);
    }
    
    public BridgeGameCommand inputGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        validateReadGameCommandInput(input);
        return BridgeGameCommand.findByCommand(input).orElseThrow();
    }
    
    private void validateReadGameCommandInput(String input) {
        if (!BridgeGameCommand.isContain(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다. R, Q 중의 하나의 명령을 입력하세요.");
        }
    }
    
    public int getNumber() throws IllegalArgumentException {
        String line = Console.readLine();
        validateNumberString(line);
        return Integer.parseInt(line);
    }
    
    private void validateNumberString(String line) {
        for (char c : line.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
            }
        }
    }
}
