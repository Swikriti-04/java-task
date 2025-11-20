public class CustomException {
    public static void main(String[] args) {
        try {
            checkAge(11);
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
        }
    }

    static void checkAge(int age) throws MyOwnException {
        if (age < 18) {
            throw new MyOwnException("Age must be 18 or above!");
        }
    }
}
class MyOwnException extends Exception {
    public MyOwnException(String msg) {
        super(msg);
    }
}

