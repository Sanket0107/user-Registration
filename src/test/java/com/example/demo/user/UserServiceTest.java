package com.example.demo.user;

public class UserServiceTest {

	private UserRepository userRepository = mock(UserRepository.class);
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private UserService userService = new UserService(userRepository, passwordEncoder);

    @Test
    void testRegisterUser() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());
        User user = userService.registerUser("Test User", "test@example.com", "M", "password", "127.0.0.1", "USA");
        assertNotNull(user);
        assertEquals("test@example.com", user.getEmail());
    }
}
