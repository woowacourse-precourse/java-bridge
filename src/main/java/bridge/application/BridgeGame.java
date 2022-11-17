package bridge.application;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.domain.repository.BridgeRepository;
import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.SelectMove;

import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final BridgeGame instance=new BridgeGame();
    private static final int SUCCESS=1;
    private static final int FAIL=0;
    private final BridgeRepository bridgeRepository;
    private final BridgeMaker bridgeMaker;
    private BridgeGame(){
        bridgeRepository=BridgeRepository.getInstance();
        bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public static BridgeGame getInstance(){
        return instance;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move() {
        String targetNumber=bridgeRepository.getBridge().get(bridgeRepository.getSuccessNumber());
        String selectNumber=bridgeRepository.getSelectMove().getMove();
        if(targetNumber.equals(selectNumber)){
            addResult("O");
            return SUCCESS;
        }
        addResult("X");
        return FAIL;
    }
    private void addResult(String status){
        if(bridgeRepository.getSelectMove().getMove().equals("U")){
            bridgeRepository.addUpperResult(" "+status+" ");
            bridgeRepository.addLowerResult("   ");
        }
        if(bridgeRepository.getSelectMove().getMove().equals("D")) {
            bridgeRepository.addUpperResult("   ");
            bridgeRepository.addLowerResult(" "+status+" ");
        }
        addCommonResult();
    }
    private void addCommonResult(){
        bridgeRepository.addUpperResult("| ");
        bridgeRepository.addLowerResult("| ");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


    public void setResult(){
        bridgeRepository.setResult();
    }

    public void generatorBridge(){
        bridgeRepository.updateBridge(bridgeMaker.makeBridge(bridgeRepository.getBridgeSize().getSize()));
    }
    public void saveBridgeSize(BridgeSize bridgeSize){
        bridgeRepository.saveBridgeSize(bridgeSize);
    }
    public void saveSelectMove(SelectMove selectMove){bridgeRepository.saveSelectMove(selectMove);}

}
