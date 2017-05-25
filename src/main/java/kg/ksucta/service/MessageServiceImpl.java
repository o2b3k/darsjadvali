package kg.ksucta.service;

import kg.ksucta.domain.Message;
import kg.ksucta.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */
@Service
public class MessageServiceImpl implements MessageService{


    private final MessageRepository messageRepository;

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
}
