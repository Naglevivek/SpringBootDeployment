package com.example.demo.UserTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserTest {
  @Mock
  UserRepository userRepository;
  @InjectMocks
  UserService userService;
  @Test
  void addUser() {
	User user=new User();
	user.setId((long) 89089);;
	user.setEmail("vivek.nagle@rakuten.com");
	user.setName("Vivek Nagle");
	Mockito.when(userRepository.save(user)).thenReturn(user);
	User addedUser=userService.createUser(user);
	Assertions.assertEquals(user.getId(),addedUser.getId());
  }
}
