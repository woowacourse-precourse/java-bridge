package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class Move{
    String direction;
    int moveIdx;
    int notMoveIdx;
    public Move(String direction, int moveIdx, int notMoveIdx){
        this.direction = direction;
        this.moveIdx = moveIdx;
        this.notMoveIdx = notMoveIdx;
    }
}
public class BridgeGame {
    static List<String> map;
    static List<List<String>> userMap = new ArrayList<>();
    static int tryCnt=1;
    static int size=0;
    static String result = "";
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public BridgeGame(){
        outputView.startPrint();
        this.size = inputView.readBridgeSize();
        this.map = bridgeMaker.makeBridge(size);
        userMap.add(new ArrayList<>());
        userMap.add(new ArrayList<>());
    }

    public void progress(){
        boolean retry = true;
        int i=0;
        result = "성공";
        while(retry && i<size){
            if(!play(i)) { //실패시 재시작 이면 초기화, 종료면 while 탈출
                retry = retry();
                i=-1;
            }
            i++;
        }
        outputView.printResult(tryCnt, result, userMap);
    }
    public boolean play(int idx){

        Move move = moveConstructor(inputView.readMoving());
        boolean success = move(idx, move);
        if(success){
            outputView.printMap(idx+1, this.userMap.get(0), this.userMap.get(1));
            return true;
        }
        outputView.printMap(idx+1, this.userMap.get(0), this.userMap.get(1));
        return false;
    }

    private Move moveConstructor(String readMoving) {
        if(readMoving.equals("U")){
            return new Move(readMoving, 0,1);
        }else if(readMoving.equals("D")){
            return new Move(readMoving, 1, 0);
        }
        throw new IllegalArgumentException("[ERROR] 정상적인 입력이 아닙니다.");
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int length, Move step) {
        if(map.get(length).equals(step.direction)){
            userMap.get(step.moveIdx).add("O");
            userMap.get(step.notMoveIdx).add(" ");
            return true;
        }
        else if(!map.get(length).equals(step.direction)){
            userMap.get(step.moveIdx).add("O");
            userMap.get(step.notMoveIdx).add(" ");
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 정상적인 입력이 아닙니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String command = inputView.readGameCommand();
        if(command.equals("R")){
            tryCnt+=1;
            userMap = new ArrayList<>();
            userMap.add(new ArrayList<>());
            userMap.add(new ArrayList<>());
            return true;
        }
        result = "실패";
        return false;


    }

}
