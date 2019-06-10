package com.alten.status.checker;

import com.alten.status.checker.model.entity.User;
import com.alten.status.checker.service.DatabaseInitializer;
import com.alten.status.checker.service.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseInitializerTest {
    private DatabaseInitializer databaseInitializer;

    @Before
    public void initTest() {
        databaseInitializer = new DatabaseInitializer();
        ReflectionTestUtils.setField(databaseInitializer, "userDAO", mock(UserDAO.class));
    }

    @Test
    public void testDbInitialization() {
        doAnswer(invocationOnMock -> {
            User user = invocationOnMock.getArgument(0);
            assertNotNull(user);
            return null;
        }).when(databaseInitializer.getUserDAO()).save(Mockito.any());
        databaseInitializer.run();
    }
}
