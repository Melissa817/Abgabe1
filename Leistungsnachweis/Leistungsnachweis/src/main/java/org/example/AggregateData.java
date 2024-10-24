package org.example;
import java.util.List;

public class AggregateData {

    public static double aggregateData(List<Rohdaten> data) {
        return data.stream()
                .mapToDouble(Rohdaten::getWert)
                .average()
                .orElse(0.0);
    }
}
