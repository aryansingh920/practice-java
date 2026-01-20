
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class APICall {
    public static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    // asynchronous function
    @SuppressWarnings("CallToPrintStackTrace")
    public static CompletableFuture<String> getAsync() {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", APIConstants.BASE_URL, APIConstants.POSTS_BY_ID)))
                .GET()
                .build();

        return HTTP_CLIENT
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

    }

    // public static void main(String[] args) {
    //     System.out.println("1");
    //     getAsync().thenAccept(body -> {
    //         System.out.printf("Body : %s\n", body);
    //     }).join();
    // System.out.println("2");

    // }

    public static void main(String[] args) {
        System.out.println("Something 1");

        getAsync().thenAccept(body -> System.out.printf("Body : %s%n", body));

        System.out.println("Something 2");

        // keep JVM alive just for demo purposes
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
    }

}


