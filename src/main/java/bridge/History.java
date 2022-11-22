package bridge;

import java.util.Objects;

public class History {

    private final int position;
    private final String moveDirection;
    private final boolean moveSucess;

    public History(int position, String moveDirection, boolean moveSucess) {
        this.position = position;
        this.moveDirection = moveDirection;
        this.moveSucess = moveSucess;
    }

    public boolean isSameMoveDirection(String moveDirection) {
        return this.moveDirection.equals(moveDirection);
    }

    public boolean isMoveSucess() {
        return this.moveSucess;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History history = (History) o;
        return this.position == history.position && isMoveSucess() == history.isMoveSucess() && Objects
                .equals(this.moveDirection, history.moveDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position, this.moveDirection, isMoveSucess());
    }
}
