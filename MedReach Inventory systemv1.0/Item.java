import java.util.ArrayList;
import java.util.Scanner;



public class Item
{
	private int itemCode;
	private String itemName;
	private int itemQuantityInStock;
	private int itemPrice;

	public Item() {
		itemCode = 0;
		itemName = "";
		itemQuantityInStock = 0;
		itemPrice = 0;
	}

	public Item(int itemCode, String itemName, int itemQuantityInStock, int itemPrice) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemQuantityInStock = itemQuantityInStock;
		this.itemPrice = itemPrice;
	}

	public boolean addItem(Scanner input)
	{

		while (true)
		{
			System.out.print("Enter the code for the item: ");

			if (!input.hasNextInt())
			{
				System.out.print("Invalid code... please enter integer greater than 0\n");

				input.nextLine();
			} else
			{
				itemCode = input.nextInt();

				if (itemCode > 0)
				{
					break;
				}

				else
				{
					System.out.print("Invalid code... please enter integer greater than 0\n");
					input.nextLine();
				}

			}

		}

		input.nextLine();

		while (itemName.replaceAll(" ", "").equals(""))
		{
			System.out.print("Enter the name for the item: ");
			if (input.hasNextLine())
			{
				itemName = input.nextLine();
			}
		}

		while (true)
		{
			System.out.print("Enter the American Inventory: ");

			if (!input.hasNextInt())
			{
				System.out.print("Invalid quantity... please enter integer greater than 0\n");

				input.nextLine();
			} else
			{
				itemQuantityInStock = input.nextInt();

				if (itemQuantityInStock >= 0)
				{
					break;
				}

				else
				{
					System.out.print("Invalid quantity... please enter integer greater than 0\n");
					input.nextLine();
				}

			}

		}

		input.nextLine();

		while (true)
		{
			System.out.print("Tanzanian Inventory: ");

			if (!input.hasNextInt())
			{
				System.out.print("Invalid price... please enter float greater than 0\n");

				input.nextLine();
			} else
			{
				itemPrice = input.nextInt();

				if (itemPrice >= 0)
				{
					break;
				}

				else
				{
					System.out.print("Invalid price... please enter float greater than 0\n");
					input.nextLine();
				}

			}

		}
		return true;
	}

	public String toString()
	{
		String name = "";
		String price = (" Tanzanian Inventory:"+ itemPrice);
		name = "Item: " + itemCode + " " + itemName + "          " +"American Inventory:"+ ""+itemQuantityInStock +"      "+ price+"      "+" Total:"+(itemPrice+itemQuantityInStock);
		return name;
	}

	public boolean updateItem(int amount)
	{
		if (amount < 0)
		{
			if (Math.abs(amount) <= itemQuantityInStock)
			{
				itemQuantityInStock += amount;
				return true;
			} else
			{
				return false;
			}
		} else
		{
			itemQuantityInStock += amount;
			return true;
		}

	}

	public boolean isEqual(Item item)
	{
		if (item.itemCode == this.itemCode)
		{
			return true;
		}
		return false;
	}

	public boolean inputCode(Scanner input)
	{
		System.out.print("Enter valid item code: ");
		if (input.hasNextInt())
		{
			itemCode = input.nextInt();
			return true;
		} else
		{
			input.nextLine();
		}

		return false;
	}

	public boolean checkCode(int[] array, int lengthArray, int itemsLength, ArrayList<Item> item)
	{
		int count = 0;
		for (int i = 0; i < itemsLength; i++)
		{

			for (int j = 0; j < lengthArray; j++)
			{
				if (item.get(i).itemCode == array[j])
				{
					count++;
				}
			}

		}
		if (count == lengthArray)
		{
			return true;
		}

		return false;
	}

	public int compareInputCode(Item item)
	{
		if (this.itemCode < item.itemCode)
			return -1;
		else if (this.itemCode > item.itemCode)
			return 1;
		else
			return 0;
	}

	public String toWriteFile()
	{
		return itemCode + " " + itemName + " " + itemQuantityInStock + " " + itemPrice + " ";
	}

}