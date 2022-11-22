package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.ArrayList;
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
    InputView inputView = new InputView();

    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    int size = inputView.readBridgeSize();
    List<String> bridge = bridgeMaker.makeBridge(size);

    int trynum = 1;
    String result = "성공";
    List<String> Up = new ArrayList<>();
    List<String> Down = new ArrayList<>();
    public void move() {
        Up.clear();
        Down.clear();
        for(int i=0;i<size;i++) {
            String moveing = inputView.readMoving();
            if(i==size-1){
                System.out.println("최종 게임 결과");
            }
            if(moveing.equals(bridge.get(i))) {
            up(moveing,"O");
            down(moveing,"O");
            outputView.printMap(Up,Down);
            }
            if(!moveing.equals(bridge.get(i))){
                up(moveing,"X");
                down(moveing,"X");
                outputView.printMap(Up,Down);
                retry();
                break;
            }
        }
    }
    public void resultprint() {
        outputView.printResult(trynum,result);
    }
    public void up(String moveing,String outcome) {
        if(moveing.equals("U")) {
            if(Up.contains("[")) {
                Up.add(Up.indexOf("]"),"|"+" "+outcome+" ");
                Down.add(Down.indexOf("]"),"|"+" "+" "+" ");
                System.out.println(Up.size());
            }
            if(!Up.contains("[")) {
                Up.add("["); Up.add(" "); Up.add(outcome); Up.add(" "); Up.add("]");
                Down.add("["); Down.add(" "); Down.add(" "); Down.add(" "); Down.add("]");
            }
        }
    }

    public void down(String moveing,String outcome) {
        if (moveing.equals("D")) {
            if(Down.contains("[")) {
                Up.add(Up.indexOf("]"),"|"+" "+" "+" ");
                Down.add(Down.indexOf("]"),"|"+" "+outcome+" ");
            }
            if (!Down.contains("[")) {
                Up.add("["+" "+" "+" "+"]");
                Down.add("["+" "+outcome+" "+"]");
            }
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String re = inputView.readGameCommand();
        if(re.equals("R")){
            ++trynum;
            move();
        }
        if(re.equals("Q")) {
            result = "실패";
            System.out.println("최종 게임 결과");
        }
    }
}
