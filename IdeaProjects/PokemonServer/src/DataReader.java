import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    File dataSheet;

    public DataReader() {
        dataSheet = new File("./Resources/Pokemon.csv/");
    }

    ArrayList<Pokemon> fetchDatabase() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(dataSheet);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                temp.add(createPokemonFromDatabase(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data base not fetched");
            e.printStackTrace();
        }
       return temp;
    }

    private Pokemon createPokemonFromDatabase(String line) {
        //number,name,type1,type2,total,hp,attack,defense,sp_attack,sp_defense,speed,generation,legendary
        String[] attributes = line.split(",", -1);
        int number = Integer.parseInt(attributes[0]);
        String name = attributes[1];
        String primaryType = attributes[2];
        String secondaryType;
        if (attributes[3].length() != 0) {
            secondaryType = attributes[3];

        } else {
            secondaryType = "NULL";
        }
        int totalHP = Integer.parseInt(attributes[4]);
        int attack = Integer.parseInt(attributes[5]);
        int defense = Integer.parseInt(attributes[6]);
        int spAttack = Integer.parseInt(attributes[7]);
        int spDefense = Integer.parseInt(attributes[8]);
        int speed = Integer.parseInt(attributes[9]);
        int generation = Integer.parseInt(attributes[10]);
        boolean isLegendary = Boolean.parseBoolean(attributes[11]);
        //Create pokemon
        Pokemon temp = new Pokemon(number, name, primaryType, secondaryType,
                totalHP, attack, defense, spAttack, spDefense, speed, generation, isLegendary);
        return temp;

    }
}

