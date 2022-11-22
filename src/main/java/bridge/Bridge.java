package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private List<Block> blocks;

    private Block current;

    public Bridge(List<String> bridge) {
        if (bridge.size() < MIN_SIZE || bridge.size() > MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이가 잘못되었습니다.");
        }
        current = NormalBlock.firstBlock(bridge.get(0));
        generateBlocks(bridge);
    }

    public void visit(BlockPosition type) {
        if (current.isVisited()) {
            throw new IllegalStateException("[ERROR] 이미 방문했습니다.");
        }

        if (current.isLastBlock()) {
            current.visit(type);
            return;
        }

        visitMiddleBlock(type);
    }

    public boolean isArrived() {
        return current.isLastBlock() && current.isPassed();
    }

    public boolean inProgress() {
        return !current.isVisited();
    }

    public List<Block> blocks() {
        return blocks.stream()
                .filter(Block::isVisited)
                .collect(Collectors.toUnmodifiableList());
    }

    private void generateBlocks(List<String> bridge) {
        List<Block> blocks = new ArrayList<>();
        NormalBlock block = (NormalBlock) current;
        blocks.add(block);

        for (int index = 1; index < lastBlockIndex(bridge); index++) {
            block = block.nextBlock(bridge.get(index));
            blocks.add(block);
        }
        blocks.add(block.lastBlock(bridge.get(lastBlockIndex(bridge))));
        this.blocks = blocks;
    }

    private int lastBlockIndex(List<String> bridge) {
        return bridge.size() - 1;
    }

    private void visitMiddleBlock(BlockPosition type) {
        current.visit(type);
        if (current.isPassed()) {
            current = current.next();
        }
    }
}
