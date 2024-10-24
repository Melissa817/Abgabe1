package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.example.SendAggregatedData.objectMapper;

public class FetchData {

        // JSON-Parser
        public static List<Rohdaten> fetchDataFromApi() throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/data"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Überprüfen, ob der HTTP-Statuscode erfolgreich ist (200 OK)
            if (response.statusCode() == 200) {
                // JSON-Antwort in eine Liste von Rohdaten parsen
                return objectMapper.readValue(response.body(), new TypeReference<List<Rohdaten>>() {});
            } else {
                // Fehlercode ausgeben und eine leere Liste oder eine entsprechende Fehlermeldung zurückgeben
                System.out.println("Fehler: " + response.statusCode() + " - " + response.body());
                return Collections.emptyList();  // Hier kannst du auch andere Fehlerbehandlungsstrategien verwenden
            }
        }
    }

