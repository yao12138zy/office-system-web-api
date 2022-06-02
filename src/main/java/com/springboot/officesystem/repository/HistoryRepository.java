package com.springboot.officesystem.repository;

import com.springboot.officesystem.model.History;
import com.springboot.officesystem.model.HistoryPK;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

@Repository
public interface HistoryRepository extends JpaRepository<History, HistoryPK> {


    @Query("SELECT h FROM History h WHERE h.historyPK.historyUserId = :id")
    public List<History> getHistoriesByUser(@Param("id") Long userId);

    @Query("SELECT h FROM History h WHERE h.historyPK.loginDate= :date")
    public List<History> getHistoriesByDate(@Param("date")Date date);

    @Query("SELECT h FROM History h WHERE h.historyPK.loginDate = :date and h.historyPK.historyUserId = :id")
    public History getHistoryByUserDate (@Param("date")Date date, @Param("id")Long id);



}
