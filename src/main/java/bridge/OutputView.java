package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String START_MAP = "[ ";
    private final static String END_MAP = " ]";
    private final static String DELIM = " | ";
    private final static String START = "다리 건너기 게임을 시작합니다.";
    private final static String BRIDGE = "다리의 길이를 입력해주세요.";
    private final static String MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public void printStart(){
        System.out.println(START);
    }
    public void printBridgeSize(){
        System.out.println(BRIDGE);
    }

    public void printMove(){
        System.out.println(MOVE);
    }

    public void printGame(){
        System.out.println(GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Game game) {
        for (int i = 0; i < 2; i++){
            System.out.print(START_MAP);
            List<String> map = game.getPlaying().get(i);
            printUpDown(map);
            System.out.println(END_MAP);
        }
    }

    private void printUpDown(List<String> map){
        int size = map.size();
        String str = String.join(DELIM,map);
        System.out.print(str);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
