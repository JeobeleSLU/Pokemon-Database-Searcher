import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    File dataSheet;

    public DataReader() {
         dataSheet = new File("./Resources/Pokemon.csv/");
    }

    ArrayList<String> fetchDatabase(){
        ArrayList<String> temp = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(dataSheet);
            scanner.nextLine();
            while (scanner.hasNextLine()){
                temp.add(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("Data base not fetched");
            e.printStackTrace();
        }
        return null;
    }

    private String createPokemonFromDatabase(String line) {
        return line;
    }

}
