package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private List<List<String>> valueList = new ArrayList<>();
    private int attemption = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String > move(List<String> answerList, int index) {
        String moving = inputView.readMoving();
        List<String> value = compare(answerList.get(index), moving);
        if(value != null)
            valueList.add(value);

        outputView.printMap(valueList);

        return value;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private String retry(List<String> value) {
        if(value.get(1).equals("X"))
            return inputView.readGameCommand();
        return "C";
    }

    /**
     * 사용자가 게임을 시작할 때 사용하는 메서드
     */
    public void play() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        //다리 생성
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println(bridge); //test

        playMain(bridge);

    }

    private void playMain(List<String> bridge) {
        int repeat = 0;
        while (repeat < bridge.size())
        {
            attemption++;

            List<String> value = move(bridge, repeat);

            String gameCommand = retry(value);

            if(gameCommand.equals("Q")) {
                outputView.printResult(valueList);
                return;
            }
            if(gameCommand.equals("R")) {
                valueList.remove(repeat);
                continue;
            }
            repeat++;
        }

        outputView.printResult(valueList);
    }

    /**
     * 생성한 다리의 값과 사용자의 입력 값을 비교한다.
     */
    private List<String> compare(String answer, String moving) {
        if(answer.equals(moving))
            return Arrays.asList(new String[]{moving, "O"});

        if(!answer.equals(moving))
            return Arrays.asList(new String[]{moving, "X"});

        return null;
    }

    /**
     * 게임을 시도한 횟수를 가져온다.
     */
    public int getAttemption() {
        return attemption;
    }
}
