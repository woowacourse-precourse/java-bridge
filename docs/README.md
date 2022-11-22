
# 현재 주어진 class 정리

# BridgeGame (객체) 

- bridge를 인자로 받아 게임을 생성함
- bridge, location(현재 위치)를 인스턴스 변수로써 가지고있음.

- 칸의 이동
  - 현재 위치정보인 location에 1을 더해준다.
- 현재 위치가 떨어지는 자리인지 안전한 자리인지를 판단하여 GameState형태로 반환한다,
- 떨어졌다면 Fall, 이겼다면 Win, 안전한 자리로 이동후 게임이 끝나지 않은경우 Alive를 반환
- 재시작 시 사용하는 메서드
  - 진행된 칸의 위치를 초기화 시키며 출력 또한 처음으로 되돌림.
  - 재시작 횟수를 저장하는 변수 count 에 1을 더해주는 기능.
# BridgeMarker (완)
- 길이를 입력받아 다리를 만드는 클래스
  - 길이를 입력받아 List<String> bridge (params = size) 을 반환한다.
  - bridge의 원소는 "U", "D"이 랜덤하게 들어가며,
    랜덤하게 1,0을 반환하는 BridgeNumberGenerator의 generate()를 사용한다.
    ("U" = 1 , "D" = 0) enum을 사용할지 안할지는 구현하며 판단.
  - ex) return List.of("U","D","U");

# BridgeNumberGenerator
- interface
- bridge에서 필요한 기능들을 선언
- 함수형 인터페이스기 때문에 하나밖에 선언하지못함
- 이외의 것은 static 함수로 선언 , defalt 함수
- ## BridgeRandomNumberGenerator
  - 위, 아래중 어느곳이 O 인지 결정하는 기능(0,1로 반환)

# InputView
- 모든 입력을 관리함

# OutputView
- 모든 output을 관리함

# InputStringShape
- inputView 클래스에서 입력받은 String형태의 bridgesize를 int로바꿔주는 기능
- ## StringToInt
  - InputStringShape를 상속받아 기능구현.

# NumberShape
- 1과 0을 "U","D"로 바꾼다.
  - # InputStringShape
    - NumberShape를 상속받아 기능 구현.

# 일단 제공된 클래스의 메서드를 완성한다.
- Test_Personal에서 test코드를 작성하고 기능 테스트를 한다.
- BridgeMaker 부터 시작하며
  다리에 관련된 함수는 BridgeNumberGenerator에서 구현하는식 
- 주석이 제공된 메서드만 우선 구현할 것.




# Application 진행 순서
- 
- 사이즈 입력 
- 브릿지 생성
- 브릿지 게임 생성
- 게임 시작
  - while(게임상태 == playing){
    - direction입력
    - move(direction)
    - move 성공 실패 여부에 따라 게임 종료,진행
      - (사이즈 끝까지 이동, 오답시 종료)
    - }
  - 종료시 게임결과 출력, 재시작 을 입력받음
- } 
- 결과 출력
- 종료