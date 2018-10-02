package cryptography;

import java.util.Scanner;

public class Hill {
    private int matrix [][];
    private int matSize;
    Scanner reader = new Scanner(System.in);
    
    private Hill(){
        matrixInit();
    }
    
    void matrixInit(){
        int i,j;
        System.out.println("enter size of key matrix:\n");
        matSize = reader.nextInt();
        
        matrix = new int [matSize][matSize];
        
        System.out.println("Enter values of key matrix:\n");
        
        for(i=0; i<matSize; i++){
            for(j=0; j<matSize; j++){
                matrix[i][j] = reader.nextInt();
            }
        }
    }
}
