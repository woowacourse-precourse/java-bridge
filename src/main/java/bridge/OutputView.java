package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, Bridge block, int index) {
        StringBuilder upperSide = makeUpperSide(bridge, block, index);
        StringBuilder lowerSide = makeLowerSide(bridge, block, index);
        System.out.println(upperSide);
        System.out.println(lowerSide);

    }

    public StringBuilder makeUpperSide(List<String> bridge, Bridge block, int index){
        StringBuilder upperSide = new StringBuilder("[");
        for(int i = 0; i < index; i++){
            boolean availability = bridge.get(i).equals("U");
            makeMiddleBlock(upperSide, availability);
        }
        makeLastBlock(upperSide, block, "U");
        upperSide.deleteCharAt(upperSide.length() - 1);
        return upperSide.append(" ]");
    }

    public StringBuilder makeLowerSide(List<String> bridge, Bridge block, int index){
        StringBuilder lowerSide = new StringBuilder("[");
        for(int i = 0; i < index; i++){
            boolean availability = bridge.get(i).equals("D");
            makeMiddleBlock(lowerSide, availability);
        }
        makeLastBlock(lowerSide, block, "D");
        lowerSide.deleteCharAt(lowerSide.length() - 1);
        return lowerSide.append(" ]");
    }
    public StringBuilder makeMiddleBlock(StringBuilder side, boolean availability){
        if(availability){
            side.append(" O ");
        }
        if(!availability){
            side.append("   ");
        }
        return side.append("|");
    }

    public StringBuilder makeLastBlock(StringBuilder side, Bridge block, String direct){
        boolean availability = block.getResult();
        String blockDirect = block.getSide();
        if(blockDirect.equals(direct) && availability){
            return side.append(" O ");
        }
        if(blockDirect.equals(direct) && !availability){
            return side.append(" X ");
        }
        return side.append("   ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
