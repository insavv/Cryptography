package cryptography;

import java.util.Scanner;

public class Cryptography {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Scanner readint = new Scanner(System.in);
        String message; 
        String text;
        int i;
        
        System.out.println("Welcome to Cryptology\n");
        System.out.println("\nChoose your Cipher:");
        System.out.println("\n1)\tCaesar");
        System.out.println("\n2)\tPlayfair");
        System.out.println("\n3)\tVegenere");
        
        i = readint.nextInt();
        
        switch(i){
            case 1:
                int key;
                Caesar cipher = Caesar.getInstanceof() ;
        
                System.out.println("\nEnter your message to be encrypted:");
                message = reader.nextLine();
        
                System.out.println("\nEnter key:");
                key = readint.nextInt();
                text = cipher.encryptedText(key, message);
                System.out.println("\nEncrypted message:\t"+text);
                text = cipher.decryptedText(key, text);
                System.out.println("\nDecrypted message:\t"+text);
                break;
            case 2:
                String keyText;
                Playfair cipherpf = Playfair.getInstanceof() ;
        
                System.out.println("Enter your message to be encrypted:");
                message = reader.nextLine();
        
                System.out.println("Enter key:");
                keyText = reader.nextLine();
                text = cipherpf.encrypt(keyText, message);
                System.out.println("\nEncrypted message:\t"+text);
                text = cipherpf.decrypt(text);
                System.out.println("\nDecrypted message:\t"+text);
                break;
            
            case 3: 
                 String keyTextv;
                vigenere cipherv = vigenere.getInstanceof() ;
        
                System.out.println("\nEnter your message to be encrypted:");
                message = reader.nextLine();
        
                System.out.println("\nEnter key:");
                keyTextv = reader.nextLine();
                text = cipherv.encrypt(keyTextv, message);
                System.out.println("\nEncrypted message:\t"+text);
                text = cipherv.decrypt(keyTextv,text);
                System.out.println("\nDecrypted message:\t"+text);
                break;
            
             default:
                 System.out.println("\nInvalid choice!");
                 break;
        }
        
    }
    
}
