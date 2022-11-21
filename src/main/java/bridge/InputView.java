package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ValidationInput validationInput = new ValidationInput();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String sizeOfBridge = readLine();
        validationInput.validateInputBridge(sizeOfBridge);
        int size = Integer.parseInt(sizeOfBridge);
        return size;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move = readLine();
        validationInput.validateUpperAlphaBet(move);
        validationInput.validateInputSizeIsOne(move);
        validationInput.validateReadMoving(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String replayOrQuit = readLine();
        validationInput.validateUpperAlphaBet(replayOrQuit);
        validationInput.validateInputSizeIsOne(replayOrQuit);
        validationInput.validateReadGameCommand(replayOrQuit);
        return replayOrQuit;
    }
}
