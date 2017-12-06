package stringproject.data;

import stringproject.dataexceptions.NotALetterException;

public class Letter {

    private char value;

    public Letter(char value) throws NotALetterException {
        if(!isValid(value))throw new NotALetterException();
        this.value=value;
    }
    public char getValue() {
        return value;
    }

    public void setValue(char value) throws NotALetterException {
        if(!isValid(value))throw new NotALetterException();
        this.value = value;
    }

    private boolean isValid(char value){
        return ((value<='z'&&value>='a')||(value<='Z'&&value>='A'));
    }
    boolean isCapital(){
        return value<='Z'&&value>='A';
    }
    @Override
    public String toString() {
        return ""+value;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter = (Letter) o;

        return value == letter.value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }
}
