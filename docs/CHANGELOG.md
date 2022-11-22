style(Application) : 자동 정렬 기능을 이용하여 코드 라인 정리
fix(IOController) : 익명 클래스를 이용한 콜백에서 람다를 이용하도록 변경
fix(BridgeTest) : 예외 발생 테스트에서 발생하는 예외 종류 변경
fix(BridgeMapComponent, Message) : 다리 게임의 상태를 생성하는 방법 변경
fix(Player, Message) : 게임 결과 메시지를 얻어오는 메소드를 이용하여 게임 결과 반환
fix(BridgeMapComponent) : 발생하지 않는 예외를 회피하는 부분 제거
fix(BridgeGame) : 사용하지 않는 메소드 제거
test(ApplicationTest) : 다리 게임의 최종 기능 테스트
test(BridgeGameTest) : 다리 게임의 요청을 처리하는 BridgeGame 컨트롤러를 테스트
test(BridgeMapTest) : 아무 내역도 존재하지 않을때 출력 테스트 추가
test(BridgeTest) : 유효하지 않은 입력이 들어온 경우를 추가
fix(OutputView,Message) : 출력 형식을 변경
chore(BridgeMap,BridgeMapComponent) : util 패키지에서 model 패키지로 이동
fix(InputView) : 다리 게임 검증 기능을 분리
feat(Application) : 다리 게임 Application 구현
chore(IOController, Message) : 원시 문자열을 Message 클래스에 상수로 선언
fix(Bridge) : 발생 예외 종류를 IllegalStateException로 변경
feat(IOController) : 입출력 요청을 처리하는 IOController 클래스 추가
fix(Player) : restart 메소드 추가
feat(OutputView) : 출력을 담당하는 클래스를 구현
feat(BridgeGame) : 다리 건너기 게임을 제어하는 기능을 추가
debug(Player) : restart 함수 제거
debug(BridgeMapComponent): removeLast 기능에서 빈 리스트일 경우 예외 처리를 추가
style(BridgeMapComponent): 다리의 상태를 출력하는 기능의 출력 형식을 변경
test(BridgeMapTest): 다리의 상태를 출력하는 기능의 테스트를 추가
feat(BridgeMap): 현재까지 이동한 다리의 상태를 출력하는 기능을 추가
test(PlayerTest): Player 클래스의 기능을 점검하는 테스트를 추가
feat(Player): 다리 게임을 수행할 Player 객체를 만들어 다리 게임의 진행 상태를 관리
test(BridgeTest): Bridge 클래스의 도메인 로직 테스트를 작성
feat(Bridge): 다리 정보를 갖고 관련 요청을 처리하는 Bridge 클래스 생성
test(BridgeMakerTest): 생성한 다리 정보의 유효성을 검사하는 테스트를 추가
feat(BridgeMaker): 다리를 생성할때 쓰일 다리 정보를 생성하는 기능을 추가
chore(view,model,controller): 다리 게임에 사용될 클래스를 역할별로 모으기 위해 패키지 생성
fix(BridgeGameInfo): 다리 게임에 쓰일 전역 변수를 위한 클래스를 생성
test(InputViewTest): 다리 게임에 쓰일 입력 기능을 테스트하는 코드를 작성
feat(InputView): 다리 건너기 게임의 필요한 데이터를 입력하는 기능을 추가
docs(README.md): 다리 건너기 게임의 요구사항을 분석하고 설계한 내용을 추가
feat: setup precourse bridge game project