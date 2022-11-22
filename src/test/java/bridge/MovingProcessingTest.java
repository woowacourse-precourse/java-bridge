package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MovingProcessingTest extends CustomNsTest {

    private MovingProcessing movingProcessing;

    @Test
    @DisplayName("랜덤으로 입력된 브릿지를 매개변수로 사용자의 입력과 매치하는지 테스트")
    void compareBridgeToInputTest() {

        List<String> bridge = new ArrayList<>();
        bridge.add("U");
        bridge.add("D");
        bridge.add("D");
        bridge.add("D");

        //중간에 하나 틀리는 경우
        {
            command("4"); //크기입력(신경 안써도되는 코드)
            movingProcessing = new MovingProcessing();
            output(); //원할한 테스트를 위한 버퍼 지우기
            ////////////////////////////////////////////////////
            ////////////////Test본문////////////////////////////
            ///////////////////////////////////////////////////

            List<String> inputs = List.of("U", "D", "U");
            Iterator inputsIter = inputs.iterator();
            while (inputsIter.hasNext()) {
                String input = (String) inputsIter.next();
                movingProcessing.compareBridgeToInput(input, bridge);
            }
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | X ]",
                    "[   | O |   ]"
            );
        }

        //다 맞는 경우
        {
            command("4");//크기입력(신경 안써도되는 코드)
            movingProcessing = new MovingProcessing();
            output(); //원할한 테스트를 위한 버퍼 지우기
            ////////////////////////////////////////////////////
            ////////////////Test본문////////////////////////////
            ///////////////////////////////////////////////////

            List<String> inputs = List.of("U", "D", "D", "D");
            Iterator inputsIter = inputs.iterator();
            while (inputsIter.hasNext()) {
                String input = (String) inputsIter.next();
                movingProcessing.compareBridgeToInput(input, bridge);
            }

            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "[ O |   |   |   ]",
                    "[   | O | O | O ]"
            );
        }

        //중간에 잘못된 값이 잘못들어가면 다시 값을 받음
        {
            command("4");//크기입력(신경 안써도되는 코드)
            movingProcessing = new MovingProcessing();
            output(); //원할한 테스트를 위한 버퍼 지우기
            ////////////////////////////////////////////////////
            ////////////////Test본문////////////////////////////
            ///////////////////////////////////////////////////

            List<String> inputs = List.of("U", "D", "W", "D", "D");
            Iterator inputsIter = inputs.iterator();
            while (inputsIter.hasNext()) {
                String input = (String) inputsIter.next();
                movingProcessing.compareBridgeToInput(input, bridge);
            }
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "[ O |   |   |   ]",
                    "[   | O | O | O ]"
            );
        }
    }
}