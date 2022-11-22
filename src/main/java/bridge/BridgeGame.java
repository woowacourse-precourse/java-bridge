package bridge;

import bridge.console.Input;
import bridge.console.InputView;
import bridge.console.Output;
import bridge.console.OutputView;
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
     * @param history : 사용자가 입력한 값을 누적 기록한 리스트
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

    /**
     * 게임이 종료됐을 때, 종료 문구 출력 메서드
     */
    private void printFinalResult(List<String> history, List<String> bridge) {
        if(history.equals(bridge)){
            System.out.println("최종 게임 결과");
        }
        makeResult(bridge, history);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry(List<String> bridge) {
        if(input.readGameCommand().equals("R")){
            gameCount++;
            play(bridge);
        }
    }
    /**
     * 매번 입력을 받을 때마다 현재까지의 결과를 출력하는 함수
     */
    public void makeResult(List<String> answer, List<String> history){
        List<String> ups = makeUpList(answer, history);
        List<String> downs = makeDownList(answer, history);
        Map<String, List<String>> result = new HashMap<>();
        result.put("up",ups);
        result.put("down",downs);
        output.printMap(result);
    }

    /**
     * 현재까지의 결과중 아래 리스트를 만드는 함수
     */
    private List<String> makeDownList(List<String> answer, List<String> history) {
        DownCommand downCommand = new DownCommand(answer,history);
        return downCommand.executeAll(answer, history);
    }

    /**
     * 현재까지의 결과중 위 리스트를 만드는 함수
     */
    private List<String> makeUpList(List<String> answer, List<String> history){
        UpCommand upCommand = new UpCommand(answer, history);
        return upCommand.executeAll(answer,history);
    }
}
