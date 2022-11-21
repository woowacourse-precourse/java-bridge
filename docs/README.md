## :pencil: 기능 구현 사항
<br/>

### :exclamation: 다리 생성 기능
  - [x] [예외 처리] 다리 길이가 숫자가 아닐 경우
  - [x] [예외 처리] 다리 길이가 3~20 사이의 숫자가 아닐 경우
  - [x] [구현 사항] BridgeMaker로 Bridge 생성 후 BridgeJudge에 Bridge를 List 형태로 저장

### :exclamation: 다리 이동 기능
  - [x] [예외 처리] U나 D가 아닌 다른 입력이 주어질 경우
  - [x] [구현 사항] 매 이동 마다 방향('U' 또는 'D')을 Player 객체의 MoveHistory 리스트에 추가
  - [x] [구현 사항] BridgeRouteDto에 moveHistory와 Bridge정보를 담아 OutputView에 전달
  - [x] [구현 사항] 이동 결과를 O 또는 X를 활용하여 출력
  - [x] [구현 사항] 이동 후 BridgeJudge 객체를 통하여 Player의 이동 성공 및 실패 여부 확인
  - [X] [구현 사항] 이동에 실패했을 경우, R또는 Q 명령어 입력 받기
  - [X] [예외 처리] R 또는 Q 명령어가 입력되지 않을 경우
  - [X] [구현 사항] 명령어가 R일 경우 tryCount 증가와 MoveHistory 초기화 작업 수행
  - [X] [구현 사항] 명령어가 Q 이거나 이동을 완료했을 때 이동 중지 후 결과 출력 로직으로 넘어감

### :exclamation: 결과 출력 기능
  - [x] [구현 사항] ResultDto를 통하여 player의 시도횟수, 성공여부, 다리, 이동기록 정보를 OutputView에 전달
  - [x] [구현 사항] 이동 결과를 O. X를 활용하여 나타내고 시도 횟수와 성공 여부를 출력한다.

<br/>

## :key: 클래스 관계도
<br/>

![ClassDiagram](https://user-images.githubusercontent.com/96610382/202952542-991e098f-fecc-4414-8a5a-3a9b55bc1d4a.jpg)
- BridgeGame은 비즈니스 로직만을 담당하는 service layer
- BridgeController는 입력 출력 검증 로직 담당
- BridgeGame과 BridgeController 그리고 BridgeController와 OutputView 사이의 데이터 전달은 dto를 활용

<br/>

## :bulb: 클래스 설명

<br/>

### :file_folder: domain
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

### :file_folder: service
#### BridgeGame
- BridgeController의 비즈니스 로직 관련 요청을 담당하여 처리하는 역할
- 도메인 관련 데이터를 DTO 형태로 변환하여 Controller에 넘겨준다.

<br/>

### :file_folder: controller
#### BridgeController
- InputView를 통해 사용자 입력 값을 받는다.
- Validator를 통하여 사용자 입력 값을 검증한다.
- 검증된 데이터를 BridgeGame에 넘겨 비즈니스 로직을 처리한다.
- BridgeGame으로 부터 DTO형식의 데이터를 전달받아 OutputView를 통해 출력한다.

<br/>

### :file_folder: validation
#### Validator
- InputView를 통해 전달받은 입력 값에 대한 검증 역할
- 검증에 통과하지 못하면 예외를 발생시킨다.

<br/>

### :file_folder: view
#### InputView
- 입력과 관련된 안내 문구를 출력하고 입력 값을 BridgeController에 전달하는 역할
#### OutputView
- 도메인 관련 정보를 담고 있는 DTO를 활용하여 각 상황에 맞는 결과값을 출력하는 역할

<br/>

### :file_folder: dto
#### BridgeRouteDto
- 매 이동마다 결과와 관련된 Map을 출력하기 위해 Bridge와 MoveHistory관련 정보를 지니고 있다.
#### ResultDto
- 사용자가 다리 건너기에 성공하거나 재시도를 포기 할 시 출력에 필요한 정보를 담고 있다.
- player의 시도 횟수, 성공 여부, BridgeRouteDto관련 정보를 지니고 있다.
