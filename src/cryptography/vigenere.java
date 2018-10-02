package cryptography;

public class vigenere {
    private final char matrix [][];
    
    private vigenere(){
        matrix = new char [26][26];
        matrixInit(matrix);
    }
    public static vigenere getInstanceof(){
        return (new vigenere());
    }
    private void matrixInit(char matrix[][]){
        int i,j;
        char c = 'a';
        
        for (i=0; i<26; i++){
            for(j=0; j<26; j++){
                matrix[i][j] = c;
                if(c == 'z'){
                    c = 'a';
                }
                else{
                    c++;
                }
                System.out.print(matrix[i][j]);
            }
            c++;
            System.out.println();
        }
    }
    protected String encrypt(String key, String message){
        message = message.replaceAll("\\s","");
        char keyArray [] = key.toCharArray();
        char messageArray [] = message.toCharArray();
        char enText [] = new char [messageArray.length];
        int i;
        
        for(i=0; i<messageArray.length; i++){
            
            enText[i] = matrix [keyArray[i%keyArray.length] - 'a'][messageArray[i] - 'a'];
        }
        return (new String(enText));
    }
    
    protected String decrypt(String key, String message){
        char keyArray [] = key.toCharArray();
        char messageArray [] = message.toCharArray();
        int i,j;
        char deText[] = new char[messageArray.length];
        
        for(i=0; i<messageArray.length; i++){
            for(j=0; j<26;j++){
                if( messageArray[i] == matrix [keyArray[i%keyArray.length] - 'a'][j]){
                    deText[i]  = matrix [0][j];
                }
            }
        }
        return (new String(deText));
    }
}
