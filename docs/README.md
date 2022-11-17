## 기능 목록

- class : BridgeGame
/* 다리 건너기 게임을 관리하는 클래스 */
  - package 변경 가능 
  - 필드(인스턴스 변수) 추가가능
  - 메서드의 시그니처(인자, 이름)와 반환타입 변경 가능
  - 메서드 추가 가능

  - move()
    /* 사용자가 칸을 이동할 때 사용하는 메서드 */
  - retry()
    /* 사용자가 게임을 다시 시도할 때 사용하는 메서드 */

- class : BridgeMarker
/* 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다. */
  - 필드(인스턴스 변수) 변경 불가능
  - 메서드의 시그니처(인자, 이름)와 반환타입 변경 불가능
  - public List<String> makeBridge(int size) {
    return null;
    }
    /* return : 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다. */

- interface : BridgeNumberGenerator
- class : BridgeRandomNumberGenerator
  - 코드 변경 불가능
  - int number = bridgeNumberGenerator.generate(); 이렇게 추출

- class : InputView
/* 사용자로부터 입력을 받는 역할을 한다. */
  - package 변경 가능
  - 메서드의 시그니처(인자, 이름)와 반환타입 변경 가능
  - 메서드 추가 가능

  - readBridgeSize()
    /* 다리의 길이를 입력받는다. */
  - readMoving()
    /* 사용자가 이동할 칸을 입력받는다. */
  - readGameCommand()
    /* 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. */
- 
- class : OutputView
/* 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. */
  - package 변경 가능
  - 메서드의 시그니처(인자, 이름)와 반환타입 변경 가능
  - 메서드 추가 가능

  - printMap()
    /* 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다. */
  - printResult()
    /* 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. */
  

- class : Bridge
  - [] 다리 생성
    - 위아래 둘 중 하나의 칸만 건널 수 있음 -> 생성자를 싱글톤으로 구현
    - 다리 생성시 다리의 칸 개수를 받아와야함
      - 3이상 20이하의 숫자 입력 가능
  - [] 다리 건널 수 있는 값 체크하는 flag
    - 0과 1을 받을 다리의 flag가 필요
- class : playGame
  - [] 사용자가 이동할 다리 선택 (U or D)
  - [] 다리 flag와 사용자 선택 값 비교
    - O or X로 return
    - [] O : 사용자가 다리를 움직이는 기능
    - [] X : 재시작 또는 종료 선택 (R or Q)
  - [] 현재 위치가 다리 끝인지 확인하는 기능
  - [] 게임 성공 여부 출력할 메서드
    - 게임 시도 횟수 기록할 변수 필요