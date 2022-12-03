package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeProgress {
    private final List<String> upperBlocks;
    private final List<String> lowerBlocks;

    public BridgeProgress(){
        upperBlocks = new ArrayList<>();
        lowerBlocks = new ArrayList<>();
    }

    /**
     *
     * @return 현재 몇 번째 블럭에 있는지를 반환
     */
    public Integer size(){
        return upperBlocks.size();
    }

    /**
     *
     * @param upperSymbol "O", "X", " " 중 하나.
     * @param lowerSymbol "O", "X", " " 중 하나.
     * 현재 진행 상황에 추가
     */
    public void put(String upperSymbol, String lowerSymbol){
        upperBlocks.add(upperSymbol);
        lowerBlocks.add(lowerSymbol);
    }

    /**
     * 진행 상황을 초기화
     */
    public void clear(){
        upperBlocks.clear();
        lowerBlocks.clear();
    }

    /**
     *
     * @return 위쪽 블럭들
     */
    public List<String> getUpperBlocks(){
        return upperBlocks;
    }

    /**
     *
     * @return 아래쪽 블럭들
     */
    public List<String> getLowerBlocks() {
        return lowerBlocks;
    }
}
