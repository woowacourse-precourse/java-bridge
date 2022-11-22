## 클래스 구현
- InputView 클래스
  - 여러가지 입력을 받는 클래스
  - 다리 길이, 움직임, 게임 재시작 여부를 입력받는다
- OutputView 클래스
  - 다리에 관련한 출력을 담당하는 클래스
  - 다리 map이나 결과를 출력한다
- BridgeGame 클래스
  - 게임 형태 저장 및 게임 시작을 담당하는 클래스
- BridgeMaker 클래스
  - 필드 인스턴스 변경 x
  - **반환타입 등 변경 불가능**  
- BridgeRandomNumberGenerator 클래스
  - 수정 x
  
## 기능 구현
- [x] 다리 길이 입력
- [x] 건너갈 위치(U,D)입력
- [X] 다리 생성 메소드 
- [X] 건너기 실패 시 게임 종료
- [X] 건너기 실패/성공 후 종료 문구 출력
- [X] 재시작 여부 입력
- [X] 예외처리
- [X] 건너간 정보 저장하는 기능 구현
- [X] 다리 정보 출력기능 구현
## 클래스 구상
- main 클래스에서 BridgeGame 클래스 생성 및 게임 시작
- BridgeGame에서 InputView를 통해 다리길이 입력받기
- BridgeGame에서 BridgeMaker를 통해 다리 생성
- BridgeGame에서 다리 길이 만큼 InputView를 통해 움직입 입력받기
- X칸을 밟을 경우 진행사항 초기화 및 InputView를 통해 재시작 여부 입력받기
- 건너기 성공 시 OutputView를 통해 최종 결과 출력

## 추가 구현
- InputView 클래스
  - Move나 Bridge Size에 대한 변수를 Enum으로 저장
  - 입력 안내 문구를 Enum으로 저장
  - 입력 예외처리용 함수 생성
    - 이때, Move나 size에 따라 분리하지 않고, Enum 데이터를 이용
- OutputView 클래스
  - Bridge 클래스를 전달받아 형태 출력, formatting 사용
  - 출력 문구는 Enum으로 저장
- BridgeGame 클래스
  - Bridge 클래스 추가 구현
  - BridgeMaker를 통해 Bridge에 들어갈 데이터 받기
  - **InputView, OutputView 클래스 사용X**
  - nextStep이라는 메소드를 통해 Bridge클래스 움직임 구현
    - Fail, Success라는 enum 생성으로 움직임 성공 여부 파악
    - 최대 길이까지 Success시 건너기 성공으로 판정
    - 건너간 루트 저장
- Bridge 클래스
  - BridgeMaker로 전달받은 인자로 다리 생성
  - Move에 관한 메소드 생성 및 BridgeGame의 nextStep에서 호출
  

