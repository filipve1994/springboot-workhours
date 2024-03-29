package com.filip.springboot.workhours.repository.workhours;

import com.filip.springboot.workhours.model.workhours.WorkMonth;
import com.filip.springboot.workhours.model.workhours.Workday;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkMonthRepository extends MongoRepository<WorkMonth, String> {

    @Query(value = "{'id' : ?0}")
    WorkMonth findByIdQuery(String id);


}
