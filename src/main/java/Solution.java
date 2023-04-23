import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import com.google.gson.Gson;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("./calendar1.json"));
    }
}
