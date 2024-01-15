package com.nextlevelhomelab.labtracker.models.utility;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Result<T> {

    private ResultType type = ResultType.SUCCESS;
    private T payload;

    private final ArrayList<String> messages = new ArrayList<>();

    public boolean isSuccess() {
        return type == ResultType.SUCCESS;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public void addMessage(String message, ResultType type) {
        messages.add(message);
        this.type = type;
    }

}

