
# 다리 건너기 미션 기능 요구 사항 정리

### 입력(InputView)

- 다리의 길이 입력 받기 (3≤ bridge ≤20의 숫자)
- 플레이어가 이동할 칸 입력 (’U’나 ‘D’ 하나의 문자)
- 게임 재시작/종료 여부 입력 (’R’이나 ‘Q’ 하나의 문자)
    
### 입력 예외 처리 (InputValidation)
- 숫자만 입력했는지 정규식으로 예외 처리
- 3에서 20 사이의 값인지 확인하는 예외 처리
- 'U' 혹은 'D'인지 확인하는 예외 처리
- 'R' 혹은 'Q'인지 확인하는 예외 처리
### 출력(OutputView)

- 사용자의 현재까지의 입력과 마지막 성공 여부에 따라 String으로 다리 모양 출력
- 게임 종료 문구 출력

### 다리 생성(****BridgeMaker****)
- List<String> makeBridge(int size)
  - 다리를 길이에 맞게 랜덤하게 숫자를 생성하여 0이면 D 1이면 U를 List에 추가하며 List를 반환하는 가능

### 다리 관리 (Bridge)
- Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator)
  - 다리를 인스턴스 변수로 선언하고, 이를 BrigeMaker를 통해서 초기화하는 생성자 생성
- boolean isCanCross(int location, String goal)
  - 사용자의 현재 위치와 입력 값을 받아 다음 위치가 건널 수 있으면 True 건널 수 없으면 False 반환

### Status(enum)

- 유저가 다리를 건너는 현재 상태를 상수로 저장 : SUCESS_END,FAILED_END,DOING

### BridgeGame

- playGame()
  - 게임의 흐름에 따라 각 메소드를 호출하는 기능
- move()
  - user.move() 호출 및 반환값 그대로 반환
- retry()
  - user.retry() 호출 및 반환값 그대로 반환

### USER

- 현재 상태를 인스턴스 변수로 저장 및 관리
  - List<String>(지금까지의 입력)
  - 총 게임 시도 횟수
  - 현재 위치
  - 총 다리의 길이
  - 현재 상태
- boolean move()
  - 현재 위치+1과 사용자의 입력값을 기반으로 Bridge에 다음 위치가 갈 수 있는지 확인하고 상태를 업데이트 후 다리를 출력하고,  그 값을 반환하는 기능
- void retry()
  - 사용자의 재시작 입력 여부 호출
  - R이면 init 호출하여 모든 변수 초기화
  - Q이면 Status 변경
- void reinitialize()
  - 현재 상태(List<String>,현재 위치)를 재시작을 위해 초기화
- void isCrossBridge()
  - 현재 위치와 총 다리의 길이를 비교하여 현재 다리를 전부 다 건넌 상태인지 건너는 중인지, 실패하였는지 상태값 업데이트
- boolean isEnd()
  - 현재 status가 DOING이 아니면 마지막 결과를 출력하고, False 반환

---

## TEST

### InputViewValidationTest
- 숫자가 아닌 수를 정확히 예외처리 하는지 테스트
- 숫자가 3에서 20사이의 범위를 지키지 못했을 때 예외처리 테스트
- 'U' 혹은 'D'인지 확인하는 예외 처리 테스트
- 'R' 혹은 'Q'인지 확인하는 예외 처리 테스트

### BridgeMakerTest
- List가 입력한 길이만큼의 size를 갖는지 테스트
- List가 U와 D의 값만 갖는지 테스트
- List<Integer>의 0과 1이 알맞은 List<String> U와 D로 변환되는지 테스트

### BridgeTest
- 다리가 사용자의 입력값과 현재위치와 비교하여, 알맞은 반환 값을 반환하는지 테스트

### UserTest
- 유저가 다리를 다 건넜을 때, 건나다 실패하고 종료했을 때, 재시도 했을 때, isEnd()값이 제대로 나오는지 테스트 