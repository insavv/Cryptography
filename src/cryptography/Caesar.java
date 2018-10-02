package cryptography;


public class Caesar {
    
    private Caesar(){}
    
    public static Caesar getInstanceof(){
        return (new Caesar());
    }
    
    
    protected String encryptedText(int key, String message){
        message = message.replaceAll("\\s","");
        char[] messageArray = message.toCharArray();
        char [] enText = new char[messageArray.length];
        int i,j;
        for(i=0; i<messageArray.length; i++){
            j=0;
            while(j<key){
                if(enText[i] == 'z'){
                    enText[i] = 'a';
                    j++;
                }
                enText[i] = (char) (messageArray[i] + 1);
                j++;
            } 
        }
        return (new String(enText));
    }
    
    protected String decryptedText (int key, String message){
        
          char[] messageArray = message.toCharArray();
        char [] deText = new char[messageArray.length];
        int i,j;
        for(i=0; i<messageArray.length; i++){
            j=0;
            while(j<key){
                if(deText[i] == 'a'){
                    deText[i] = 'z';
                    j++;
                }
                deText[i] = (char) (messageArray[i] - 1);
                j++;
            } 
        }
        return (new String (deText));
    }
}
