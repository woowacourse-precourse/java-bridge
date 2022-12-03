## JAVA Interface

- 객체를 어떻게 구성해야 하는지 정리한 설계도
- 객체가 인터페이스를 사용하면, 인터페이스 메서드를 반드시 구현해야 하는 제약

### 인터페이스 선언

```
public interface User  { ... }
```

- Class, Enum, Annotation처럼 "~.java" 파일로 작성되고, 컴파일러(javac.exe)를 통해서 바이트코드 형태의 "~.class" 파일로 컴파일
- interface의 접근 지정자는 public만 가능 (interface는 class 설계도 이기 때문에 애초에 존재 목적이 공개이기 때문)
- 객체로 생성할 수 없기 때문에, 생성자를 가질 수 없음
- **상수 필드, 추상 메서드, 디폴트 메서드, 정적 메서드**를 구성 멤버로 가짐
- Java 7까지는 실행 블록이 없는 추상 메서드로만 선언이 가능
- Java 8부터는 디폴트 메서드와 정적 메서드도 선언이 가능

---

### 인터페이스 구성 요소

```
**상수 : 인터페이스에서 값을 정해줄테니 함부로 바꾸지 말고 제공해주는 값만 참조해라 (절대적)

추상메소드 : 가이드만 줄테니 추상메소드를 오버라이팅해서 재구현해라. (강제적)

디폴트메소드 : 인터페이스에서 기본적으로 제공해주지만, 맘에 안들면 각자 구현해서 써라. (선택적)

정적메소드 : 인터페이스에서 제공해주는 것으로 무조건 사용 (절대적)**
```

#### 상수 필드 (Constant Field)

```
public interface User {
    String FIRST_NAME = "Ryan"; 
}
```

- 인터페이스는 _객체가 될 수 없기 때문에_, 런타임에 필드 데이터를 저장할 수 없으므로 인스턴스 필드/ 정적 필드는 선언이 불가능
- `[public static final]`는 명시적으로 사용하지 않아도, Compile Time에 자동으로 선언되어 상수가 됨

#### 추상 메서드 (Abstract Method)

```
public interface User {
    String sendMoney(Money money);
} 
```

- 인터페이스 변수로 호출된 메서드는 최종적으로 구현 객체에서 실행되므로, 실체는 인터페이스에 없고 구현 클래스에 있음
- 추상 메서드는 리턴 타입 / 메서드 이름 / 매개변수 가 기술되는 클래스 설계 메서드
- `[public abstract]`은 명시적으로 선언하지 않아도, Compile Time에 자동으로 선언
    - `String sendMoney(Money money)` 와  `public abstract String sendMoney(Money money)`는 같다

#### 디폴트 메서드 (Default Method)

```
public interface User {
    public default void setStatus(Status status) {
        if(status == Status.ACTIVE) {
            System.out.println("사용자가 활성화 되었습니다");
            return;
        }
        System.out.println("사용자가 비활성화 되었습니다");
    }
}
```

- Java 8에서 추가된 인터페이스의 멤버
- 클래스의 `인스턴스 메서드`와 동일
- 다만 인터페이스에서 선언할 때, 리턴 타입 앞에 `default` 키워드가 붙음
- `[public]`은 명시적으로 사용하지 않아도, Compile Time에 자동 선언됨
- 나중에 인터페이스를 구현한 구현 클래스에 인스턴스 메서드로 추가됨
- 재정의(Override)를 통해서 구현 클래스에서 재정의된 인스턴스 메서드로 사용할 수 있음

#### 정적 메서드 (Static Method)

```
public interface User {
    public static void printFirstName() {
        System.out.println("나의 이름은 " + firstName + "입니다.");
    }
}
```

- Java 8에서 추가된 인터페이스의 멤버
- 선언 형식은 클래스 `정적 메서드`와 완전 동일
- `[public]`은 명시적으로 사용하지 않아도, Compile Time에 자동으로 선언됨
- 인터페이스의 정적 메서드도 클래스의 정적 메서드와 똑같은 방식으로 사용이 가능함


