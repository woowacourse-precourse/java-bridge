package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String upPosition = "U";
    private final String downPosition = "D";
    private final String restart = "R";
    private final String quit = "Q";
    private int bridgeSize;
    private String movingPosition;
    private String command;

    public int readBridgeSize() {
        try {
            bridgeSize = Integer.parseInt(readLine());
        }catch(NumberFormatException e){
            throw new NumberFormatException("[ERROR] 다리의 길이는 정수만 입력 가능합니다.");
        }
        return bridgeSize;
    }

    public String readMoving() {
        movingPosition = readLine();
        return movingPosition;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        command = readLine();
        if(command.equals(restart)) return "restart";
        if(command.equals(quit)) return "quit";
        return null;
    }
}
