package Data;

public class MyNumberException extends NumberFormatException{
    public MyNumberException() {
        super("Неверный формат номера ");
    }
}
