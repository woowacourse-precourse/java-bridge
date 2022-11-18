<h3> Part의 분류 및 제안 </h3>

 > Bridge Part는 다리에 관련한 부분이다. 이에 속하는 Class는 다음과 같다.
 > - BridgeGame: 게임을 총괄하는 Class
 >   - 게임은 Bridge를 만들 필요가 있기에 BridgeMaker를 필드로 갖고 있어야한다.
 >   - BridgeMaker를 통해 만든 Bridge를 저장해야하기에 Bridge를 필드로 갖고 있어야한다.
 >   - InputView/OutputView를 사용하지 않는다.
 >   - move()를 통해 Player가 이동한다.
 >   - retry()를 통해 Player가 시작지점부터 다시 진행한다.
 >   - move()를 한 횟수를 체크하기 위해 moveCnt 필드를 갖고 있어야한다.
 >   - Player가 위치하고 있는 장소를 체크하기 위해 cursor 필드를 갖고 있어야한다.
 > - BridgeMaker: 다리를 만드는 Class
 >   - 다리를 만들기 위해선 size를 입력받아야하기에 InputView를 사용한다.
 >   - 입력받은 size를 토대로 BridgeRandomNumberGenerator를 이용해 랜덤 생성한다.
 > - BridgeRandomNumberGenerator: BridgeNumberGenerator Interface의 구현 Class
 > 
 > View Part는 사용자의 입출력을 담당하는 부분이다. 이에 속하는 Class는 다음과 같다.
 > - InputView: 입력을 총괄하는 Class
 >   - 다리 길이를 입력 받고 이를 BridgeMaker로 넘겨야 한다.
 >   - 이동할 칸을 받고 이를 전달해야한다.
 > - OutputView: 출력을 총괄하는 Class
 >   - 게임 시작 문구를 출력해야한다.
 >   - 현재 상태를 출력하기 위해서 Bridge를 받아 출력해야한다.
 >   - 게임 결과를 출력하기 위해 게임 성공 여부와 총 시도 횟수를 받아 출력해야한다.
 > Exception Part는 Bridge Game에서의 예외 처리에 사용된다. 이에 속하는 Class는 다음과 같다.
 >   - ExceptionList: Exception의 이름을 String으로 저장하고 있는 enum 이다.
 >   - Exception: 예외 상황을 직접적으로 처리하는 Class이다.