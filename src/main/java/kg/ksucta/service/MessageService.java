package kg.ksucta.service;

import kg.ksucta.domain.Message;

import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */
public interface MessageService {
    Message getById(Long id);
    Message getBySubjectId(Long id);
}
