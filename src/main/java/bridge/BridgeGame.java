package bridge;

import bridge.Console.Input;
import bridge.Console.InputView;
import bridge.Console.Output;
import bridge.Console.OutputView;
import bridge.command.DownCommand;
import bridge.command.UpCommand;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Input input;
    private Output output;
    private Integer gameCount;
    public BridgeGame() {
        input = new InputView();
        output = new OutputView();
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
            move(history, bridge);
            if(++historyCount == bridge.size() && history.get(step).equals(stair)){
                output.printResult(true,++gameCount);
            }
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> history, List<String> bridge) {
        String movement = input.readMoving();
        history.add(movement);
        if ( bridge.get(history.size()-1).equals(movement) ) {
            printFinalResult(history, bridge);
        } else {
            makeResult(bridge,history);
            retry(history);
        }
    }

    private void printFinalResult(List<String> history, List<String> bridge) {
        if(history.equals(bridge)){
            System.out.println("최종 게임 결과");
        }
        makeResult(bridge, history);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge) {
        if(input.readGameCommand().equals("R")){
            gameCount++;
            play(bridge);
        }
    }
    public void makeResult(List<String> answer, List<String> history){
        List<String> ups = makeUpList(answer, history);
        List<String> downs = makeDownList(answer, history);
        Map<String, List<String>> result = new HashMap<>();
        result.put("up",ups);
        result.put("down",downs);
        output.printMap(result);
    }

    private List<String> makeDownList(List<String> answer, List<String> history) {
        DownCommand downCommand = new DownCommand(answer,history);
        return downCommand.executeAll(answer, history);
    }

    private List<String> makeUpList(List<String> answer, List<String> history){
        UpCommand upCommand = new UpCommand(answer, history);
        return upCommand.executeAll(answer,history);
    }
}
