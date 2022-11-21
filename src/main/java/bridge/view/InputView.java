package bridge.view;

import bridge.validator.InputValidator;
import bridge.validator.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요");
        String size = Console.readLine();

        while (handlingBridgeSizeException(size)) {
            System.out.println("다리의 길이를 입력해주세요");
            size = Console.readLine();
        }

        return Integer.parseInt(size);
    }

    private boolean handlingBridgeSizeException(String size) {
        try {
            InputValidator.isDigit(size);
            InputValidator.isInBoundary(size);
            return false;
        } catch (IllegalArgumentException retry) {
            System.out.println(retry.getMessage());
        }
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String nextStep = Console.readLine();
        while (handlingPlayerMovingException(nextStep)) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            nextStep = Console.readLine();
        }
        return nextStep;
    }

    private boolean handlingPlayerMovingException(String nextStep) {
        try {
            PlayerInputValidator.canMove(nextStep);
            return false;
        } catch (IllegalArgumentException retry) {
            System.out.println(retry.getMessage());
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String finish = null;
        while (true) {
            try {
                finish = Console.readLine();
                PlayerInputValidator.canFinish(finish);
                break;
            } catch (IllegalArgumentException retry) {
                System.out.println(retry.getMessage());
            }
        }
        return finish;
    }
}
