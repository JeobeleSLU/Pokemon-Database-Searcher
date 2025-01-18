import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessor {
    ArrayList<Pokemon> dataToProcess;
    DataReader reader = new DataReader();

    public DataProcessor(ArrayList<Pokemon> dataToProcess) {
        dataToProcess = reader.fetchDatabase();
    }

    ArrayList<String> getLegendaryOnly(){
        ArrayList<String>temp = new ArrayList<>();
        ArrayList<Pokemon> tempPokemon;
        tempPokemon = (ArrayList) dataToProcess.stream().filter(e -> !e.isLegendary).collect(Collectors.toList());
        return temp;
    }
}
