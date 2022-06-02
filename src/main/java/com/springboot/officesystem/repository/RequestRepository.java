package com.springboot.officesystem.repository;

import com.springboot.officesystem.model.History;
import com.springboot.officesystem.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {

    @Query("SELECT r FROM Request r WHERE r.requestReceiver.userId = :rid")
    public List<Request> getRequestByReceiver(@Param("rid") Long rid);

    @Query("SELECT r FROM Request r WHERE r.requestSender.userId = :sid")
    public List<Request> getRequestBySender(@Param("sid") Long sid);



}
