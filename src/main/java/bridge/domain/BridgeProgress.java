package bridge.domain;

import bridge.domain.constants.BlockSymbol;

import java.util.ArrayList;
import java.util.List;

public class BridgeProgress {
    private final List<String> upperBlock;
    private final List<String> lowerBlock;

    public BridgeProgress(){
        upperBlock = new ArrayList<>();
        lowerBlock = new ArrayList<>();
    }

    /**
     *
     * @return 현재 몇 번째 블럭에 있는지를 반환
     */
    public Integer size(){
        return upperBlock.size();
    }

    /**
     *
     * @param upperSymbol "O", "X", " " 중 하나.
     * @param lowerSymbol "O", "X", " " 중 하나.
     * 현재 진행 상황에 추가
     */
    public void put(String upperSymbol, String lowerSymbol){
        upperBlock.add(upperSymbol);
        lowerBlock.add(lowerSymbol);
    }

    /**
     * 진행 상황을 초기화
     */
    public void clear(){
        upperBlock.clear();
        lowerBlock.clear();
    }

    /**
     *
     * @return 현재까지의 진행 상황을 형식화해 문자열 리스트로 반환
     */
    public List<String> asMap(){
        return List.of(String.join(BlockSymbol.BORDER.getSymbol(), upperBlock),
                String.join(BlockSymbol.BORDER.getSymbol(), lowerBlock));
    }

}
