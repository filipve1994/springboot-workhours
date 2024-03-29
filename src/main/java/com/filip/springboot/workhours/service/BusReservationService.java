package com.filip.springboot.workhours.service;

import com.filip.springboot.workhours.dto.model.bus.AgencyDto;
import com.filip.springboot.workhours.dto.model.bus.BusDto;
import com.filip.springboot.workhours.dto.model.bus.StopDto;
import com.filip.springboot.workhours.dto.model.bus.TicketDto;
import com.filip.springboot.workhours.dto.model.bus.TripDto;
import com.filip.springboot.workhours.dto.model.bus.TripScheduleDto;
import com.filip.springboot.workhours.dto.model.user.UserDto;

import java.util.List;
import java.util.Set;

/**
 * Created by Arpit Khandelwal.
 */
public interface BusReservationService {

    //Stop related methods
    Set<StopDto> getAllStops();

    StopDto getStopByCode(String stopCode);

    //Agency related methods
    AgencyDto getAgency(UserDto userDto);

    AgencyDto addAgency(AgencyDto agencyDto);

    AgencyDto updateAgency(AgencyDto agencyDto, BusDto busDto);

    //Trip related methods
    TripDto getTripById(String tripID);

    List<TripDto> addTrip(TripDto tripDto);

    List<TripDto> getAgencyTrips(String agencyCode);

    List<TripDto> getAvailableTripsBetweenStops(String sourceStopCode, String destinationStopCode);

    //Trips Schedule related methods
    List<TripScheduleDto> getAvailableTripSchedules(String sourceStopCode, String destinationStopCode, String tripDate);

    TripScheduleDto getTripSchedule(TripDto tripDto, String tripDate, boolean createSchedForTrip);

    //Ticket related method
    TicketDto bookTicket(TripScheduleDto tripScheduleDto, UserDto passenger);

}
