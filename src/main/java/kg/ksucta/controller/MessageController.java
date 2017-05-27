package kg.ksucta.controller;

import kg.ksucta.domain.Message;
import kg.ksucta.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */
@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    MessageService messageService;

    private void setMessageService(MessageService messageService){
        this.messageService = messageService;
    }

    /*----------- Retrieve All Message ------------------*/
    @RequestMapping(value = "/message",method = RequestMethod.GET)
    public ResponseEntity<List<Message>> listResponseEntity(){
        List<Message> messages = messageService.listAllMessages();
        if (messages.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
    }

    /*----------- Retrieve Single Message ------------------*/
    @RequestMapping(value = "/message/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getMessage(@PathVariable("id") Long id){
        Message message = messageService.getById(id);
        if (message == null){
            return new ResponseEntity(new CustomErrorType("Subject with id " + id
                    + " not found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Message>((MultiValueMap<String, String>) message,HttpStatus.OK);
    }

    /*----------- Create new Message ------------------*/
    @RequestMapping(value = "/message",method = RequestMethod.POST)
    public ResponseEntity<?> createSubject(@RequestBody Message message, UriComponentsBuilder builder){
        messageService.saveMessage(message);
        HttpHeaders headers =   new HttpHeaders();
        headers.setLocation(builder.path("/api/message/{id}").buildAndExpand(message.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }

    /*------------Update message -------------*/
    @RequestMapping(value = "/message/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateSubject(@PathVariable("id") Long id,@RequestBody Message message) {
        Message currentMessage = messageService.getById(id);
        if (messageService == null) {
            return new ResponseEntity(new CustomErrorType("Unable to update. Subject with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentMessage.setText(message.getText());
        messageService.updateMessage(currentMessage);
        return new ResponseEntity<Message>(currentMessage,HttpStatus.OK);
    }

    /*------------ Delete message -----------------*/
    @RequestMapping(value = "/message/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSubject(@PathVariable("id") Long id){
        Message message = messageService.getById(id);
        if (message == null){
            return new ResponseEntity(new CustomErrorType("Unable to delete. Subject with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        messageService.deleteMessage(id);
        return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/message/{subject_id}",method = RequestMethod.GET)
    public List<Message> getById(@PathVariable("subject_id") Long id){
        List<Message> messageList = (List<Message>) messageService.getById(id);
        return messageList;
    }

}
