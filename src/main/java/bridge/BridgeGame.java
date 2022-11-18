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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<List<String>> valueList) {
        String[] bridges = new String[]{"U", "D"};
        for(String bridge : bridges)
            System.out.println(outputView.printMap(bridge, valueList));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private String retry(List<String> value) {
        if(value.get(1).equals("X"))
            return inputView.readGameCommand();
        return "R";
    }

    /**
     * 사용자가 게임을 시작할 때 사용하는 메서드
     */
    public void play() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println(bridge); //test

        List<List<String>> valueList = new ArrayList<>();
        for(int i = 0; i < bridge.size(); i++)
        {
            String moving = inputView.readMoving();
            List<String> value = compare(bridge.get(i), moving);
            if(value != null)
                valueList.add(value);
            move(valueList);
            System.out.println();
            if(retry(value).equals("Q"))
                outputView.printResult(valueList);
        }
        outputView.printResult(valueList);

    }

    /**
     * 사용자가 게임을 시작할 때 사용하는 메서드
     */
    private List<String> compare(String answer, String moving) {
        if(answer.equals(moving))
            return Arrays.asList(new String[]{moving, "O"});

        if(!answer.equals(moving))
            return Arrays.asList(new String[]{moving, "X"});

        return null;
    }

}
