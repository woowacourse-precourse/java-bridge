package bridge.view;

import bridge.ValidInputChecker;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true){
            try{
                System.out.println("다리의 길이를 입력해주세요.");
                int bridgeSize = ValidInputChecker.validateIntAndParseInt(readLine());
                ValidInputChecker.validateBridgeSizeRange(bridgeSize);
                return bridgeSize;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true){
            try{
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                String UorD = readLine();
                ValidInputChecker.validateUorD(UorD);
                return UorD;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true){
            try{
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String RorQ = readLine();
                ValidInputChecker.validateRorQ(RorQ);
                return RorQ;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
