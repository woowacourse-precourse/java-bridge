package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private List<String> UpMap;
    private List<String> DownMap;
    private List<String> randomMap;
    private int bridgesize;
    private boolean flag;
    private String move;
    private int count;
    private int idx;

    public BridgeGame(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgesize = 0;
        this.flag = false;
        this.count = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        while(flag && idx < randomMap.size()) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            move = inputView.readMoving();
            buildUserMap();
            outputView.printMap(List.of(UpMap, DownMap));
            idx++;
        }
        return isSuccess();
    }

    private boolean isSuccess() {
        count++;
        if(flag) {
            outputView.printResult(flag, List.of(UpMap, DownMap), count);
            return true;
        }
        return false;
    }

    private void buildUserMap() {
        if(move.equals("U")) {
            validateMove("U", UpMap, DownMap);
        }
        if(move.equals("D")) {
            validateMove("D", DownMap, UpMap);
        }

    }

    private void validateMove(String move, List<String> list1, List<String> list2) {
        if(randomMap.get(idx).equals(move)) {
            list1.add("O");
        }
        if(!randomMap.get(idx).equals(move)) {
            list1.add("X");
            flag = false;
        }
        list2.add(" ");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        boolean re;
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        re = inputView.readGameCommand();
        if(!re) {
            outputView.printResult(false, List.of(UpMap, DownMap), count);
        }
        return re;
    }

    public void init() {
        System.out.println("다리의 길이를 입력해주세요.");
        bridgesize = inputView.readBridgeSize();
        randomMap = bridgeMaker.makeBridge(bridgesize);
        UpMap = new ArrayList<>();
        DownMap = new ArrayList<>();
        flag = true;
        idx = 0;
    }
}
