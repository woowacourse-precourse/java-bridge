package bridge;

import java.util.Objects;

public class MoveInput {
    private String moveDirection;

    public MoveInput(String moveDirection) {
        this.moveDirection = moveDirection;
        validateMoveInput();
    }

    public String getMoveDirection() {
        return moveDirection;
    }

    private void validateMoveInput() {
        if (!Objects.equals(this.moveDirection, "U") && !this.moveDirection.equals("D")) {
            System.out.println("[ERROR] : 이동 칸 입력은 'U' 또는 'D' 가 입력되어야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
