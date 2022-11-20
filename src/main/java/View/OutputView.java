package View;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> result) {
        for(List<String> resultBridge : result){
            String bridge = "[";
            for(String block : resultBridge){
                bridge += block;
                bridge += "|";
            }
            bridge = bridge.substring(0, bridge.length() -1);
            bridge += "]";
            System.out.println(bridge);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> result, boolean isSuccess, int gameCount) {
        final String gameResultMessage = "\n최종 게임 결과";
        final String isGameSuccessMessage = "\n게임 성공 여부: ";
        final String totalGameCount = "총 시도한 횟수: ";

        System.out.println(gameResultMessage);
        printMap(result);
        System.out.println(isGameSuccessMessage + printSuccessOrFailed(isSuccess));
        System.out.println(totalGameCount + gameCount);
    }

    public String printSuccessOrFailed(boolean isSuccess){
        final String success = "성공";
        final String failed = "실패";
        if(isSuccess){
            return success;
        }
        return failed;
    }

    public void printStart(){
        final String startMessage = "다리 건너기 게임을 시작합니다.\n";
        System.out.println(startMessage);
    }

    public void printReadBridgeSize(){
        final String readBridgeSizeMessage = "다리의 길이를 입력해주세요.";
        System.out.println(readBridgeSizeMessage);
    }

    public void printReadMoving(){
        final String readMovingMessage = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
        System.out.println(readMovingMessage);
    }

    public void printReadGameCommand(){
        final String readGameCommandMessage = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        System.out.println(readGameCommandMessage);
    }
}
