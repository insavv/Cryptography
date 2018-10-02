package cryptography;

import java.util.Arrays;
import java.util.Random;
import tools.Tools;

public class RSA {
    
    private int p=0,q=0,n,e,d;
    private int [] alphabet = new int[26];
    Random ran = new Random();
    Tools t = Tools.getInstance();
    
    private RSA(){
        while(!t.millerRabin(p)){
            p = ran.nextInt(250) + (100);
        }
        while(!t.millerRabin(q)){
            q = ran.nextInt(250) + (100);
        }
        n = p * q;
        generatePublicKey();
        generatePrivateKey();
    }
    
    public static RSA getInstance(){
        return new RSA();
    }
    
   private void generatePublicKey(){
       
       
       do{
           e = ran.nextInt(((p-1)*(q-1))-1) + 1;
       }while(t.euclidean(((p-1)*(q-1)), e) != 1);
       System.out.println("public key: (" + n + "," + e + ")");
   }
    
   private void generatePrivateKey(){
       d = t.mulInverse(e, ((p-1)*(q-1)));
       System.out.println("private key :" + d);
   }
   
   public long[] encrypt(String message){
        message = message.replaceAll("\\s","");
        message = message.toLowerCase();
       int i, k, a, flag;
       
       for(i=0; i<26; i++){
       
           do{
               flag = 0;
              // System.out.println(n);
               alphabet[i] = ran.nextInt(1000);
           
               for(k = 0; k < i; k++){
                   if( alphabet[i] == alphabet[k]) flag = 1;
               }
           }while(flag == 1);
       }
       System.out.println(Arrays.toString(alphabet));
       char[] messageArr = message.toCharArray();
       long[] encryText = new long[messageArr.length];
       
       for (i = 0; i<messageArr.length; i++){
           encryText[i] = t.fastMod(alphabet[(messageArr[i] - 97)], e, n);
       }
       return encryText;
   }
   
   public String decrypt(long [] encryText){
      int  i,j;
      long k;
      char [] message = new char [encryText.length];
      
      for (i = 0; i < encryText.length; i++)
      {
          k = t.fastMod(encryText[i], d, n);
          System.out.print(k+" ");
          for(j = 0; j < 26; j++){
              
              if( k == alphabet[j]){
                  
                  message[i] = (char)(j + 97);
              }
          }
      }
       System.out.println(Arrays.toString(message));
      return new String(message);
   }
   
   public static void main(String[] arg){
      
       long [] i;
       int j=0,count=0;
     
      // while (j <= 10000){
            RSA r = RSA.getInstance();
       
           i = r.encrypt("its me mario");
       
       
           System.out.println(Arrays.toString(i));
       
       
           System.out.println(r.decrypt(i));
           
           //if (!r.decrypt(i).equals("itsmemario")) count++;
         //  j++;
       //}
       
       //System.out.println(100-(count*100/10000));
   }
}
