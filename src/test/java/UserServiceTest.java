import org.example.UserDao;
import org.example.UserService;
import org.example.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {
    UserService userService;

//    @Mock
    UserDao userDao;


    @BeforeEach
    public void setUp() {
        userDao = mock(UserDao.class);
        userService = new UserService(userDao);

    }

    @Test
    @DisplayName("Permission assigned successfully")
    public void mocking() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn("admin"); // <- method stubbing
        when(user.getUsername()).thenReturn("Agata");
        userService.setUser(user);
        Assertions.assertEquals(1, userService.assignPermission());

        // How to isolate and test specific functionality in a controlled environment :
//        List<String> filteredPosts = new ArrayList<>();
//        filteredPosts.add("This post is awesome");
//        filteredPosts.add("This place is awesome");
//        when(mocking.getAllPostsContainingWord("awesome")).thenReturn(filteredPosts);

    }

    @Test
    @DisplayName("Should update successfully")
    public void updateUsernameSuccess() throws Exception {
        User user = new User();
        user.setUsername("agata");
        lenient().when(userDao.getUserById(Mockito.anyString())).thenReturn(Optional.of(user));
        Assertions.assertEquals(1, userService.updateUsername("1", "aga"));
    }

    @Test
    @DisplayName("User could not be updated")
    public void updateUsernameError() throws Exception {
        when(userDao.getUserById(Mockito.anyString())).thenReturn(Optional.empty());
        Assertions.assertThrows(Exception.class, () -> userService.updateUsername("3412","aga"));
    }





}
