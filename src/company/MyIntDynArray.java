package company;

public class MyIntDynArray {

    //TODO create a simple and useful DynArray
    public MyIntDynArray (int [] initial){

        currentLen = initial.length;
        current = new int [initial.length];
        for (int i = 0; i < initial.length; ++i){
            current[i] = initial[i];
        }
    }

    public void append (int toAppend){
         int [] temp = new int [currentLen+1];
         for (int i = 0; i < currentLen; ++i){
             temp[i] = current [i];
         }
         temp[currentLen] = toAppend;
         
         ++currentLen;
         current = new int [currentLen];
         for (int i = 0; i < currentLen; ++i){
             current [i] = temp [i];
         }
    }

    public int [] current;
    
    private int currentLen;
    
    



}
