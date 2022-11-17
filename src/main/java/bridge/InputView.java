package bridge;
import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;


public class InputView {
    private static final String START_BRIDGE_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String CHOOSE_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위 : U, 아래 : D)";
    private static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    public int readBridgeSize() {
        String input;
        int inputNum = 0;
        System.out.println(START_BRIDGE_MESSAGE);

        while(true) {
            try {
                System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
                input = Console.readLine();
                inputNum = Integer.parseInt(input);
                break;
            } catch(IndexOutOfBoundsException e) {
                if(inputNum < 3 || inputNum > 20) {
                    System.out.println("[ERROR] : 숫자는 3이상 45이하여야 합니다.");
                    System.out.println("다시 입력해주세요.");
                }
                continue;
            } catch(InputMismatchException e) {
                System.out.println("[ERROR] : 숫자가 아닙니다.");
                System.out.println("다시 입력해주세요.");
                continue;
            }
        }
        return inputNum;
    }

    public String readMoving() {
        System.out.println(CHOOSE_MOVING_MESSAGE);
        String moving = "";
        while(true) {
            try {
                moving = Console.readLine();
                break;
            } catch(IllegalArgumentException e) {
                if(moving.indexOf(0) != 'U' || moving.indexOf(0) != 'D') {
                    System.out.println("[ERROR] : U나 D가 입력되어야 합니다.");
                    System.out.println("다시 입력해주세요.");
                    continue;
                }
            }
        }
        return moving;
    }

    public String readGameCommand() {
        String retry = "";
        while(true) {
            try {
                System.out.println(RETRY_MESSAGE);
                retry = Console.readLine();
                break;
            } catch(IllegalArgumentException e) {
                if(retry.indexOf(0) != 'R' || retry.indexOf(0) != 'Q') {
                    System.out.println("[ERROR] : U나 D가 입력되어야 합니다");
                    System.out.println("다시 입력해주세요");
                    continue;
                }
            }
        }
        return retry;
    }
}
