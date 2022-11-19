package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static List<String> map;
    static List<String> userMapUP = new ArrayList<>(); //OX
    static List<String> userMapDown = new ArrayList<>(); //OX
    static int tryCnt=0;
    static int size=0;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public BridgeGame(){
        this.size = inputView.readBridgeSize();
        this.map = bridgeMaker.makeBridge(size);
    }

    public void progress(){
        boolean retry = false;
        int i=0;
        while(true){
            boolean success = play(i);
            if(!success) {
                retry = retry();
                i=-1;
            }
            if(!retry) break;
            i++;
        }
    }
    public boolean play(int idx){

        String direction = inputView.readMoving();
        boolean success = move(idx, direction);
        if(success){
            outputView.printMap(idx, this.userMapUP, this.userMapDown);
            return true;
        }
        outputView.printMap(idx, this.userMapUP, this.userMapDown);
        return false;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int length, String direction) {
        if(direction.equals("U") && map.get(length).equals("U")){
            userMapUP.add("O");
            userMapDown.add(" ");
            return true;
        }
        else if(direction.equals("D") && map.get(length).equals("D")){
            userMapUP.add(" ");
            userMapDown.add("O");
            return true;
        }
        else if(direction.equals("U") && !map.get(length).equals("D")){
            userMapUP.add("X");
            userMapDown.add(" ");
        }
        else if(direction.equals("D") && !map.get(length).equals("D")){
            userMapUP.add(" ");
            userMapDown.add("X");
        }
        return false;
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
            userMapUP = new ArrayList<>();
            userMapDown = new ArrayList<>();
            return true;
        }
        return false;


    }

}
