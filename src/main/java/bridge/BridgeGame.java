package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving, String table) {
        String[] tableStatus = table.split("\n");
        if(moving.equals("U")){
            return upMove(tableStatus[0], tableStatus[1]);
        }else{
            return downMove(tableStatus[0], tableStatus[1]);
        }
    }

    /**
     * 위로 이동시에 호출되는 함수
     */
    private String upMove(String up, String down){
        if(up.equals(" ")) {
            up = up.replace(" ", "[ O ]");
            down = down.replace(" ", "[   ]");
        }
        else{
            up = up.replace("]", "| O ]");
            down = down.replace("]", "|   ]");
        }
        return up+"\n"+down+"\n";
    }

    /**
     * 아래로 이동시에 호출되는 함수
     */
    private String downMove(String up, String down){
        if(down.equals(" ")) {
            up = up.replace(" ", "[   ]");
            down = down.replace(" ", "[ O ]");
        }
        else{
            up = up.replace("]", "|   ]");
            down = down.replace("]", "| O ]");
        }
        return up+"\n"+down+"\n";
    }

    /**
     * 이동하지 못할때 호출되는 함수
     */
    public String dontMove(String moving, String table) {
        String[] tableStatus = table.split("\n");
        if(moving.equals("U")){
            return dontUpMove(tableStatus[0], tableStatus[1]);
        }else{
            return dontDownMove(tableStatus[0], tableStatus[1]);
        }
    }

    /**
     * 위로 이동하지 못할때 호출되는 함수
     */
    private String dontUpMove(String up, String down){
        if(up.equals(" ")) {
            up = up.replace(" ", "[ X ]");
            down = down.replace(" ", "[   ]");
        }
        else{
            up = up.replace("]", "| X ]");
            down = down.replace("]", "|   ]");
        }
        return up+"\n"+down+"\n";
    }

    /**
     * 위로 이동하지 못할때 호출되는 함수
     */
    private String dontDownMove(String up, String down){
        if(down.equals(" ")) {
            up = up.replace(" ", "[   ]");
            down = down.replace(" ", "[ X ]");
        }
        else{
            up = up.replace("]", "|   ]");
            down = down.replace("]", "| X ]");
        }
        return up+"\n"+down+"\n";
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String answer) {
        return answer.equals("R");
    }

    /**
     * 게임 시작시 호출되는 함수
     */
    public void startGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 기존에 만들어놓은 다리와 입력된 문자가 같은지 확인하는 함수
     */
    public boolean matchBridge(String currentBridgePosition, String moving){
        return currentBridgePosition.equals(moving);
    }

    /**
     * 게임 중간결과를 출력하기 위해 사용되는 함수 -> 이후 최종 결과 출력 함수도 호출
     * @param answerBridge -> 만들어진 다리
     * @param totalAttempt -> 시도한 횟수
     * @param table -> 중간 다리 결과
     * @return -> true or False
     */
    public boolean cycleBridge(List<String> answerBridge, int totalAttempt, String table){
        for (String value : answerBridge) {
            String moving = new OutputView().upAndDownCheckMessage();
            if (!matchBridge(value, moving)) {
                return failGame(moving, totalAttempt, table);
            }
            table = move(moving, table);
            new OutputView().printMap(table);
        }
        new OutputView().printResult(totalAttempt, table,"성공");
        return false;
    }

    /***
     * 게임 실패시 호출되는 함수
     * @param moving -> 움직이는 방향 ( U or D )
     * @param totalAttempt -> 시도 횟수
     * @param table -> 최종 다리 결과
     * @return true or false
     */
    private boolean failGame(String moving, int totalAttempt, String table){
        table = dontMove(moving, table);
        new OutputView().printMap(table);
        String retryInput = new OutputView().retryCheckMessage();
        boolean check = retry(retryInput);
        if(!check)
            new OutputView().printResult(totalAttempt, table,"실패");
        return check;
    }
}
