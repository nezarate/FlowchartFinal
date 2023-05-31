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

import Handlers.ChatGPTControl;
import org.json.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChatGPTResponsePanel extends JPanel {
    private JTextPane outputArea = new JTextPane();
    private JTextField inputField = new JTextField();
    private ChatGPTControl controlHandler;
    private JButton sendButton;


    public ChatGPTResponsePanel() {
        setLayout(new BorderLayout());
        // output area
        outputArea.setEditable(false);
        outputArea.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(outputArea);
        //input
        sendButton = new JButton("Send");

        //title
        JLabel title = new JLabel("ChatGPT");
        // add to frame
        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);
    }

    public void setControlHandler(ChatGPTControl controlHandler){
        this.controlHandler = controlHandler;
        inputField.addActionListener(this.controlHandler);
        sendButton.addActionListener(this.controlHandler);
    }

    public String getChatGPTResponse(String input) throws Exception {
        Path api_key_path = Path.of("resources/api_key");
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

    public JTextField getInputField(){
        return this.inputField;
    }

    public JTextPane getOutputArea(){
        return this.outputArea;
    }

}

