package Data;

public class MyArraySizeException extends IndexOutOfBoundsException{
    public MyArraySizeException() {
        super("Введено недостаточно данных или пропущен пробел");
    }
    public MyArraySizeException(String str){
        super(String.format("Слишком длинное значение %s", str));
    }
    public MyArraySizeException(int n){
        super(String.format("Не входит в допустимый диапазон %s", n));
    }

}
