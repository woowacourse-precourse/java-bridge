package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String END_GAME_MESSAGE = "최종 게임 결과";
    private final String GAME_STATE_MESSAGE = "게임 성공 여부: ";
    private final String GAME_RETRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private void print(String message){
        System.out.println(message);
    }

    private String judgeUserLocationStatus(String currLocation, String direction, Boolean gameState){
        if(currLocation.equals(direction)){
            if(gameState)
                return " O ";
            return " X ";
        }
        return "   ";
    }

    private String makeMapString(List<String> userLocation, List<Boolean> gameState, String direction){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < userLocation.size(); ++i, sb.append('|'))
            sb.append(judgeUserLocationStatus(userLocation.get(i), direction, gameState.get(i)));
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    private String checkGameState(List<Boolean> gameState){
        if(gameState.get(gameState.size() - 1))
            return "성공";
        return "실패";
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userLocation, List<Boolean> gameState) {
        print(makeMapString(userLocation, gameState, "U"));
        print(makeMapString(userLocation, gameState, "D"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userLocation, List<Boolean> gameState, int retryConut) {
        print(END_GAME_MESSAGE);
        printMap(userLocation, gameState);
        print(GAME_STATE_MESSAGE + checkGameState(gameState));
        print(GAME_RETRY_COUNT_MESSAGE + retryConut);
    }

    public void printStartMessage(){
        print(START_MESSAGE);
    }

    public void printInputBridgeSizeMessage(){
        print(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputMovingMessage(){
        print(INPUT_MOVING_MESSAGE);
    }

    public void printInputGameCommandMessage(){
        print(INPUT_GAME_COMMAND_MESSAGE);
    }

    public void printExceptionMessage(String exceptionMessage){
        print(exceptionMessage);
    }
}
