import java.util.Objects;

public class IntHolder{
    private int value;

    public IntHolder(int value){
        this.value = value;
    }
    public static IntHolder of(int value) {
        return new IntHolder(value);
    }
    public int getValue(){
        return this.value;
    }
    public int sum(IntHolder a){
        return a.value + this.value;
    }
    public  int diff(IntHolder a){
        return this.value - a.value;
    }
    public int multiplication(IntHolder a){
        return this.value * a.value;
    }
    public int division(IntHolder a){
        return this.value / a.value;
    }
    public int remainder(IntHolder a){
        return this.value % a.value;
    }
    public static void swap(IntHolder a, IntHolder b){
        int c = a.value;
        a.value = b.value;
        b.value = c;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        IntHolder comparable = (IntHolder) obj;
        return this.diff(comparable) == 0;
    }
    @Override
    public int hashCode(){
        int result = (int) value % 1000000;
        return result;
    }


}
