package tools;

public class Determinent {
    int matrix [][];
    int size2(int m , int n){
        return (matrix [m][n] * matrix[m-1][n-1]) - (matrix [m][n-1] * matrix [m-1][n]);
    }
}
