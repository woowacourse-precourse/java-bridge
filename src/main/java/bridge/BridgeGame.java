package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private InputView inputView;
    private OutputView outputView;
    private Integer gameCount;
    public BridgeGame() {
        inputView = new InputView();
        outputView = new OutputView();
        gameCount = 0;
    }
    /**
     *  사용자가 게임을 시작할 때 사용하는 메서드
     * @param bridge : U, D 로 이루어진 리스트
     * */
    public void play(List<String> bridge) {
        List<String> history = new ArrayList<>();
        Integer historyCount = 0;
        history.clear();
        Integer step = 0;
        for (String stair : bridge) {
            move(history, step, bridge);
            historyCount++;
            if(historyCount == bridge.size()){
                retry(bridge,true);
            }
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> history, Integer step, List<String> bridge) {
        String movement = inputView.readMoving();
        history.add(movement);
        if ( bridge.get(step++).equals(movement) ) {
            makeResult(bridge,history);
        } else {
            makeResult(bridge,history);
            retry(history,false);
            return;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge,boolean isSuccess) {
        if(inputView.readGameCommand().equals("R")){
            gameCount++;
            play(bridge);
            return;
        }
        else{
            outputView.printResult(isSuccess,gameCount);
        }
    }
    public void makeResult(List<String> answer, List<String> history){
        List<String> ups = new ArrayList<>();
        List<String> downs = new ArrayList<>();
        for (int i = 0; i < history.size(); i++) {
            if(answer.get(i).equals("U") && history.get(i).equals("U")){
                ups.add("O");
            }
            else if(answer.get(i).equals("U") && history.get(i).equals("D")){
                ups.add(" ");
            }
            else if(answer.get(i).equals("D") && history.get(i).equals("U")){
                ups.add("X");
            }
            else if(answer.get(i).equals("D") && history.get(i).equals("D")){
                ups.add(" ");
            }
        }
        for (int i = 0; i < history.size(); i++) {
            if(answer.get(i).equals("U") && history.get(i).equals("U")){
                downs.add(" ");
            }
            else if(answer.get(i).equals("U") && history.get(i).equals("D")){
                downs.add("X");
            }
            else if(answer.get(i).equals("D") && history.get(i).equals("U")){
                downs.add(" ");
            }
            else if(answer.get(i).equals("D") && history.get(i).equals("D")){
                downs.add("O");
            }
        }
        System.out.println("ups = " + ups);
        System.out.println("downs = " + downs);
    }
}
