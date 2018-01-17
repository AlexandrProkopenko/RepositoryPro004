package concurrencyapi.lesson06.reflectionapi;

public class ValueEx {

    private Integer integer;
    private ValueEx valueEx;

    public ValueEx(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
