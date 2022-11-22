package bridge;

import java.util.List;

import static bridge.GameMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(StringBuilder side) {
        System.out.println(side);
    }
    public void printResultMap(StringBuilder side){
        System.out.println(GAME_END_MESSAGE);
        System.out.println(side);
    }
    public StringBuilder makeSide(List<String> bridge, Bridge block, int index){
        StringBuilder side = new StringBuilder();
        side.append(makeUpperSide(bridge, block, index) + "\n");
        side.append(makeLowerSide(bridge, block, index));
        return side;
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
    public void printResult(int tryCount, boolean success) {
        if(success){
            System.out.println(GAME_SUCCESS_MESSAGE + "성공");
        }
        if(!success){
            System.out.println(GAME_SUCCESS_MESSAGE + "실패");
        }
        System.out.printf(GAME_TRY_COUNT_MESSAGE, tryCount);
    }
}
