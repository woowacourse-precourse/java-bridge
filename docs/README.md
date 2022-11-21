## :key: 클래스 관계도
<br/>

![ClassDiagram](https://user-images.githubusercontent.com/96610382/202952542-991e098f-fecc-4414-8a5a-3a9b55bc1d4a.jpg)
- BridgeGame은 비즈니스 로직만을 담당하는 service layer
- BridgeController는 입력 출력 검증 로직 담당
- BridgeGame과 BridgeController 그리고 BridgeController와 OutputView 사이의 데이터 전달은 dto를 활용

<br/>

## :bulb: 클래스 설명
### :file_folder: domain 패키지
#### BridgeNumberGenerator
- int를 반환하는 함수형 인터페이스
#### BridgeRandomNumberGenerator
- BridgeNumberGenerator의 구현체
- Random 클래스를 활용하여 0과 1을 무작위로 반환
#### BridgeMaker
- 입력받은 길이 만큼의 다리를 생성하는 역할
- BridgeRandomNumberGenerator에서 받은 0과 1을 'U'와 'D' 형태로 변환
- 'U'와 'D'로 이루어진 Bridge(List)를 반환하는 역할
#### BridgeJudge
- BridgeMaker에서 생성한 Bridge를 갖는 클래스
- 이동 경로 정보인 MoveHistory를 Bridge와 비교하여 이동 성공여부를 판단하는 역할
#### Player
- 이동경로(moveHistory)와 시도 횟수(tryCount) 관한 정보를 지니고 있다.
- 재시도 시 이동 경로는 초기화하고 시도 횟수는 1 증가시킨다.

<br/>

### :file_folder: service 패키지
#### BridgeGame
- BridgeController의 비즈니스 로직 관련 요청을 담당하여 처리하는 역할
- 도메인 관련 데이터를 DTO 형태로 변환하여 Controller에 넘겨준다.

<br/>

### :file_folder: controller 패키지
#### BridgeController
- InputView를 통해 사용자 입력 값을 받는다.
- Validator를 통하여 사용자 입력 값을 검증한다.
- 검증된 데이터를 BridgeGame에 넘겨 비즈니스 로직을 처리한다.
- BridgeGame으로 부터 Dto형식의 데이터를 전달받아 OutputView를 통해 출력한다.














<br/>

## :pencil: 기능 구현 사항 
<br/>

- [x] 다리 생성 기능
  - [x] 다리 길이가 숫자가 아닐 경우 예외 처리
  - [x] 다리 길이가 3~20 사이의 숫자가 아닐 경우 예외 처리
  - [x] BridgeMaker 로 다리 생성 후 BridgeJudge 객체에 저장


- [x] 다리 이동 기능 
  - [x] U나 D가 아닌 다른 입력이 주어질 때 예외 처리
  - [x] 매 이동 마다 이동 방향을 Player 객체의 MoveHistory 에 기록
  - [x] 이동 후 BridgeJudge 객체를 통하여 이동에 성공했는지 실패했는지 여부 확인
  - [X] 이동에 실패했을 경우, R또는 Q 명령어 받기
  - [X] R 또는 Q 명령어가 입력되지 않을 경우 예외 처리
  - [X] 명령어가 R일 경우 tryCount 증가와 MoveHistory 초기화 작업 수행
  - [X] 명령어가 Q 이거나 이동을 완료했을 때 이동 중지


- [x] 게임 종료 시 결과 출력 기능