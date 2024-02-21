import java.util.Scanner;



public class PurchasedItem extends Item
{
	private String supplierName;

	public PurchasedItem() {
		super();
		supplierName = "";
	}

	public PurchasedItem(int itemCode, String itemName, int quantity, int price, String supplierName) {
		super(itemCode, itemName, quantity, price);
		this.supplierName = supplierName;
	}

	@Override
	public boolean addItem(Scanner input)
	{
		if (super.addItem(input))
		{

			input.nextLine();

			
				
				
					supplierName = " ";
					System.out.println();
				
			
			return true;
		}
		return false;
	}

	@Override
	public String toString()
	{
		String name = "";
		name = " " + supplierName;
		return super.toString() + name;
	}

	@Override
	public String toWriteFile()
	{
		return "p " + super.toWriteFile() + supplierName;
	}
}