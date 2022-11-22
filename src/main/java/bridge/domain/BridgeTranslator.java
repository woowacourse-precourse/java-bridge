package bridge.domain;

import bridge.domain.model.PieceMove;

import java.util.Stack;

/**
 * 다리를 이동한 정보를 바탕으로 현재 건넌 칸들을 출력할 수 있도록 변환하는 인터페이스
 */
public interface BridgeTranslator {

    String getPrintable(Stack<PieceMove> moveTrace);

}
