package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String readBridgeSizeMessage = "다리의 길이를 입력해주세요.";
    private final String readMovingMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String readGameCommandMessage = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSizeMessage);
        String bridgeSize = readLine();
        try{
            readBridgeSizeOfNoNumberException(bridgeSize);
            readScopeOfBridgeSizeOfNumberException(bridgeSize);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bridgeSize = String.valueOf(readBridgeSize());
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(readMovingMessage);
        String userAnswer = readLine();
        return userAnswer;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(readGameCommandMessage);
        String userCommand = readLine();
        return userCommand;
    }

    public void readBridgeSizeOfNoNumberException(String bridgeSize){
        String brideSizeRegularExpression = "^\\d{1,2}$";
        if(!bridgeSize.matches(brideSizeRegularExpression)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력을 받습니다.");
        }
    }

    public void readScopeOfBridgeSizeOfNumberException(String bridgeSize){
        int size = Integer.parseInt(bridgeSize);
        if(size<3 || size>20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void readMovingCommandCheck(String userCommand){
        String moveCommandRegularExpression = "^[U|u|D|d]{1}$";
        if(!userCommand.matches(moveCommandRegularExpression)){
            throw new IllegalArgumentException("[ERROR] U와 D 중에 하나를 입력하세요.");
        }
    }

    public void readGameCommandCheck(String userAnswer){
        String readGameCommandCheck = "^[Q|q|R|r]$";
    }
}
