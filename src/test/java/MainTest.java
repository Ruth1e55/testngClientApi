import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class MainTest {

    final static Logger logger = Logger.getLogger(String.valueOf(MainTest.class));

    @Test
    public void getApiTest() {
        logger.info("This is a Get test case for https://reqres.in/api/users");

        HttpClient httpClient = HttpClient.newHttpClient();

//        String requestBody = "key1=value1&key2=value2";

        // Create the HttpRequest with the URL and request method
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .GET()
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Get the response code and body
            int responseCode = response.statusCode();
            String responseBody = response.body();
            HttpHeaders responseHeaders = response.headers();

            // Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + responseBody);
            System.out.println("Response Headers: " + responseHeaders);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void postApiTest() {
        logger.info("This is a Post test case for https://reqres.in/api/users");

        HttpClient httpClient = HttpClient.newHttpClient();

        String requestBody = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }""";

        // Create the HttpRequest with the URL and request method
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Get the response code and body
            int responseCode = response.statusCode();
            String responseBody = response.body();
            HttpHeaders responseHeaders = response.headers();

            // Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + responseBody);
            System.out.println("Response Headers: " + responseHeaders);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void putUsers(){
        logger.info("This is a put test case for https://reqres.in/api/users/2");

        HttpClient httpClient = HttpClient.newHttpClient();

        String requestBody = """
                {
                    "name": "morpheus",
                    "job": "zion"
                }""";

        // Create the HttpRequest with the URL and request method
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Get the response code and body
            int responseCode = response.statusCode();
            String responseBody = response.body();
            HttpHeaders responseHeaders = response.headers();

            // Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + responseBody);
            System.out.println("Response Headers: " + responseHeaders);
        } catch (IOException | InterruptedException e) {
            e.getLocalizedMessage();
        }
    }

}
