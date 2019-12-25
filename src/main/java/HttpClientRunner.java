import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientRunner {
    public static void main(String[] args) throws URISyntaxException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        // request
        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI("http://google.com"))
                .GET()
                .build();

        client.sendAsync(req, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
            System.out.println(response.body());
        });
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
