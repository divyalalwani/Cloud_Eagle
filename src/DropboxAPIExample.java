import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DropboxAPIExample {
    private static final String ACCESS_TOKEN = System.getenv("DROPBOX_ACCESS_TOKEN");
    
    public static void main(String[] args) throws Exception {
        // Dropbox API endpoint for listing team members
        URL url = new URL("https://api.dropboxapi.com/2/team/members/list_v2");
        // Establish HTTP connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Add required headers for authorization and content type
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Request body: specify limit for the number of members returned
        String jsonInput = "{\"limit\": 5}";
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Read the API response from the input stream
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String responseLine;
        StringBuilder response = new StringBuilder();
        
        // Append each line of the response to a StringBuilder
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        // Print the raw JSON response
        System.out.println(response.toString());
    }
}
