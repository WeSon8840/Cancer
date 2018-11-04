/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cancer;
import java.io.*;

/**
 *
 * @author Gloria Song
 */
public class Cancer {

    /**
     * @param args the command line arguments
     */
    
    //Make global variables (grid&blobSize) which are accessible
    //from anywhere inside the class FloodIntro
    public static String grid[][];
    public static int blobSize = 0;
    public static boolean cancer;
    public static int num=15;
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("Cancer.txt"));
            String line = null;
            int row = 0, col;
            grid = new String[num][num];
            while ((line = reader.readLine()) != null) {
                for (col = 0; col <num; col++) {
                    grid[row][col] =  Character.toString(line.charAt(col));
            }
            row++;
        }

            displayGrid();
            for (row = 0; row <num; row++) {
                for (col = 0; col <num; col++) {
                    cancer = false;
                    floodFill(row, col);
                if(cancer){
                    blobSize++;
              }
          }
        }
        System.out.println("The file had " + blobSize +
          " cancer spots in it");
        System.out.println("The new grid is:");
        displayGrid();
    }

    public static void floodFill(int row, int col) {
        if (grid[row][col].equals("-")) {
            cancer = true;
            grid[row][col] = " ";
            floodFill(row - 1, col - 1);
            floodFill(row - 1, col);
            floodFill(row - 1, col + 1);
            floodFill(row, col - 1);
            floodFill(row, col + 1);
            floodFill(row + 1, col - 1);
            floodFill(row + 1, col);
            floodFill(row + 1, col + 1);
        }
    }

    public static void displayGrid() {
        String output = "";
        for (int row = 0; row <num; row++) {
          for (int col = 0; col <num; col++) {
            output += grid[row][col];
          }
          output += "\n";
        }
        System.out.println(output);
    }
    
}
