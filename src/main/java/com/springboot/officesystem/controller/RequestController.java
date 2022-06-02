package com.springboot.officesystem.controller;

import com.springboot.officesystem.model.Request;
import com.springboot.officesystem.model.User;
import com.springboot.officesystem.service.RequestService;
import com.springboot.officesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/request")
@CrossOrigin
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Request add(@RequestParam("senderId") Long sid,
                       @RequestParam("receiverId") Long rid,
                       @RequestParam("requestType") String requestType,
                       @RequestParam("comment") String comment,
                       @RequestParam("datetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date time
    ){
        User sender = userService.getUserById(sid);
        User receiver = userService.getUserById(rid);
        if (sender == null || receiver == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user id is not found");
        }
        Request request = new Request();
        request.setDecision(null);
        request.setComment(comment);
        request.setSubmissionTime(time);
        request.setRequestSender(sender);
        request.setRequestReceiver(receiver);
        requestService.submitRequest(request);
        return request;
    }

    @PostMapping("/answer")
    public Request answer(@RequestParam("requestId") Long requestId,
                          @RequestParam("decision") String decision
    ){
        Request request = requestService.answerRequest(decision,requestId);
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "request is not found");
        }
        return request;
    }

    @GetMapping("/getRequest/{id}")
    public Request getRequestById(@PathVariable("id") Long id){
        Request request = requestService.getRequestById(id);
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "request is not found");
        }
        return request;
    }

    @GetMapping("/getRequest/receiver/{id}")
    public List<Request> getRequestByReceiver(@PathVariable("id") Long id){
        return requestService.getRequestByReceiver(id);
    }

    @GetMapping("/getRequest/sender/{id}")
    public List<Request> getRequestBySender(@PathVariable("id") Long id){
        return requestService.getRequestBySender(id);
    }

}
