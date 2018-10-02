package cryptography;

import java.util.Scanner;

public class Playfair {
    private final char[][] matrix;
    private final char[] characters ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.?!@#$%&*()+<>;' \"".toCharArray() ;

    private Playfair() {
        this.matrix = new char[9][9];
    }
    
    public static Playfair getInstanceof(){
        return (new Playfair());
    }
    
    
    protected  String encrypt(String key,String message){
        int jl,jr,kl,kr,index=0,i = 0;
        char [] messageArray = message.toCharArray();
        char [] encryptedText = new char[messageArray.length+1];
        matrixInit(key);
        System.out.println(messageArray.length);
        
        while (i<(messageArray.length)){
            jl = getLeft(messageArray[i]);
            jr  = getRight(messageArray[i]);
            System.out.println(i);
            if( i+1>=messageArray.length || messageArray[i] == messageArray[i+1])
            {
                kl = getLeft('x');
                kr = getRight('x');
                i++;
            }
            else{
                kl = getLeft(messageArray[i+1]);
                kr  = getRight(messageArray[i+1]);
                i=i+2;
            }
            System.out.println("\n"+jl+jr+kl+kr+"\n");
            if(jl == -1 || jr == -1 || kl == -1 || kr == -1 ){
                return "Something unexpected happened!";
            }
            if(jl == kl){
                encryptedText[index] = matrix[jl][(jr+1)%9];
                encryptedText[index+1]=matrix[jl][(kr+1)%9];
            }
            else if(jr == kr){
                encryptedText[index] = matrix[(jl+1)%9][jr];
                encryptedText[index+1] = matrix[(kl+1)%9][jr];
            }
            else{
                encryptedText[index] = matrix [jl][kr];
                encryptedText[index+1] = matrix [kl][jr];
            }
            //System.out.println("index"+index);
            index = index+2;
        }
        return (new String(encryptedText));
    }
    
    protected String decrypt ( String message){
        if (matrix == null){
            String key;
            System.out.println("Enter the given key:");
            Scanner reader = new Scanner(System.in);
            key = reader.nextLine();
            matrixInit(key);
        }
         int jl,jr,kl,kr,index=0,i = 0;
        char [] messageArray = message.toCharArray();
        char [] decryptedText = new char[messageArray.length+1];
        System.out.println(messageArray.length);
        
        while (i<(messageArray.length-1)){
            jl = getLeft(messageArray[i]);
            jr  = getRight(messageArray[i]);
            System.out.println(i);
            kl = getLeft(messageArray[i+1]);
            kr  = getRight(messageArray[i+1]);
            
            
            System.out.println("\n"+jl+jr+kl+kr+"\n");
            if(jl == -1 || jr == -1 || kl == -1 || kr == -1 ){
                return "Something unexpected happened!";
            }
            if(jl == kl){
                decryptedText[i] = matrix[jl][(9+jr-1)%9];
                decryptedText[i+1]=matrix[jl][(9+kr-1)%9];
            }
            else if(jr == kr){
                decryptedText[i] = matrix[(9+jl-1)%9][jr];
                decryptedText[i+1] = matrix[(9+kl-1)%9][jr];
            }
            else{
                decryptedText[i] = matrix [jl][kr];
                decryptedText[i+1] = matrix [kl][jr];
            }
            //System.out.println("index"+index);
            i = i+2;
        }
        return (new String(decryptedText));
    }
    
    private void matrixInit(String key){
        char[] temp = key.toCharArray();
         int i,j,k=0,l=0,n,mlength;
         boolean flag ;
         
         mlength = temp.length;
         
         for(i=0; i<9 ;i++){
             for(j=0; j<9; j++){
                 if(k < mlength){
                     flag = false;
                     for(n=0; n<k; n++){
                         if(temp[n] == temp[k]){
                             flag = true;
                         }
                     }
                     
                     if(!flag){
                     
                         matrix[i][j] = temp[k];
                        System.out.print(matrix[i][j]);
                     }
                     else{
                         j--;
                     }
                     k++;
                 }
                 else{
                     
                     while(isPresent(characters[l],temp)){
                        l++;
                     }
                     matrix[i][j] = characters[l];
                     System.out.print(matrix[i][j]);
                     l++;   
                 } 
             }
             System.out.println();
         }
    }
    
    private boolean isPresent(char t,char [] key){
        int i=0;
        while (i < key.length){
            if(t == key[i]){
                return true;
            }
            i++;
        }
        return false;
    }
    
    private int getLeft(char c){
        int i,j;
        
        for( i=0; i<9; i++){
            for (j=0; j<9; j++){
                if(c == matrix[i][j]){
                    return i;
                }
            }
        }
        return -1;
    }
    
    private int getRight(char c){
        int i,j;
        
        for( i=0; i<9; i++){
            for (j=0; j<9; j++){
                if(c == matrix[i][j]){
                    return j;
                }
            }
        }
        return -1;
    }
}
