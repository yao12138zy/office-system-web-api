package com.springboot.officesystem.service;

import com.springboot.officesystem.model.History;
import com.springboot.officesystem.model.User;
import com.springboot.officesystem.repository.HistoryRepository;
import com.springboot.officesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public History addHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @Override
    public List<History> getHistoriesByUser(Long userId) {
        return historyRepository.getHistoriesByUser(userId);
    }

    @Override
    public List<History> getHistoriesByDate(Date date) {
        return historyRepository.getHistoriesByDate(date);
    }

    @Override
    public History onWork(Date date, Long userId, Date loginTime) {
        History history = historyRepository.getHistoryByUserDate(date,userId);
        if (history == null) { return null; }
        history.setLoginTime(loginTime);
        return historyRepository.save(history);
    }

    @Override
    public History offWork(Date date, Long userId, Date logoutTime) {
        History history = historyRepository.getHistoryByUserDate(date,userId);
        if (history == null) { return null; }
        history.setLogoutTime(logoutTime);
        return historyRepository.save(history);
    }

}
