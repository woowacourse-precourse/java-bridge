package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private int bridgeSize;
    //다리의 길이 입력
    public int readBridgeSize() {
        System.out.println("* 다리 건너기 게임을 시작합니다. *");
        System.out.println("다리의 길이를 입력해주세요.");
        bridgeSize = Integer.parseInt(Console.readLine());

        validateBridge(bridgeSize);

        return bridgeSize;
    }

    public void validateBridge(int bridge){
        // 다리 길이 예외처리
        if(bridge < 3 || bridge > 20){      // 3보다 작거나 20보다 큰 경우
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String upOrDown = Console.readLine();

        validateMoving(upOrDown);
        return upOrDown;
    }

    public void validateMoving(String upOrDown){
        if (!upOrDown.equals("U")&&!upOrDown.equals("D")){
            throw new IllegalArgumentException("[ERROR] U / D 로 입력해주세요");
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String RestartOrQuit = Console.readLine();
        if(RestartOrQuit.equals("Q")){
            return true;
        }
        else if(RestartOrQuit.equals("R")){
            return false;
        }
        throw new IllegalArgumentException("[ERROR] R이나 Q를 입력해 주세요");
    }
}
