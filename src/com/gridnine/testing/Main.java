package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.impl.FilterServiceImpl;
import com.gridnine.testing.service.impl.FlightServiceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Flight Filter!");
        FlightServiceImpl flightService = new FlightServiceImpl();

        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flights = flightBuilder.createFlights();

        Long mins = flightService.totalEarthTime(flights.get(5));
        System.out.println("totalEarthTime - " + mins);
        Long minutes = flightService.totalSkyTime(flights.get(5));
        System.out.println("totalSkyTime - " + minutes);
        long total = flightService.totalFlightMinutes(flights.get(5));
        System.out.println("totalFlightMinutes - " + total);

        long seg = Duration.between(flights.get(5).getSegments().get(2).getDepartureDate(), flights.get(5).getSegments().get(2).getArrivalDate()).toMinutes();

        System.out.println(flights.get(5));



    }
}