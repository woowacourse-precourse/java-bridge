package bridge.domain.model;

/**
 * 이동 방향과 성공 여부를 저장하는 클래스
 */
public class PieceMove {

    private final Direction direction;
    private final boolean success;

    public PieceMove(final Direction direction, final boolean success) {
        this.direction = direction;
        this.success = success;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public boolean getSuccess() {
        return this.success;
    }
}
