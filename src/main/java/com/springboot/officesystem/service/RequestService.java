package com.springboot.officesystem.service;

import com.springboot.officesystem.model.Request;

import java.util.List;
import java.util.Optional;

public interface RequestService {

    public Request answerRequest(String answer, Long requestId);
    public Request submitRequest(Request request);
    public List<Request> getRequestByReceiver(Long id);
    public List<Request> getRequestBySender(Long id);

    public Request createEmptyRequest();
}
