package bridge.model;

import java.util.Stack;

@FunctionalInterface
public interface BridgePrinter {

    String getPrintable(Stack<PieceMove> moveTrace);

}
