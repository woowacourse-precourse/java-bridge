package view;

import static constant.Message.*;

import camp.nextstep.edu.missionutils.Console;
import utils.Validation;

/**
 * 사용자로부터 입력을 받는 역할을 한다. InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 */
public class InputView {

    private final Validation validation;

    public InputView(Validation validation) {
        this.validation = validation;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        do {
            System.out.println(INPUT_BRIDGE_LENGTH);
            try {
                return validation.validBridgeSize(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        do {
            System.out.printf((SELECT_UP_AND_DOWN) + "%n", UP, DOWN);
            try {
                return validation.validMovingNext(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        do {
            System.out.printf((SELECT_REGAME_OR_QUIT) + "%n", REGAME, QUIT);
            try {
                return validation.validGameCommand(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
