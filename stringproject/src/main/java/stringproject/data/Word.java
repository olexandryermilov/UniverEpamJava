package stringproject.data;

import stringproject.dataexceptions.NotAWordException;

import java.util.ArrayList;

public class Word {
    private ArrayList<Letter> letters;

    private boolean isValid(ArrayList<Letter> letters){
        for(int i=1;i<letters.size();i++){
            if(letters.get(i).isCapital()){
                return false;
            }
        }
        return true;
    }
    public Word(ArrayList<Letter> letters) throws NotAWordException {
        if(!isValid(letters)) {
            throw new NotAWordException();
        }
        this.letters = letters;
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Letter> letters) throws NotAWordException {
        if(!isValid(letters)) {
            throw new NotAWordException();
        }
        this.letters = letters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return letters != null ? letters.equals(word.letters) : word.letters == null;
    }

    @Override
    public int hashCode() {
        return letters != null ? letters.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<letters.size();i++){
            sb.append(letters.get(i));
        }
        return sb.toString();
    }
}
