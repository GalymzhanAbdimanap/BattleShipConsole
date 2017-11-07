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
   
    String temp = null;                                // временна€ строка дл€ конкатенации
    int [] coords = new int[shipSize];                  // координаты текущего корабл€
    int attempts = 0;                                  // счетчик текущих попыток
    boolean success = false;                           // нашли подход€щее местоположение?
    int location = 0;                                  // текущее начальное положение
    
    shipCount++;                                        // n корабль дл€ размещении
    int incr = 1;                                      // установливаем горизонтальный инкремент
    if ((shipCount % 2) == 1) {                         // если нечетный  (place vertically)
      incr = gridLength;                               // установливаем вертикальный  инкремент
    }
 
    while ( !success & attempts++ < 200 ) {             // главный пойсковой цикд  (32)
    location = (int) (Math.random() * gridSize);      // случайную стартовую точку
      
    int x = 0;                                        // n позици€ в корабле чтобы разместить
        success = true;                                 // предпологаемый  успешный исход
        while (success && x < shipSize) {                // lищем соседнюю не использованную €чейку
          if (grid[location] == 0) {                    // если еще не используетс€
             coords[x++] = location;                    // сохран€км местоположение
             location += incr;                          // пробуем следующую €чейку
             if (location >= gridSize){                 // вышли из рамки - низ
               success = false;                         // неуд
             }
             if (x>0 & (location % gridLength == 0)) {  // вышли из рамки право
               success = false;                         // неуд
             }
          } else {                                      // нашли уже использ место
                
              success = false;                          // неуд
          }
        }
    }                                                   // end while
 
    int x = 0;                                          // переводим в символьные координаты
    int row = 0;
    int column = 0;
    // System.out.println("\n");
    while (x < shipSize) {
      grid[coords[x]] = 1;                              // помеч€ем в главной сетке как использованные 
      row = (int) (coords[x] / gridLength);             // ѕолучаем значение строки
      column = coords[x] % gridLength;                  // получаем числовое значение столбца
      temp = String.valueOf(alphabet.charAt(column));   // переобразуем его в строковой символ
      
      alphaCells.add(temp.concat(Integer.toString(row)));
      x++;
 
      System.out.print("  coord "+x+" = " + alphaCells.get(x-1));
      
    }
    System.out.println("\n");
    
    return alphaCells;
   }
}
