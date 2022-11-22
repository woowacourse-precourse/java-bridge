package bridge.view;

import bridge.domain.repository.BridgeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final BridgeRepository bridgeRepository;
    public OutputView(){
        bridgeRepository=BridgeRepository.getInstance();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        printResult(bridgeRepository.getUpperResult());
        printResult(bridgeRepository.getLowerResult());
    }
    private void printResult(List<String> result){
        List<String> temp=new ArrayList<>(result);
        temp.set(temp.size()-1,"]");
        for(String s:temp){
            System.out.print(s);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println();
        System.out.println("게임 성공 여부: "+bridgeRepository.getSuccessOrFail());
        System.out.println("총 시도한 횟수: "+bridgeRepository.getAttemptNumber());
    }
    public void printGameRunMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printInputBridgeSizeMessage(){
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printSelectMoveMessage(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printInputRetryMessage(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
