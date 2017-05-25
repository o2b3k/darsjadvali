package kg.ksucta.controller;

import kg.ksucta.domain.Message;
import kg.ksucta.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    private void setMessageService(MessageService messageService){
        this.messageService = messageService;
    }

    @RequestMapping(value = "/message/{s_id}",method = RequestMethod.GET)
    public List<Message> getById(@PathVariable("subject_id") Long id){
        List<Message> messageList = (List<Message>) messageService.getById(id);
        return messageList;
    }

}
