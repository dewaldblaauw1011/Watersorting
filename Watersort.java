import java.util.Random; //Dewald Blaauw 34223150 Exercise 1,2,3 for CMPG323
import java.util.Scanner;
public abstract class Watersort extends MyArrayList
{
	static int totalBottles = 5;
	
	static Character green   = new Character('g');
	static Character red = new Character('r');
	static Character blue  = new Character('b');
	
	
	static StackAsMyArrayList<Character>[] bottles = new StackAsMyArrayList[totalBottles];
	
	public static void main(String[]args)
	{
		Random rand = new Random();
		int randomNr; 
		System.out.println("\nTest Bottles");
		StackAsMyArrayList<Character> testBottle = new StackAsMyArrayList<Character>();
		
		testBottle.push(green);
		testBottle.push(red);
		testBottle.push(blue);
		
		System.out.println("\nBottle is filled with " + testBottle.getStackSize() + " colours");
		
		System.out.println("\nBottle is not mixed: " + testBottle.checkStackUniform());
	
		System.out.println("\nFull Test\n");
		StackAsMyArrayList<Character> bottleOne = new StackAsMyArrayList<Character>();
		StackAsMyArrayList<Character> bottleTwo = new StackAsMyArrayList<Character>();
		StackAsMyArrayList<Character> bottleThree = new StackAsMyArrayList<Character>();
		StackAsMyArrayList<Character> bottleFour = new StackAsMyArrayList<Character>();
		StackAsMyArrayList<Character> bottleFive = new StackAsMyArrayList<Character>();
		
		/*	bottleTwo.push(blue);
		bottleTwo.push(red);
		bottleTwo.push(green);
		bottleTwo.push(red);
		
		bottleThree.push(red);
		bottleThree.push(green);
		bottleThree.push(blue);
		bottleThree.push(green);
		
		bottleFour.push(red);
		bottleFour.push(green);
		
		bottleFive.push(red);
		bottleFive.push(blue);*/
		
		
		bottles[0] = bottleOne;
		bottles[1] = bottleTwo;
		bottles[2] = bottleThree;
		bottles[3] = bottleFour;
		bottles[4] = bottleFive;
		
		for (int i =0; i<4; i++ )// Push color red to different bottles 4 times.
		{
			randomNr = rand.nextInt(5);
			
			if(bottles[randomNr] == bottleOne && bottleOne.getStackSize() <4)//Bottle1 Fill
			{
				bottleOne.push(red);
			}
			else if(bottles[randomNr] == bottleTwo && bottleTwo.getStackSize() <4)//Bottle2 Fill
				{
					bottleTwo.push(red);
				}
			else if(bottles[randomNr] == bottleThree && bottleThree.getStackSize() <4)//Bottle3 Fill
				{
					bottleThree.push(red);
				}				
				else if(bottles[randomNr] == bottleFour && bottleFour.getStackSize() <4)//Bottle4 Fill
					{
						bottleFour.push(red);
					}
					else if(bottles[randomNr] == bottleFive && bottleFive.getStackSize() <4)//Bottle5 Fill
					{
						bottleFive.push(red);
					}
		}
		
		for (int i =0; i<4; i++ )// Push color green to different bottles 4 times.
		{
			randomNr = rand.nextInt(5);
			
			if(bottles[randomNr] == bottleOne && bottleOne.getStackSize() <4)//Bottle1 Fill
			{
				bottleOne.push(green);
			}
			else if(bottles[randomNr] == bottleTwo && bottleTwo.getStackSize() <4)//Bottle2 Fill
				{
					bottleTwo.push(green);
				}
			else if(bottles[randomNr] == bottleThree && bottleThree.getStackSize() <4)//Bottle3 Fill
				{
					bottleThree.push(green);
				}				
				else if(bottles[randomNr] == bottleFour && bottleFour.getStackSize() <4)//Bottle4 Fill
					{
						bottleFour.push(green);
					}
					else if(bottles[randomNr] == bottleFive && bottleFive.getStackSize() <4)//Bottle5 Fill
						{
							bottleFive.push(green);
						}
		}
		
		for (int i =0; i<4; i++ )// Push color blue to different bottles 4 times.
		{
			randomNr = rand.nextInt(5);
			
			if(bottles[randomNr] == bottleOne && bottleOne.getStackSize() <4 )//Bottle1 Fill
			{
				bottleOne.push(blue);
			}
			else if(bottles[randomNr] == bottleTwo && bottleTwo.getStackSize() <4)//Bottle2 Fill
				{
					bottleTwo.push(blue);
				}
			else if(bottles[randomNr] == bottleThree && bottleThree.getStackSize() <4)//Bottle3 Fill
				{
					bottleThree.push(blue);
				}				
				else if(bottles[randomNr] == bottleFour && bottleFour.getStackSize() <4)//Bottle4 Fill
					{
						bottleFour.push(blue);
					}
					else if(bottles[randomNr] == bottleFive && bottleFive.getStackSize() <4)//Bottle5 Fill
					{
						bottleFive.push(blue);
					}
		}
		
		
		showAll();

		Scanner s = new Scanner(System.in);
		boolean bSame = true;
		int sourceBottle;
		int targetBottle;
		while(!solved(bottles))
		{
			System.out.println("Please choose a source bottle where you want to take out a color: ");
			sourceBottle = s.nextInt();
			System.out.println("Please choose a target bottle where you want to shift the color to:");
			targetBottle = s.nextInt();
			
			if(sourceBottle < 0 || sourceBottle > 4)
				System.out.println("\nInvalid source bottle.");
			else if (targetBottle < 0 || targetBottle > 4)
				System.out.println("\nInvalid target bottle. ");
			else if (bottles[sourceBottle].getStackSize() == 0 )
				System.out.println("\nThe source bottle is empty. Please choose another source bottle.");
			else if (bottles[targetBottle].getStackSize() == 4)
			{
				System.out.println("\nThe target bottle is already full. Please choose another target bottle.");
			}
			else if ((bottles[sourceBottle].peek() != bottles[targetBottle].peek()) && (bottles[targetBottle].getStackSize() > 0))
			{
				System.out.println("\nSource and target bottles' colors doesn't match.");
			}
			else
			{
				bottles[targetBottle].push(bottles[sourceBottle].pop());
				while (bSame)
				{
					if ((bottles[targetBottle].peek() == bottles[sourceBottle].peek()) && (bottles[targetBottle].getStackSize() != 4))
					{
						bottles[targetBottle].push(bottles[sourceBottle].pop());
					}
					else
					{
						bSame = false;
					}
				}
				bSame = true;
				showAll();
			}
		}
		if (solved(bottles))
			System.out.println("\n Congratulations! You have solved the watersort puzzle!");
	}
	
	
	public static void showAll()
	{
		for(int i = 0; i < totalBottles; i++)
		{
			System.out.println("Bottle[" + (i) + "]: " + bottles[i].toString());
		}
	}
	
	  public static boolean solved(StackAsMyArrayList bottles[]) {
	 for (int i=0; i<=4; i++)
	 {
		if (bottles[i].getStackSize() !=0 && bottles[i].getStackSize() != 4)
		{
			return false;
		}
		if (bottles[i].checkStackUniform() == false)
		{
			return false;
		}
	 }
		return true	; 
  }
}