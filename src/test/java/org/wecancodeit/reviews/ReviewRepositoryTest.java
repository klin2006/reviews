package org.wecancodeit.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ReviewRepositoryTest {
	
	

	ReviewRepository underTest;
	
	private long firstId = 1L;
	private Review review1 = new Review(firstId, "Becoming", "Michelle Obama", "In \"Becoming,\" you hear firsthand "
			+ "what it's like to be Michelle Obama. She talks about her childhood, her first impressions of Barack, "
			+ "her adjustment to life in politics, and her time in the White House. Michelle actually narrates this "
			+ "book herself, so I definitely recommend the audiobook version if you are interested in reading this book.", 
			8.5, "/images/MichelleObama.jpg", "non-fiction");
	
	
	private long secondId = 2L;
	private Review review2 = new Review(secondId, "Circe", "Madeline Miller", "Description2", 9, "Circe", "fiction");

	@Test
	public void shouldFindOneReview() {
		underTest = new ReviewRepository(review1);
		Review result = underTest.findOne(firstId);
		assertThat(result, is(review1));
	}

	@Test
	public void shouldFindASecondReview() {
		underTest = new ReviewRepository(review2);
		Review result = underTest.findOne(secondId);
		assertThat(result, is(review2));

	}

	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(review1, review2);
		Collection<Review> result = underTest.findAll();
		assertThat(result, containsInAnyOrder(review1, review2));

	}

}
