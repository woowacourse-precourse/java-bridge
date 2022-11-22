package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

     int trialCount=0;
     List<String> bridgePosion;
     List<String> playerPosion = new ArrayList<>();
     int step = 0;
     OutputView outputView = new OutputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String upDown){
        playerPosion.add(upDown);
        if(bridgePosion.get(step).equals(upDown)){
            outputView.printMap(step,bridgePosion,playerPosion);
            step=0;
            retry();
            return;
        }
        outputView.printMap(step,bridgePosion,playerPosion);
        step++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retryCommand = Console.readLine();
        if(!retryCommand.equals("R") && !retryCommand.equals("Q")){
            throw new IllegalArgumentException("[ERROR] R 와 Q만 입력 할수 있습니다.");
        }
    }
}
