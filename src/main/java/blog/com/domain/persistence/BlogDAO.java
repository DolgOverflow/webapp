package blog.com.domain.persistence;

import blog.com.domain.domain.Author;
import blog.com.domain.domain.Message;

import java.util.List;

public interface BlogDAO {
    void addAuthor(Author author);
    void saveAuthor(Author author);
    Author getAuthorById(long id);
        List<Message> getRecentMessage();
        void saveMessage(Message message);
        List<Message> getMessageForAuthor(Author author);
        Author getAuthorByUsername(String username);
        void deleteMessage(long id);
        Message getMessageById(long id);
        List<Author> findAllAuthors();
}
