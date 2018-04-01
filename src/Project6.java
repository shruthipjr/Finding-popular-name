
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project6 {

	public final int NUMNAME = 1000;
	String[] boyNames = new String[NUMNAME];
	String[] girlNames = new String[NUMNAME];	
	int[] boyNum = new int[NUMNAME];
	int[] girlNum = new int[NUMNAME];
	String[] data;

//method to read data from boyNames data file
	public void readBoyData(File file){

		Scanner s;
		try {

			s = new Scanner(file);

			for(int i=0; i<NUMNAME;i++){
				String word = s.nextLine();
				String[] data = word.split(" ");

				boyNames[i] = data[0];
				boyNum[i] =  Integer.parseInt(data[1]);

			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	//method to read data from girlNames data file
	public void readGirlData(File file){
		Scanner s;
		try {

			s = new Scanner(file);

			for(int i=0; i<NUMNAME;i++){
				String word = s.nextLine();
				data = word.split(" ");

				girlNames[i] = data[0];
				girlNum[i] = Integer.parseInt(data[1]);

			}
		} 
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	
//method to search the name in the array
	public void search(String searchName){
		int count=0, counter=0;
		for(int i=0; i< NUMNAME ; i++){
			count++;
			if(searchName.equalsIgnoreCase(girlNames[i])){

				System.out.println(girlNames[i] +" is ranked " + (i+1)  + " in popularity among girl with "+ girlNum[i] +" namings. "  );
				break;

			}
			else{
				continue;

			}

		}

		if(count==1000){
			System.out.println(searchName + " is not ranked among the top 1000 girl names.");
		}

		for(int i=0; i< NUMNAME ; i++){
			counter++;
			if(searchName.equalsIgnoreCase(boyNames[i])){

				System.out.println(boyNames[i] +" is ranked " + (i+1)  + " in popularity among boy with "+ boyNum[i] +" namings. "  );
				break;

			}
		}

		if(counter==1000){
			System.out.println(searchName + " is not ranked among the top 1000 boy names.");
		}

	}

	//main method to test the code
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File boy = new File("C:\\Users\\Shruthi\\Desktop\\boynames.txt");
		File girl= new File("C:\\Users\\Shruthi\\Desktop\\girlnames.txt");

		System.out.println("Enter a name");
		Scanner in = new Scanner(System.in);
		String searchName = in.next();

		Project6 obj= new Project6();
		obj.readGirlData(girl);  
		obj.readBoyData(boy);
		obj.search(searchName);
	}

}
