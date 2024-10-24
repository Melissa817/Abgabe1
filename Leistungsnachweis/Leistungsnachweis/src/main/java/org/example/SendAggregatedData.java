package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class SendAggregatedData {

    static final ObjectMapper objectMapper = new ObjectMapper();

    public static void sendAggregatedData(double aggregatedResult) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // Aggregierte Daten in JSON konvertieren
        String json = objectMapper.writeValueAsString(new AggregatedResult(aggregatedResult));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/result"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.statusCode());
    }
}

class AggregatedResult {
    private double aggregatedValue;

    public AggregatedResult(double aggregatedValue) {
        this.aggregatedValue = aggregatedValue;
    }

    public double getAggregatedValue() {
        return aggregatedValue;
    }
}
