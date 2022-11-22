package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println("다리의 길이를 입력해주세요.");

        String bridgeLengthInput = Console.readLine();
        if (!bridgeLengthInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        int bridgeLength = Integer.parseInt(bridgeLengthInput);

        if (bridgeLength < 3 && bridgeLength > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하로만 설정 가능합니다.");
        }

        return bridgeLength;
    }

    public int readBridgeSizeWithValidityCheck() {
        int bridgeLength;
        while (true) {
            try {
                bridgeLength = readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeLength;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String nextStepInput;
        nextStepInput = Console.readLine();
        if (!nextStepInput.equals("U") && !nextStepInput.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 한글자의 U 또는 D를 입력해주세요.");
        }
        return nextStepInput;
    }

    public String readMovingWithValidityCheck() {
        String nextStepInput;
        while (true) {
            try {
                nextStepInput=readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return nextStepInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("재시도 하시겠습니까? 재시도는 R, 그만 두기는 Q를 눌러주세요");
        String askRetry;
        askRetry = Console.readLine();
        if (!askRetry.equals("R") && !askRetry.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 한글자의 R 또는 Q를 입력해주세요");
        }

        return askRetry;
    }
    public String readGameCommandWithValidityCheck() {
        String askRetry;
        while (true) {
            try {
                askRetry=readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return askRetry;
    }

}
