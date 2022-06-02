package com.springboot.officesystem.controller;

import com.springboot.officesystem.model.History;
import com.springboot.officesystem.model.HistoryPK;
import com.springboot.officesystem.model.User;
import com.springboot.officesystem.repository.HistoryRepository;
import com.springboot.officesystem.service.HistoryService;
import com.springboot.officesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public History addHistory(@RequestBody History history){
        User user = userService.getUserById(history.getHistoryPK().getHistoryUserId());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user id is not found");
        }
        History newHistory = history;
        history.setUser(user);
        history.setHistoryPK(history.getHistoryPK());
        newHistory.setLoginTime(history.getLoginTime());
        newHistory.setLogoutTime(history.getLogoutTime());
        return historyService.addHistory(newHistory);
    }

    @GetMapping("/getAll")
    public List<History> getAllHistories(){
        return historyService.getAllHistory();
    }

    @GetMapping("/getHistories/id/{id}")
    public List<History> getHistoriesByUser(@PathVariable("id") Long id){
        Boolean exist = historyService.historyUserIdExist(id);
        if (!exist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user id is not found");
        }
        return historyService.getHistoriesByUser(id);
    }

    @GetMapping("/getHistories/date/{date}")
    public List<History> getHistoriesByUser(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return historyService.getHistoriesByDate(date);
    }

    @PostMapping("/work")
    public void setWork(@RequestParam("id") Long id,
                        @RequestParam("type") int type,
                        @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                        @RequestParam("time") @DateTimeFormat(pattern = "HH:mm:ss") Date time
                        ) {
        History history = null;
        if (type == 1) {
            history = historyService.onWork(date, id, time);
        } else if (type == 0) {
            history = historyService.offWork(date,id,time);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "type is not valid");
        }
        if (history == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "history is not found");
        }
    }






}
