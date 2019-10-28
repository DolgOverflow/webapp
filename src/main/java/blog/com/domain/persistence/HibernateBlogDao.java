package blog.com.domain.persistence;

import blog.com.domain.domain.Author;
import blog.com.domain.domain.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HibernateBlogDao implements BlogDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateBlogDao(SessionFactory sessionFactory) {//<co id="co_injectSessionFactory"/>
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addAuthor(Author author) {
        currentSession().save(author);
    }

    @Override
    public void saveAuthor(Author author) {
        currentSession().update(author);
    }

    @Override
    public Author getAuthorById(long id) {
        return (Author) currentSession().get(Author.class, id);
    }

    @Override
    public List<Message> getRecentMessage() {
        return null;
    }

    @Override
    public void saveMessage(Message message) {
        currentSession().save(message);
    }

    @Override
    public List<Message> getMessageForAuthor(Author author) {
        return null;
    }

    @Override
    public Author getAuthorByUsername(String username) {
        return null;
    }

    @Override
    public void deleteMessage(long id) {
        currentSession().delete(getMessageById(id));
    }

    @Override
    public Message getMessageById(long id) {
        return currentSession().get(Message.class, id);
    }

    @Override
    public List<Author> findAllAuthors() {
        return null;
    }


}