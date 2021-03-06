package project3;

import java.io.*;
import java.util.*;
 
public class GameHelper {
 
  private static final String alphabet = "abcdefghij";
  private int gridLength = 10;
  private int gridSize = 100;
  private int [] grid = new int[gridSize];
  private int shipCount = 0;
 
 
  public String getUserInput(String prompt) {
     String inputLine = null;
     System.out.print(prompt + "  ");
     try {
       BufferedReader is = new BufferedReader(
     new InputStreamReader(System.in));
       inputLine = is.readLine();
       if (inputLine.length() == 0 )  return null; 
     } catch (IOException e) {
       System.out.println("IOException: " + e);
     }
     return inputLine.toLowerCase();
  }
 
  
  
 public ArrayList<String> placeShip(int shipSize) {                 
    ArrayList<String> alphaCells = new ArrayList<String>();
   
    String temp = null;                                // ��������� ������ ��� ������������
    int [] coords = new int[shipSize];                  // ���������� �������� �������
    int attempts = 0;                                  // ������� ������� �������
    boolean success = false;                           // ����� ���������� ��������������?
    int location = 0;                                  // ������� ��������� ���������
    
    shipCount++;                                        // n ������� ��� ����������
    int incr = 1;                                      // ������������� �������������� ���������
    if ((shipCount % 2) == 1) {                         // ���� ��������  (place vertically)
      incr = gridLength;                               // ������������� ������������  ���������
    }
 
    while ( !success & attempts++ < 200 ) {             // ������� ��������� ����  (32)
    location = (int) (Math.random() * gridSize);      // ��������� ��������� �����
      
    int x = 0;                                        // n ������� � ������� ����� ����������
        success = true;                                 // ��������������  �������� �����
        while (success && x < shipSize) {                // l���� �������� �� �������������� ������
          if (grid[location] == 0) {                    // ���� ��� �� ������������
             coords[x++] = location;                    // ��������� ��������������
             location += incr;                          // ������� ��������� ������
             if (location >= gridSize){                 // ����� �� ����� - ���
               success = false;                         // ����
             }
             if (x>0 & (location % gridLength == 0)) {  // ����� �� ����� �����
               success = false;                         // ����
             }
          } else {                                      // ����� ��� ������� �����
                
              success = false;                          // ����
          }
        }
    }                                                   // end while
 
    int x = 0;                                          // ��������� � ���������� ����������
    int row = 0;
    int column = 0;
    // System.out.println("\n");
    while (x < shipSize) {
      grid[coords[x]] = 1;                              // �������� � ������� ����� ��� �������������� 
      row = (int) (coords[x] / gridLength);             // �������� �������� ������
      column = coords[x] % gridLength;                  // �������� �������� �������� �������
      temp = String.valueOf(alphabet.charAt(column));   // ������������ ��� � ��������� ������
      
      alphaCells.add(temp.concat(Integer.toString(row)));
      x++;
 
      System.out.print("  coord "+x+" = " + alphaCells.get(x-1));
      
    }
    System.out.println("\n");
    
    return alphaCells;
   }
}
