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
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            bridgeSize = Integer.parseInt(readLine());
        }catch(NumberFormatException e){
            throw new NumberFormatException("[ERROR] 다리의 길이는 정수만 입력 가능합니다.");
        }
        return bridgeSize;
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        movingPosition = readLine();
        return movingPosition;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Boolean readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        command = readLine();
        if(command.equals(restart)) return true;
        if(command.equals(quit)) return false;
        return null;
    }
}
