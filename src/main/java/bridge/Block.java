package bridge;

public interface Block {
    void visit(BlockPosition position);

    Block next();

    BlockPosition position();

    boolean isVisited();

    boolean isLastBlock();

    boolean isPassed();
}
