package Data;

public class MyLengthException extends IllegalArgumentException{

    public MyLengthException(String str){
        super(String.format("Слишком короткое значение %s", str));
    }
}
