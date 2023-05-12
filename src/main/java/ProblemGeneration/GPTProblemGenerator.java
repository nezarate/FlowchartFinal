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



    public static CodeProblem getProblemsFromGPT() throws Exception {
            String prompt =
                "Remember this pattern:" +
                    "Exercise:" +
                    "" +
                    "public class StringConcatenation {" +
                    "    public static void main(String[] args) {" +
                    "        String firstName = \"John\";" +
                    "        String lastName = \"Doe\";" +
                    "" +
                    "        String fullName = ......" +
                    "" +
                    "        System.out.println(\"Full Name: \" + fullName);" +
                    "    }" +
                    "}" +
                    "Solution:" +
                    "" +
                    "firstName + \" \" + lastName" +
                    "Create one more excersise after this pattern with a solution and no Explanation";


            String singleProblem = getChatGPTResponse(prompt);
            int problemStartIndex = singleProblem.indexOf("public class");
            int problemEndIndex = singleProblem.lastIndexOf("}");
            String problem = singleProblem.substring(problemStartIndex, problemEndIndex + 1);
            singleProblem = singleProblem.substring(problemEndIndex+1);
            singleProblem =singleProblem.replace("Solution:","");

            // Extract the solutions
            String[] solutions = singleProblem.split("\\d+\\.\\s+");

            for (int j = 0; j < solutions.length; j++) {
                solutions[j] = solutions[j].trim();
            }


            return new CodeProblem(problem,solutions);

    }
    private static String getChatGPTResponse(String input) throws Exception {
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
