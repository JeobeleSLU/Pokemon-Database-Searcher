import java.net.Socket;
import java.io.*;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    DataReader dataReader;

    public ClientHandler(Socket socket, DataReader reader) {
        this.clientSocket = socket;
        this.dataReader = reader;
    }


    @Override
    public void run() {
        //Do something
        try {
            ArrayList<Pokemon> pokemons = new ArrayList<>();
                    pokemons.addAll(dataReader.fetchDatabase());
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Welcome to the server you're connected via" +clientSocket.getInetAddress().toString()
            +"port: " + clientSocket.getPort());
            out.println("Good bye!");
            boolean isProcessing = true;
            while (isProcessing){
                isProcessing = getUserResponse(input,out,pokemons);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean getUserResponse(BufferedReader input, PrintWriter out, ArrayList<Pokemon> pokemons) throws IOException {
        String temp;
        out.println("Press 1 if you want to know who is the number 1 pokemon attacker");
        temp= input.readLine();
        if (temp.equals("1")){
            out.println("Number 1 is ");
            out.println("Good bye");
            pokemons.forEach(e->out.println(e.getName()) );
        }
        return false;
    }
}
