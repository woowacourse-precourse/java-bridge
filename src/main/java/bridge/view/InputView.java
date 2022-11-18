package bridge.view;

import static bridge.domain.validation.InputValidator.validateThisIsNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.BridgeSize;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * TODO 메서드 시그니처(인자, 이름)와 반환 타입 변경 가능
 * TODO 메서드 추가 가능
 */
public class InputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public BridgeSize bridgeSize() {
        try {
            return numberForBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return bridgeSize();
        }
    }

    private BridgeSize numberForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String inputValue = readLine();
        validateThisIsNumber(inputValue);

        return new BridgeSize(Integer.parseInt(inputValue));
    }

    public MoveCommands moveCommands() {
        try {
            return oneStringForMoveCommands();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return moveCommands();
        }
    }

    private MoveCommands oneStringForMoveCommands() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return MoveCommands.of(readLine());
    }

    public GameCommands gameCommand() {
        try {
            return oneStringForGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return gameCommand();
        }
    }

    private GameCommands oneStringForGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return GameCommands.of(readLine());
    }
}
