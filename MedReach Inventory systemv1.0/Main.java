import java.util.Scanner;



public class Main
{

	public static void main(String[] args)
	{
		int choice = 0;
		Inventory inventory = new Inventory();
		Scanner input = new Scanner(System.in);

		do
		{
			// print the menu
			System.out.println("1 to add an item to inventory");
			System.out.println("2 to display current inventory");
			System.out.println("3 add some to an item");
			System.out.println("4 remove some of an item");
			System.out.println("5 to save to file");
			System.out.println("6 to edit inventory");
			System.out.println("7 to quit");

			while (true)
			{

				if (!input.hasNextInt())
				{
					System.out.println("Invalid entry... please enter choice from 1-7");
					input.nextLine();
				} else
				{

					choice = input.nextInt();
					if (choice > 0 && choice < 8)
					{
						break;
					} else
					{
						System.out.println("Invalid Entry... please enter choice from 1-7");
						input.nextLine();
					}
				}
			}
			input.nextLine();

			// switch/case statements for user choices

			switch (choice)
			{
			case 1:
				inventory.addItem(input);

				break;

			case 2:
				System.out.println("MedReach Inc. Inventory:");
				System.out.println(inventory);
				break;

			case 3:

				if (!inventory.updateQuantity(input, true))
				{
					System.out.println("Error...could not add item\n");
				}

				break;

			case 4:

				if (!inventory.updateQuantity(input, false))
				{
					System.out.println("Error...could not remove\n");
				}

				break;

			case 5:
				inventory.openOutputFile(input);
				break;

			case 6:
				inventory.openFile(input);
				break;
			case 7:
				System.out.println("made by Mighty@Pythons");
				break;
			default:
				break;
			}

		} while (choice != 7);
		input.close();
	}

}