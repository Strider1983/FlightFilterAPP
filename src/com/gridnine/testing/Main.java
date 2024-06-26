package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightBuilder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Flight Filter!");

        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flights = flightBuilder.createFlights();

        Flight flight = flights.get(1);
        List<Segment> segments = flight.getSegments();
        Segment segment1 = segments.get(0);
        Segment segmentLast = segments.get(segments.size() - 1);
        LocalDateTime start = segment1.getDepartureDate();
        LocalDateTime finish = segmentLast.getArrivalDate();
        Duration duration = Duration.between(start, finish);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours()%24);
        System.out.println(duration.toMinutes()%60);

        LocalDateTime dep = flights.get(1).getSegments().get(0).getDepartureDate();
        LocalDateTime arr = flights.get(1).getSegments().get(flights.get(1).getSegments().size() - 1).getArrivalDate();
        Duration duration2 = Duration.between(dep, arr);

        System.out.println(duration2.toDays());
        System.out.println(duration2.toHours()%24);
        System.out.println(duration2.toMinutes()%60);
    }
}