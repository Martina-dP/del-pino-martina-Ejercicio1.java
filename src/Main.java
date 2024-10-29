import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int rows = 0;
        int columns = 0;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        while (true){
            System.out.print("Introduce el número de filas: ");
            rows = input.nextInt();
            if (rows > 0 ) break;
            else System.out.println("Debes introducir un valor mayor o igual a 0");
        }

        while (true) {
            System.out.print("Introduce el número de columnas: ");
            columns = input.nextInt();
            if (columns > 0 ) break;
            else System.out.println("Debes introducir un valor mayor o igual a 0");
        }

        int[][] gameBoard = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                gameBoard[i][j] = random.nextInt(9) + 1;
            }
        }
        System.out.println(Arrays.deepToString(gameBoard));

        int opcion ;
        boolean end = false;

       while (true) {
           System.out.print("seleccione una opcion: ");
           System.out.print("0 = salir ");
           System.out.print("1 = mostrar matriz ");
           System.out.print("2 = poner bomba ");

           opcion = input.nextInt();

           switch (opcion){
               case 0 : {
                   System.out.println("saliendo...");
                   end = true;
                   return;
               }
               case 1 : {
                   System.out.println("mostrar matriz");
                   break;
               }
               case 2 : {
                   System.out.print("Coordenada x: ");
                    int x = input.nextInt();

                   System.out.print("Coordenada y : ");
                   int y = input.nextInt();

                   if (x >= 0 && x < rows && y >= 0 && y < columns) {
                       int suma = 0;

                       for (int i=0; i < columns; i++ ) {
                           suma = suma + gameBoard[x][i];
                       }
                       for (int m = 0; m < rows; m++) {
                           if (m != x) suma = suma + gameBoard[m][y];
                       }

                   } else {
                       System.out.print("out");
                   }
                   break;
               }
               default: {
                   System.out.println("Opción no válida. Por favor, elige 0, 1 o 2.");
                   break;
               }
           }
       }

    }
}