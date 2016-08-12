package com.craftsvilla.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Message {

    private String sender;
    private List<String> receivers;
    private String subject;
    private String body;
    private List<File> attachments;


    public Message(){
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(File file){
        if(this.attachments == null)
            this.attachments = new ArrayList<File>();

        this.attachments.add(file);
    }

    public void addReceiver(String r){
        if(receivers == null)
            receivers = new ArrayList<String>();

        receivers.add(r);
    }
}
