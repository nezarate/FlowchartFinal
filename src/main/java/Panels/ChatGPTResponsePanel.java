package Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import org.json.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChatGPTResponsePanel extends JPanel implements ActionListener {
    private JTextPane outputArea = new JTextPane();
    private JTextField inputField = new JTextField();


    public ChatGPTResponsePanel() {
        setLayout(new BorderLayout());
        // output area
        outputArea.setEditable(false);
        outputArea.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(outputArea);
        //input
        inputField.addActionListener(this);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        //title
        JLabel title = new JLabel("ChatGPT");
        // add to frame
        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String input = inputField.getText();
        String output = "Sorry, something went wrong";
        try {
            output = getChatGPTResponse(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        StyledDocument doc = outputArea.getStyledDocument();
        Style styleRed = outputArea.addStyle("Red", null);
        StyleConstants.setForeground(styleRed, Color.RED);
        Style styleBlue = outputArea.addStyle("Blue", null);
        StyleConstants.setForeground(styleRed, Color.BLUE);
        try {
            doc.insertString(doc.getLength(), "You: " + input + "\n", styleRed);
            doc.insertString(doc.getLength(), "ChatGPT: " + output + "\n", styleBlue);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
        inputField.setText("");
    }
}
//    // This is for testing purposes
//    public static void main(String[] args){
//        JFrame test = new JFrame("ChatGPT");
//        test.setLayout(new GridLayout(1,1));
//        test.add(new ChatGPTResponsePanel());
//        test.setSize(400, 400);
//        test.setVisible(true);
//        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//}

