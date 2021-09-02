package company;

public class MyCharDynArray {
    public MyCharDynArray (char [] initial){

        currentLen = initial.length;
        current = new char [initial.length];
        for (int i = 0; i < initial.length; ++i){
            current[i] = initial[i];
        }
    }

    public void append (char toAppend){
        char [] temp = new char [currentLen+1];
        for (int i = 0; i < currentLen; ++i){
            temp[i] = current [i];
        }
        temp[currentLen] = toAppend;

        ++currentLen;
        current = new char [currentLen];
        for (int i = 0; i < currentLen; ++i){
            current [i] = temp [i];
        }
    }

    public char [] current;

    public int currentLen;
}
