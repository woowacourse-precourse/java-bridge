package bridge;

import camp.nextstep.edu.missionutils.Console;


// TODO 입력 예외 처리를 여기서 할까 밖에서 할까?
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
        int bridgeLength = Integer.parseInt(bridgeLengthInput); // TODO 숫자가 아닌 값이 들어왔을 때 예외 처리 할것

        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String nextStepInput;
        nextStepInput = Console.readLine();
        return nextStepInput;
    }

/*    public String readMoving() {
        String nextStepInput;
        while(true) {
            try {
                nextStepInput = Console.readLine();
                if (nextStepInput.length() > 1) {
                    throw new IllegalArgumentException("[ERROR] 한자리 숫자만 입력하세요"); //TODO 예외 종류 알아보기
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return nextStepInput;
    }*/

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("재시도 하시겠습니까?");
        String askRetry;
        askRetry = Console.readLine();

        return askRetry;
    }



}
