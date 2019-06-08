package com.alten.status.checker;

import com.alten.status.checker.model.entity.User;
import com.alten.status.checker.repository.UserRepository;
import com.alten.status.checker.service.UserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.mock;

public class UserDAOTest {

    private UserDAO userDAO;

    @Before
    public void initTest() {
        userDAO = new UserDAO();
        ReflectionTestUtils.setField(userDAO, "repository", mock(UserRepository.class));
    }

    @Test
    public void saveTest() {
        User user = new User();
        user.setName("userName");
        user.setAddress("userAddress");
        user.setId(1);
        Mockito.doAnswer(invocationOnMock -> {
            User argument = invocationOnMock.getArgument(0);
            Assert.assertEquals(argument.getName(), user.getName());
            Assert.assertEquals(argument.getAddress(), user.getAddress());
            Assert.assertEquals(argument.getId(), user.getId());
            return null;
        }).when(userDAO.getRepository()).save(user);

        userDAO.save(user);
    }
}
