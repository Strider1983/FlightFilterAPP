package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {
    @Override
    public long totalFlightMinutes(Flight flight) {
        LocalDateTime dep = departureTime(flight);
        LocalDateTime arr = arrivalTime(flight);
        long totalFlightMinutes = Duration.between(dep, arr).toMinutes();
        return totalFlightMinutes;
    }

    @Override
    public long totalTransfers(Flight flight) {
        long totalTransfers = flight.getSegments().size() - 1;
        return totalTransfers;
    }

    @Override
    public long totalSegments(Flight flight) {
        long totalSegments = flight.getSegments().size();
        return totalSegments;
    }

    @Override
    public long totalEarthTime(Flight flight) {
        long totalEarthTime = 0;
        for (int i = 0; i < flight.getSegments().size() - 1; i++) {
            totalEarthTime = totalEarthTime + Duration.between(flight.getSegments().get(i).getArrivalDate(), flight.getSegments().get(i + 1).getDepartureDate()).toMinutes();
        }
        return totalEarthTime;
    }

    @Override
    public long totalSkyTime(Flight flight) {
        long totalSkyTime = 0;
        for (int i = 0; i < flight.getSegments().size(); i++) {
            totalSkyTime = totalSkyTime + Duration.between(flight.getSegments().get(i).getDepartureDate(), flight.getSegments().get(i).getArrivalDate()).toMinutes();

        }
        return totalSkyTime;
    }

    @Override
    public Long maxSegmentMinutes(Flight flight) {
        long [] segmentMinutes = new long[(int) totalSegments(flight)];
        for (int i = 0; i < flight.getSegments().size(); i++) {
            segmentMinutes[i] = Duration.between(flight.getSegments().get(i).getDepartureDate(), flight.getSegments().get(i).getArrivalDate()).toMinutes();
        }
        Long maxSegmentMinutes = Arrays.stream(segmentMinutes).max().getAsLong();
        return maxSegmentMinutes;
    }

    @Override
    public Long minSegmentMinutes(Flight flight) {
        long [] segmentMinutes = new long[(int) totalSegments(flight)];
        for (int i = 0; i < flight.getSegments().size(); i++) {
            segmentMinutes[i] = Duration.between(flight.getSegments().get(i).getDepartureDate(), flight.getSegments().get(i).getArrivalDate()).toMinutes();
        }
        Long minSegmentMinutes = Arrays.stream(segmentMinutes).min().getAsLong();
        return minSegmentMinutes;
    }

    @Override
    public LocalDateTime departureTime(Flight flight) {
        LocalDateTime dep = flight.getSegments().get(0).getDepartureDate();
        return dep;
    }

    @Override
    public LocalDateTime arrivalTime(Flight flight) {
        LocalDateTime arr = flight.getSegments().get(flight.getSegments().size() - 1).getArrivalDate();
        return arr;
    }
}
