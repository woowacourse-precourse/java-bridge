package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.SlabDTO;
import bridge.model.Slabs;
import bridge.type.SlabType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void intro() {

    }

    public void create() {
        List<String> safeRoute = this.makeRoute();

        for (String step: safeRoute) {
            int index = safeRoute.indexOf(step);
            List<SlabDTO> slabs = this.buildSlabs(index, SlabType.build(step));

            Slabs.getInstance().insertAll(slabs);
        }
    }

    private List<String> makeRoute() {
        int size = this.inputView.readBridgeSize();

        return BridgeMaker.getInstance().makeBridge(size);
    }

    private List<SlabDTO> buildSlabs(int index, SlabType safeSlab) {
        SlabType unsafeSlab = SlabType.build(safeSlab.getId() ^ 1);

        return List.of(
                new SlabDTO(index, safeSlab, true),
                new SlabDTO(index, unsafeSlab, false)
        );
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {


    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }
}
