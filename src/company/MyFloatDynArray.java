package company;

public class MyFloatDynArray {

    public MyFloatDynArray (float [] initial){

        currentLen = initial.length;
        current = new float [initial.length];
        for (int i = 0; i < initial.length; ++i){
            current[i] = initial[i];
        }
    }

    public void append (float toAppend){
        float [] temp = new float [currentLen+1];
        for (int i = 0; i < currentLen; ++i){
            temp[i] = current [i];
        }
        temp[currentLen] = toAppend;

        ++currentLen;
        current = new float [currentLen];
        for (int i = 0; i < currentLen; ++i){
            current [i] = temp [i];
        }
    }

    public float [] current;

    private int currentLen;
}
