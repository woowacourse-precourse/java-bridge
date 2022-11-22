package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Exceptions.inputBridgeSizeException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private String inputBridgeSize;
    private static int bridgesize;
    private InputStringShape inputStringShape;
    public InputView(){
        inputStringShape = new StringToInt();
    }
    public void readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        inputBridgeSize = Console.readLine();
        while(inputBridgeSizeException(inputBridgeSize)){
            readBridgeSize();
        }
        bridgesize = inputStringShape.toInt(inputBridgeSize);
    }


    public int getSize(){
        return bridgesize;
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해 주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        if(Exceptions.inputDirectionException(moving)){
            return readMoving();
        }
        System.out.println(moving);
        return moving;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String answer = Console.readLine();
        if(Exceptions.inputReplayException(answer)){
            return readGameCommand();
        }
        System.out.println(answer);
        return answer;
    }
}
