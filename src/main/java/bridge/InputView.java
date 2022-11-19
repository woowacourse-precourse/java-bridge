package bridge;

import bridge.DTO.BridgeSizeDTO;
import bridge.DTO.MoveCommandDTO;
import camp.nextstep.edu.missionutils.Console;
import bridge.InputValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeDTO readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요");
        String inputBridgeLength = Console.readLine();
        return new BridgeSizeDTO(InputValidator.validateInputBridgeLength(inputBridgeLength));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveCommandDTO readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래 : D)");
        String inputMove = Console.readLine();
        return new MoveCommandDTO(InputValidator.validateInputMoveCommande(inputMove));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
