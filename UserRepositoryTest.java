package com.priyanka.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.priyanka.model.User;
import com.priyanka.repository.UserRespository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired
	private UserRespository repo;
	@Autowired
	private TestEntityManager entitymanager;
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("johndoe2021@gmail.com");
		user.setFirstname("John");
		user.setLastname("Doe");
		user.setPassword("John2021");
		User savedUser=repo.save(user);
		
		User existUser= entitymanager.find(User.class, savedUser.getId());
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindUserbyemail() {
		String email="johndoe2021@gmail.com";
		User user = repo.findbyemail(email);
		assertThat(user).isNotNull();
		
	}
}
