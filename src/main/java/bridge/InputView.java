package bridge;

import static bridge.Application.generatedBridgeStr;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String errorMsg = "[ERROR]";
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private String changeToNum = "";
    private  boolean successOrFail = false;
    private String generatedStr = "";
    private char udToOneOrZero = ' ';
    private String position = "";
    private  int result;


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        try {
            result = Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            System.out.println(errorMsg + " 숫자만 입력 가능 \n 다리의 길이를 입력해주세요.");
            String input = Console.readLine();
            throw new NoSuchElementException(errorMsg + " 숫자만 입력 가능");
        }
        return result;
    }


    public void initialSetting(String generatedBridgeStr){

        generatedStr = generatedBridgeStr;
        successOrFail = true;
        changeToNum = "";
    }

    public void for_initialSetting() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        position = Console.readLine();
        udToOneOrZero = ' ';
        if (position.charAt(0) == 'U') {
            udToOneOrZero = '1';
        } else if (position.charAt(0) == 'D') {
            udToOneOrZero = '0';
        }
    }

        /**
         * 사용자가 이동할 칸을 입력받는다. U, D
         * <p>
         * 여기서 boolean 형태로 성공 실패 여부가 필요할까?
         */
    public String readMoving(String generatedBridgeStr, int bridgeSize) {       // 반환 값에 x가 포함되어 있으면 실패인 경우
        initialSetting(generatedBridgeStr);
        recursiveFor(bridgeSize);
        return changeToNum;
    }

    public void recursiveFor(int bridgeSize){
        for (int i = 0; i < bridgeSize && successOrFail; ++i) {  // 리스트 List<String> 같은 형태로 필요 // U 또는 D를 읽을 때마다 한번씩 출력해준다.
            for_initialSetting();
            boolean matchChar = (udToOneOrZero == generatedBridgeStr.charAt(i));
            boolean failureHandler = false;
            if(!matchChar)failureHandler = failureHandler();
            if(failureHandler) continue;
            boolean successHandler = successHandler(position);
            if(successHandler) continue;
            throw new IllegalArgumentException(errorMsg + " 위: U, 아래: D 만 입력 가능");
        }
    }

    public boolean successHandler(String position){
        if(position.equals("U")){
            changeToNum += "1";
            successOrFail = outputView.printMap(generatedBridgeStr, changeToNum);
            return true;
        } else if (position.equals("D")) {
            changeToNum += "0";
            successOrFail = outputView.printMap(generatedBridgeStr, changeToNum);
            return true;
        }
        return false;
    }


    public boolean failureHandler(){
        char posChar = position.charAt(0);
        if( posChar == 'U'){
            notMatchAndUp();
            return true;
        }else if(posChar == 'D'){
            notMatchAndDown();
            return true;
        }
        return false;
    }


    public  void notMatchAndDown(){

        changeToNum += "y";
        outputView.printMap(generatedBridgeStr, changeToNum);
        successOrFail = false;

    }

    public  void notMatchAndUp(){
        changeToNum += "x";
        outputView.printMap(generatedBridgeStr, changeToNum);
        successOrFail = false;

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. 게임 실패한 경우에만 호출한다.
     */
    public boolean readGameCommand() {  // 실패한 경우에, 재시작 여부
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String restartOrExit = Console.readLine();
        if (restartOrExit.length() == 1 && restartOrExit.charAt(0) == 'R') {
            bridgeGame.retry();      // BridgeGame 클래스의 retry()로 넘어간다.
            return true;
        } else if (restartOrExit.length() == 1 && restartOrExit.charAt(0) == 'Q') {
            return false;
        }
        throw new IllegalArgumentException(errorMsg + " R 또는 Q만 입력 가능");
    }
}
