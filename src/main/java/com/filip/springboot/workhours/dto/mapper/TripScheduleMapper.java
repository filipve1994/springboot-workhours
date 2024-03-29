package com.filip.springboot.workhours.dto.mapper;

import com.filip.springboot.workhours.dto.model.bus.TripScheduleDto;
import com.filip.springboot.workhours.model.bus.Trip;
import com.filip.springboot.workhours.model.bus.TripSchedule;

/**
 * Created by Arpit Khandelwal.
 */
public class TripScheduleMapper {
    public static TripScheduleDto toTripScheduleDto(TripSchedule tripSchedule) {
        Trip tripDetails = tripSchedule.getTripDetail();
        return new TripScheduleDto()
                .setId(tripSchedule.getId())
                .setTripId(tripDetails.getId())
                .setBusCode(tripDetails.getBus().getCode())
                .setAvailableSeats(tripSchedule.getAvailableSeats())
                .setFare(tripDetails.getFare())
                .setJourneyTime(tripDetails.getJourneyTime())
                .setSourceStop(tripDetails.getSourceStop().getName())
                .setDestinationStop(tripDetails.getDestStop().getName());
    }
}
