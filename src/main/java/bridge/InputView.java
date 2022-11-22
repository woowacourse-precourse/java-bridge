package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String PUT_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 내가 만든함수 : guideStart
     */
    public static void guideStart() {
        OutputView.printGuide(START_MESSAGE);
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    /**
     * size를 입력 받는다.
     */
    public int readBridgeSize() {
        OutputView.printGuide(START_MESSAGE);
        OutputView.printGuide("");
        OutputView.printGuide(PUT_SIZE);
        String command = Console.readLine();
        validateNumber(command);
        //validateRange(Integer.parseInt(command));
        return Integer.parseInt(command);
        //TODO: 예외 처리 부분 고려, Validator를 따로 만들어야 하나. 아니면 input 클래스 내에서 메소드를 추가해야하나.
        //TODO: 클래스 추가 관련해서 요구사항을 꼼꼼히 읽어볼 필요가 있다.
    }

    private void validateNumber(String command){
        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateRange(int size){
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        OutputView.printGuide(PUT_MOVING);
        //TODO: 예외 처리 고려 - 파라미터를 잘정의하면 readGameCommand랑 에러 처리 동일하게 나타낼 수 있을 듯
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        OutputView.printGuide(PUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        //TODO: 예외 처리 고려
        return gameCommand;
    }
}
