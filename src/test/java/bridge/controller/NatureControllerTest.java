package bridge.controller;

import bridge.SuccessFail;
import bridge.dto.BridgeStatusDto;
import bridge.dto.CurrentStatusDto;
import bridge.dto.RetrySatutsDto;
import bridge.dto.SuccessOrFailureDto;
import bridge.mediator.ControllerMediator;
import bridge.reader.SuccessReader;
import bridge.service.Serivce;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class NatureControllerTest {


    @Test
    void generateBridge() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        Runnable runnable = controller.generateBridge(3);
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("moveBridge");
        }
    }

    @Test
    void 다리이동실패케이스() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("U","D","D")),new ArrayList<>());
        Runnable runnable = controller.moveBridge("D", new HashMap<>());
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("replay");
        }
    }

    @Test
    void 다리이동_한번성공_케이스() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("U","D","D")),new ArrayList<>());
        Runnable runnable = controller.moveBridge("U", new HashMap<>());
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("moveBridge");
        }
    }

    @Test
    void 다리이동_전체성공_케이스() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("D","D","U")),new ArrayList<>(Arrays.asList("D","D")));
        Runnable runnable = controller.moveBridge("U", new HashMap<>());
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("end");
        }
    }

    @Test
    void 다시시작_한다() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        Runnable runnable = controller.replay("R");
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("moveBridge");
        }
    }

    @Test
    void 다시시작_안한다() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        Runnable runnable = controller.replay("Q");
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("end");
        }
    }

    private static NatureController createController(ArrayList<String> bridge,ArrayList<String> footPoints) {
        NatureController controller = new NatureController(new MockControllerMediator(),new MockService(bridge,footPoints));
        return controller;
    }

    static class MockControllerMediator implements ControllerMediator {

        @Override
        public void moveBridge() {
            throw new RuntimeException("moveBridge");
        }


        @Override
        public void replay() {
            throw new RuntimeException("replay");
        }

        @Override
        public void end(BridgeStatusDto bridgeStatusDto) {
            throw new RuntimeException("end");
        }
    }

    static class MockService implements Serivce {

        private List<String> bridge;
        private List<String> footprints;

        private SuccessReader successReader=new SuccessReader();

        public MockService(List<String> bridge, List<String> footprints) {
            this.bridge = bridge;
            this.footprints = footprints;
        }

        @Override
        public void saveBridge(int size) {
        }

        @Override
        public CurrentStatusDto move(String direction) {
            footprints.add(direction);
            if(successReader.isOverallSuccess(footprints,bridge)){
                return new CurrentStatusDto(new BridgeStatusDto(new SuccessOrFailureDto("",""),0), SuccessFail.OverallSuccess);
            }
            if(successReader.isSuccess(footprints.get(footprints.size()-1),bridge.get(footprints.size()-1)))
                return new CurrentStatusDto(new BridgeStatusDto(new SuccessOrFailureDto("",""),0), SuccessFail.UNIT_SUCCESS);
            return new CurrentStatusDto(new BridgeStatusDto(new SuccessOrFailureDto("",""),0), SuccessFail.FAIL);
        }

        @Override
        public RetrySatutsDto isRetry(String restartCommand) {
            if(restartCommand.equals("R")){
                return new RetrySatutsDto(new BridgeStatusDto(new SuccessOrFailureDto("",""),0),true);
            }
            return new RetrySatutsDto(new BridgeStatusDto(new SuccessOrFailureDto("",""),0),false);
        }
    }
}