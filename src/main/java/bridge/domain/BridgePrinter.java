package bridge.domain;

import bridge.domain.model.PieceMove;

import java.util.Stack;

@FunctionalInterface
public interface BridgePrinter {

    String getPrintable(Stack<PieceMove> moveTrace);

}
