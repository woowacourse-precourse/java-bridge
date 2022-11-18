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

    private List<List<String>> valueList = new ArrayList<>(); // 횟수마다 다리 건넌 결과 저장(어떤 다리인지, 일치하는지)
    private int attemption = 0;

    /**
     * 사용자가 게임을 시작할 때 사용하는 메서드
     */
    public void play() {
        //게임 시작
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        //다리 생성
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> answerBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println(answerBridge);
        //다리 건너기
        crossBridge(answerBridge);
    }

    /**
     * 다리 건너기
     * @param answerBridge 생성된 다리
     */
    int repeat = 0;
    boolean isRetry = false;
    private void crossBridge(List<String> answerBridge) {
        while (repeat < answerBridge.size()) {
            attemption++;
            List<String> value = move(answerBridge, repeat); // 다리 이동
            printMove(); // 이동한 결과 출력

            if(value.get(1).equals("X"))
                isRetry = retry(repeat);
            if(!isRetry)
                return;

            repeat++;
        }

        outputView.printResult(valueList, attemption);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param answerList 생성된 다리
     * @param index 비교하고 있는 다리의 index
     * @return 다리 건넌 결과를 반환한다.(어떤 다리를 건넜는지, 제대로 건넜는지)
     */
    public List<String> move(List<String> answerList, int index) {
        String moving = inputView.readMoving(); // 이동할 다리 입력
        List<String> value = compare(answerList.get(index), moving); //다리 값과 이동 값 비교하여 다리 건넌 결과
        if(value != null)
            valueList.add(value);

        return value;
    }

    /**
     * 다리 위치의 값과 사용자의 입력 값을 비교한다.
     * @param answer 비교할 다리 위치 값
     * @param moving 이동할 다리의 값
     * @return 이동값과 비교값을 반환한다. (이동값, 다리 값과 이동 값이 같으면 O를 반환 | 다리 값과 이동 값이 다르면 X를 반환)
     */
    private List<String> compare(String answer, String moving) {
        if(answer.equals(moving))
            return Arrays.asList(new String[]{moving, "O"});

        if(!answer.equals(moving))
            return Arrays.asList(new String[]{moving, "X"});

        return null;
    }

    /**
     *이동한 칸의 결과를 출력하는 메서드
     */
    private void printMove()
    {
        String[] bridges = new String[]{"U", "D"};
        for(String bridge : bridges)
            System.out.println(outputView.printMap(bridge, valueList));
        System.out.println();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param repeat 현재 다리의 위치
     * @return 게임 진행을 종료(Q)하면 최종 결과를 출력하고 false를 반환한다.
     *         게임 진행을 재시작(R)하면 잘못된 결과를 삭제하고 true를 반환한다.
     */
    private boolean retry(int repeat) {
        String gameCommand = inputView.readGameCommand(); // 게임 진행 여부 입력
        if(gameCommand.equals("Q")) {
            outputView.printResult(valueList, attemption);
            return false;
        }
        if(gameCommand.equals("R")) {
            valueList.remove(repeat);
            return true;
        }
        return false;
    }
}
