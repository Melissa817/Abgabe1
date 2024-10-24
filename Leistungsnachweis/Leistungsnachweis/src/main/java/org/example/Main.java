package org.example;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // 1. Rohdaten von der API abrufen
            List<Rohdaten> rohdaten = FetchData.fetchDataFromApi();

            // 2. Daten aggregieren
            double aggregatedResult = AggregateData.aggregateData(rohdaten);

            // 3. Aggregiertes Ergebnis an das Referenzsystem senden
            SendAggregatedData.sendAggregatedData(aggregatedResult);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

