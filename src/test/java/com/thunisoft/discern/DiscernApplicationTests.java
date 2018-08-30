package com.thunisoft.discern;

import com.thunisoft.discern.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscernApplicationTests {
@Autowired
private AuthService authService;
	@Test
	public void contextLoads() {

	}

	public static void main(String[] args) {
		AuthService authService = new AuthService();
		String auth = authService.getAuth();
		System.out.println(auth);
	}
}
