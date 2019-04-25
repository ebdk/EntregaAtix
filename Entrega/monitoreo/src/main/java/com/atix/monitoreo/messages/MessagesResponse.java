package com.atix.monitoreo.messages;

import com.atix.monitoreo.models.Anomalia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MessagesResponse implements Response {

    private List<Response> messages;

    public MessagesResponse(List<Anomalia> anomaliasEntities) {
        super();
        this.messages = convertirEntitiesToResponse(anomaliasEntities);
    }

    public MessagesResponse(LinkedList<Integer> cola) {
        super();
        this.messages = convertirListToMessage(cola);
    }

    private List<Response> convertirListToMessage(LinkedList<Integer> cola) {
        List<Response> messages = new ArrayList<>();
        for (int numero : cola) {
            messages.add(new MessageResponse(numero));
        }
        return messages;
    }

    private List<Response> convertirEntitiesToResponse(List<Anomalia> anomaliasEntities) {
        List<Response> messages = new ArrayList<>();
        for (Anomalia anomalia : anomaliasEntities) {
            messages.add(new AnomaliaResponse(anomalia));
        }
        return messages;
    }

    public List<Response> getMessages() {
        return messages;
    }

    public void addMessage(Response message) {
        this.messages.add(message);
    }
}
