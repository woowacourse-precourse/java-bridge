package bridge;

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

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        int result;
        try {
            result = Integer.parseInt(bridgeSize);

        } catch (Exception e) {
            System.out.println(errorMsg + " 숫자만 입력 가능");
            throw new NoSuchElementException(errorMsg + " 숫자만 입력 가능");

        }

        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다. U, D
     * <p>
     * 여기서 boolean 형태로 성공 실패 여부가 필요할까?
     */
    public String readMoving(String generatedBridgeStr,
        int bridgeSize) {       // 반환 값에 x가 포함되어 있으면 실패인 경우

        boolean successOrFail = true;
        changeToNum = "";

        // 리스트 List<String> 같은 형태로 필요
        // U 또는 D를 읽을 때마다 한번씩 출력해준다.
        for (int i = 0; i < bridgeSize; ++i) {

            if (!successOrFail) {
                // system.out.println("x 포함 실패 처리하기");
                break;
            }

            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String position = Console.readLine();

            // 생성된 문자열과 지금 매치되지 않는 경우 0,1 같은 값이 아니라 스트링에 x을 넣어서
            // 근데 일치하는 경우는 어떤 문자를 추가할 필요없이  개수만 카운트해도 될거 같다.

            char tmp = ' ';

            // c가 up인 경우, down인 경우가 있는데
            if (position.charAt(0) == 'U') {
                tmp = '1';

            } else if (position.charAt(0) == 'D') {
                tmp = '0';
            }

            if (tmp != generatedBridgeStr.charAt(i) && position.charAt(0) == 'U') {

                changeToNum += "x";
                outputView.printMap(generatedBridgeStr, changeToNum);
                successOrFail = false;
                continue;

            } else if (tmp != generatedBridgeStr.charAt(i) && position.charAt(0) == 'D') {

                changeToNum += "y";
                outputView.printMap(generatedBridgeStr, changeToNum);
                successOrFail = false;
                continue;
            }

            if (position.charAt(0) == 'U' && position.length() == 1) {
                changeToNum += "1";
                successOrFail = outputView.printMap(generatedBridgeStr, changeToNum);
                continue;

            } else if (position.charAt(0) == 'D' && position.length() == 1) {
                changeToNum += "0";
                successOrFail = outputView.printMap(generatedBridgeStr, changeToNum);
                continue;

            }
            throw new IllegalArgumentException(errorMsg + " 위: U, 아래: D 만 입력 가능");
        }

        return changeToNum;
    }


    // U와 D를 1 또는 0으로 바꾼다.
    public String changeToNum(String str) { // UUDDU => 11001

        String result = "";
        for (char c : str.toCharArray()) {

            if (c == 'U') {
                result += "1";
                continue;
            }
            result += "0";
        }
        return result;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. 게임 실패한 경우에만 호출한다.
     */
    public boolean readGameCommand() {  // 재시작 여부

        // 실패한 경우
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String restartOrExit = Console.readLine();

        if (restartOrExit.length() == 1 && restartOrExit.charAt(0) == 'R') {

//            System.out.println("Restart 재시작 선택");               //
            bridgeGame.retry();      // BridgeGame 클래스의 retry()로 넘어간다.
            return true;

        } else if (restartOrExit.length() == 1 && restartOrExit.charAt(0) == 'Q') {

//            System.out.println("Exit 게임 종료");
            return false;


        } else {
            throw new IllegalArgumentException(errorMsg + " R 또는 Q만 입력 가능");
        }

    }
}
