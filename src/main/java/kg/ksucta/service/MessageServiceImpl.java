package kg.ksucta.service;

import kg.ksucta.domain.Message;
import kg.ksucta.domain.model.Subject;
import kg.ksucta.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by o2b3k on 5/23/17.
 */
@Service
public class MessageServiceImpl implements MessageService{

    private static final AtomicLong counter = new AtomicLong();
    private final MessageRepository messageRepository;
    private static List<Message> messages;
    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public Message getById(Long id) {
        return messageRepository.findOne(id);
    }

    @Override
    public Message getBySubjectId(Long id) {
        return messageRepository.getOne(id);
    }

    @Override
    public List<Message> listAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void updateMessage(Message message) {
        int index = messages.indexOf(message);
        messages.set(index,message);
    }

    @Override
    public void deleteMessage(Long id) {
        for (Iterator<Message> iterator = messages.iterator(); iterator.hasNext();){
            Message message= iterator.next();
            if (message.getId() == id){
                messageRepository.delete(id);
            }
        }
    }
}
