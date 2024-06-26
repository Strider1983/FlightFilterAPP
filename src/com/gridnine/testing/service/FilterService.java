package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FilterService {
    List<Flight> totalFlightTime(long totalFlightHours);

}
