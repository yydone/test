package com.yydone.demo.test.mapper;

import com.yydone.demo.Application;
import com.yydone.demo.dal.mapper.EmailRepository;
import com.yydone.demo.dal.model.EmailNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmailRepositoryTest {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    public void save() {
        EmailNode emailNode = new EmailNode();
        emailNode.setEmail("yunnix@yydone.com");
        emailRepository.save(emailNode);
    }

    @Test
    public void query() {
        Session session = sessionFactory.openSession();
        EmailNode emailNode = new EmailNode();
        emailNode.setEmail("yunnix@yydone.com");
        session.save(emailNode);
        session.clear();
        sessionFactory.close();
    }
}
