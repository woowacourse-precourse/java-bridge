package bridge.view;

import bridge.domain.Bridge;

import static bridge.utils.Constants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, int blockNumber) {
        printLine(bridge, blockNumber, IS_UP_BLOCK);
        printLine(bridge, blockNumber, IS_DOWN_BLOCK);
    }

    private void printLine(Bridge bridge, int blockNumber, boolean isUpBlock){
        System.out.print(LINE_START);
        for(int i = 0; i < blockNumber - 1; i++){
            printBlock(bridge, i, isUpBlock);
            System.out.print(BLOCK_SPLIT);
        }
        printBlock(bridge, blockNumber - 1, isUpBlock);
        System.out.println(LINE_END);
    }

    private void printBlock(Bridge bridge, int blockNumber, boolean isUpBlock){
        if(isUpBlock && bridge.isUpBlock(blockNumber) == true){
            System.out.print(BLOCK_SUCCESS);
            return;
        }
        if(!isUpBlock && bridge.isUpBlock(blockNumber) == false){
            System.out.print(BLOCK_SUCCESS);
            return;
        }
        System.out.print(BLOCK_BLANK);
    }

    private void printFailureLine(Bridge bridge, int blockNumber, boolean isUpBlock, boolean isFailure){
        System.out.print(LINE_START);
        for(int i = 0; i < blockNumber - 1; i++){
            printBlock(bridge, i, isUpBlock);
            System.out.print(BLOCK_SPLIT);
        }
        if(isFailure){
            System.out.print(BLOCK_SUCCESS);
            System.out.println(LINE_END);
        }
        if(!isFailure){
            System.out.print(BLOCK_BLANK);
            System.out.println(LINE_END);
        }
    }

    public void printResult(Bridge bridge, int blockNumber, boolean isSuccess, boolean isUpBlock) {
        if(isSuccess){
            printMap(bridge, blockNumber);
        }
        if(!isSuccess && isUpBlock){
            printFailureLine(bridge, blockNumber, IS_UP_BLOCK, IS_FAILURE);
            printFailureLine(bridge, blockNumber, IS_DOWN_BLOCK, IS_NOT_FAILURE);
        }
        if(!isSuccess && !isUpBlock){
            printFailureLine(bridge, blockNumber, IS_UP_BLOCK, IS_NOT_FAILURE);
            printFailureLine(bridge, blockNumber, IS_DOWN_BLOCK, IS_FAILURE);
        }
    }
}
