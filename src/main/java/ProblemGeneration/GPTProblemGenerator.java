package ProblemGeneration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONArray;
import org.json.JSONObject;

public class GPTProblemGenerator {

    public void generateProblem(int source) throws Exception {
        if (source == 1) {
            String prompt =
                "Create a Java exercise with blanks to fill in. Include a numerated solution without providing the filled-in code. " +
                    "Begin each code block with Exercise:. Display blanks as ....... Precede the solution with Solution: and only include the text in the blanks." +
                    " Ensure there are blanks in the code and there is only one solution for each blank.";


            String problemAndSolution = getChatGPTResponse(prompt);
            /*String problemAndSolution  = "Exercise: \n" +
                "public class .......... { \n" +
                "    public static void main(String[] args) { \n" +
                "        String message = \"....... World!\"; \n" +
                "        System.out.println(message); \n" +
                "    } \n" +
                "} \n" +
                "\n" +
                "Solution: \n" +
                "1. Hello \n" +
                "2. public\n";*/
            // Extract the problem
            int problemStartIndex = problemAndSolution.indexOf("public class");
            int problemEndIndex = problemAndSolution.lastIndexOf("}");
            String problem = problemAndSolution.substring(problemStartIndex, problemEndIndex + 1);


// Extract the solutions
            String[] parts = problemAndSolution.split("\\d+\\.\\s+");
            //ToDo: Find better way of estimating the solution array size.
            String[] solution = new String[10];
            solution[0] = parts[1].trim(); // "Hello"
            solution[1] = parts[2].trim(); // "public"


        }

    }
    private String getChatGPTResponse(String input) throws Exception {
        Path api_key_path = Path.of("src/main/java/resources/api_key");
        final String OPEN_API_KEY = Files.readString(api_key_path);
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + OPEN_API_KEY);

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", input);
        data.put("max_tokens", 4000);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = "";
        String line;
        while ((line = reader.readLine()) != null) {
            response += line;
        }
        reader.close();

        JSONObject responseJson = new JSONObject(response);
        JSONArray choices = responseJson.getJSONArray("choices");
        String text = choices.getJSONObject(0).getString("text");
        return text.trim();
    }
}
