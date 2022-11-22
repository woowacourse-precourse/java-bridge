package bridge;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START ="다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE ="다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_COMMAND = "이동할 칸을 선택해주세요. (";
    private static final String INPUT_REPLAY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (";
    private static final String INPUT_END = ")";
    private static final String LAST_BRIDGE_RESULT ="최종 게임 결과";
    private static final String IS_GAME_PASS= "게임 성공 여부";
    private static final String TOTAL_TRY ="총 시도한 횟수";
    private static final String BRIDGE_LEFT = "[ ";
    private static final String BRIDGE_MIDDLE =" | ";
    private static final String BRIDGE_RIGHT = " ]";
    private static final String IS =": ";
    private static final String AND = ", ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Map<String,List<String>> bridgeMap,int index){
        Iterator<String> keys = bridgeMap.keySet().iterator();
        while(keys.hasNext()){
            String command = keys.next();
            System.out.print(BRIDGE_LEFT);
            for(int j=0;j<index+1;j++){
                System.out.print(bridgeMap.get(command).get(j));
                if(j!=index){
                    System.out.print(BRIDGE_MIDDLE);
                }
            }
            System.out.println(BRIDGE_RIGHT);
        }
    }
    private static void printInsideMap(int index, String bridgePosition) {

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(GameResult gameResult) {
        System.out.println(IS_GAME_PASS+IS+gameResult.getIsPass());
    }
    public static void gameStart(){
        System.out.println(GAME_START);
    }
    public static void inputBridgeSize(){
        System.out.println(INPUT_BRIDGE_SIZE);
    }
    public static void inputUserMoveCommand(){
        System.out.println(INPUT_MOVE_COMMAND+UserCommand.MOVE_UP.getPosition()+IS+UserCommand.MOVE_UP.getCommand()+
                AND+ UserCommand.MOVE_DOWN.getPosition()+IS+UserCommand.MOVE_DOWN.getCommand()+INPUT_END);
    }
    public static void inputUserReplayCommand(){
        System.out.println(INPUT_REPLAY_GAME+UserCommand.REPLAY.getPosition()+IS+UserCommand.REPLAY.getCommand()+
                AND+ UserCommand.END.getPosition()+IS+UserCommand.END.getCommand()+INPUT_END);
    }
    public static void printLastBridgeResult(){
        System.out.println(LAST_BRIDGE_RESULT);
    }
    public static void printTotalTry(int totalTry){
        System.out.println(TOTAL_TRY+IS+totalTry);
    }
}
