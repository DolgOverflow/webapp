package blog.com.domain;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({})
@EnableTransactionManagement
//@Autowired
//private Enviroment env;

/*
@Bean
public AnnotationSessionFactoryBean sessionFactory(){
final AnnotationSessionFactoryBean sessionFactory=new AnnotationSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("blog.com.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
        }

private Properties hibernateProperties(){
        return new Properties(){
        {
        setProperty("hibernate.dialect",env.getProperty("org.hibernate.dialect.H2Dialect"));
        }
        }
        }

*/

public class SpringPersistenceConfig {
    @Bean
    public DataSource dataSource() {
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:blog_db;DB_CLOSE_DELAY=-1");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setInitialSize(5);
        ds.setMaxTotal(10);
        return ds;
    }
    @Autowired
private Environment env;

    @Bean
    public AnnotationSessionFactoryBean sessionFactory(){
        final AnnotationSessionFactoryBean sessionFactory=new AnnotationSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("blog.com.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties(){
        return new Properties(){
            {
                setProperty("hibernate.dialect",env.getProperty("org.hibernate.dialect.H2Dialect"));
            }
        };
    }
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
HibernateTransactionManager txManager = new HibernateTransactionManager();
txManager.setSessionFactory(sessionFactory);
return txManager;
    }
}

