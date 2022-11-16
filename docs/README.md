
# 현재 주어진 class 정리

## BridgeGame (객체) 
- 칸의 이동
  - makeBridge에서 반환하는 객체의 클래스가 list이므로 칸의 이동은 index의 증가로 구현
  - 칸의 이동시 성공, 실패 여부를 판단하는 기능.
  - 칸의 이동이 다리의 길이 만큼 진행되었다면 재시작을 판단하는 기능.
- 재시작 시 사용하는 메서드
  - 진행된 칸의 위치를 초기화 시키며 출력 또한 처음으로 되돌림.
  - 재시작 횟수를 저장하는 변수 count 에 1을 더해주는 기능.
## BridgeMarker
- 길이를 입력받아 다리를 만드는 클래스
  - 길이를 입력받아 List<String> bridge (params = size) 을 반환한다.
  - bridge의 원소는 "U", "D"이 랜덤하게 들어가며,
    랜덤하게 1,0을 반환하는 BridgeNumberGenerator의 generate()를 사용한다.
    ("U" = 1 , "D" = 0) enum을 사용할지 안할지는 구현하며 판단.
  - ex) return List.of("U","D","U");

## BridgeNumberGenerator
- interface
- bridge에서 필요한 기능들을 선언
  - 추가적으로 필요한 기능들은 추가 구현
## BridgeRandomNumberGenerator
- 위, 아래중 어느곳이 O 인지 결정하는 거같음

## InputView
- 모든 입력을 관리함

## OutputView
- 모든 output을 관리함



# 진행과정

## 일단 제공된 클래스의 메서드를 완성한다.
- Test_Personal에서 test코드를 작성하고 기능 테스트를 한다.
- BridgeMaker 부터 시작하며
  다리에 관련된 함수는 BridgeNumberGenerator에서 구현하는식 
- 주석이 제공된 메서드만 우선 구현할 것.
