package com.priyanka.unittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.priyanka.model.Twitt;
import com.priyanka.repository.TwittRespository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TwittTest {
	@Autowired
	private TwittRespository repo;

	@Test
	@Rollback(false)
	public void testCreateTwitt() {
		Twitt twitt = new Twitt(1, "Hello Twitter!How are you doing today!");
		Twitt savedtwitt = repo.save(twitt);
		assertNull(savedtwitt);
	}

	@Test
	@Rollback(false)
	public void testUpdateTwitt() {
		String twittMessage = "Hello Twitter.Good morning";
		Twitt twitt = new Twitt(0, twittMessage);
		twitt.setId(1);
		Integer id = twitt.getId();
		repo.save(twitt);
		Object updatedTwitt = repo.findById(id);
		assertThat(((Twitt) updatedTwitt).getMessage()).isEqualTo(updatedTwitt);
	}

	@Test
	public void testListofTwitts() {
		List<Twitt> twitts = repo.findAll();
		assertThat(twitts).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testDeleteTwitt() {
		Integer id = 1;
		boolean existBeforeDelete = repo.findById(id).isPresent();
		repo.deleteById(id);
		boolean notExistAfterDelete = repo.findById(id).isPresent();
		assertTrue(existBeforeDelete);
		assertFalse(notExistAfterDelete);
	}
}
