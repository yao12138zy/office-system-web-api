package com.springboot.officesystem.service;

import com.springboot.officesystem.model.Request;
import com.springboot.officesystem.repository.RequestRepository;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RequestSerivceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Request answerRequest(String answer, Long requestId) {
        Request request = requestRepository.findById(requestId).orElse(null);
        if (request == null) { return null; }
        request.setDecision(answer);
        requestRepository.save(request);
        return request;
    }

    @Override
    public Request submitRequest(Request request) {
        if (request.getDecision() != null) {
            request.setDecision(null);
        }
        return requestRepository.save(request);
    }

    @Override
    public List<Request> getRequestByReceiver(Long id) {
        return requestRepository.getRequestByReceiver(id);
    }

    @Override
    public List<Request> getRequestBySender(Long id) {
        return requestRepository.getRequestBySender(id);
    }

    @Override
    public Request createEmptyRequest() { return new Request(); }


}
