package project3;



import java.util.*;

public class ShipBattle {
private GameHelper helper = new GameHelper();
private ArrayList<Ship> ShipsList = new ArrayList<Ship>(); // spisok korablei
private int numOfGuesses = 0;
 
//----------------------------------------------------------------
private void setUpGame() {
	Ship one = new Ship();
    one.setName("����");
    Ship two = new Ship();
    two.setName("����");
    Ship three = new Ship();
    three.setName("����");
    ShipsList.add(one);
    ShipsList.add(two);
    ShipsList.add(three);
    
    System.out.println("���� ���� �������� ��� �������.");
    System.out.println("����, ����, ����");
    System.out.println("����������� ���������� �� ����������� ����� �����");
    
    for (Ship ShipToSet : ShipsList) { //class myshesi
        ArrayList<String> newLocation = helper.placeShip(3);
        ShipToSet.setLocationCells(newLocation);
    }
}

private void startPlaying() {
    while (!ShipsList.isEmpty()) {
        String userGuess = helper.getUserInput("������ ���: ");
        checkUserGuess(userGuess);
        drawCanvas();
    }
    finishGame();
}

private void checkUserGuess(String userGuess)
{
    numOfGuesses++;
    String result = "����";
    
    for (Ship ShipToTest : ShipsList)
    {
        result = ShipToTest.checkYourself(userGuess);
        if (result.equals("�����"))
        {
            break;
        }
        if (result.equals("�������"))
        {
        	ShipsList.remove(ShipToTest);
            break;
        }
    }
    System.out.println(result);
}

private void finishGame() {
    System.out.println("�� �������� ����!");
    if (numOfGuesses <= 18) {
        System.out.println("� ��� ���� " + numOfGuesses + " �������");
        System.out.println("�� �������!");
    }
    else
    {
        System.out.println("� ��� ���� " + numOfGuesses + " �������.");
        System.out.println("��� ������� �����. � ��� �� ������ �������!");
    }
}

public static void main(String[] args) {
	ShipBattle game = new ShipBattle();
    game.setUpGame();
    game.startPlaying();
    
}

		static int [] canvas = {0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0,
						        0,0,0,0,0,0,0,0,0,0};
		
		
		static void drawCanvas(){
		Ship qwerty = new Ship();
		System.out.println("     |     |     |     |     |     |     |     |     |     |      ");
		for (int i = 0; i < canvas.length; i++) {
		if (i!=0){
		if (i%10==0) {
		System.out.println();
		System.out.println("_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|     ");
		System.out.println("     |     |     |     |     |     |     |     |     |     |     ");
		}
		else
		System.out.print("|");
		}
		
		if (canvas[i]==0) System.out.print("  " + i + "  ");
		if (canvas[i]==1) System.out.print("  X  ");
		
		}
		System.out.println();
		System.out.println("     |     |     |     |     |     ");
		}
		
		public static boolean isDraw() {
		for (int n : canvas) if (n==0) return false;
		return true;
		}









}


