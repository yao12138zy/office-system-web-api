package com.springboot.officesystem.service;

import com.springboot.officesystem.model.History;
import com.springboot.officesystem.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HistoryService {

    public History addHistory(History history);
    public List<History> getAllHistory();
    public List<History> getHistoriesByUser(Long userId);
    public List<History> getHistoriesByDate(Date date);
    public History onWork(Date date, Long userId, Date loginTime);
    public History offWork(Date date, Long userId, Date logoutTime);

    public Boolean historyUserIdExist(Long id);

}
