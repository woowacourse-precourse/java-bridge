package bridge.view.inputCallback;

import bridge.model.bridge.Node;
import camp.nextstep.edu.missionutils.Console;

public class ReadNodeToMoveCallback implements ReadLineCallback<Node> {
    private static final String MOVE_INPUT_PROMPT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    @Override
    public Node repeatToRead() {
        System.out.println(MOVE_INPUT_PROMPT);
        return Node.of(Console.readLine());
    }
}
