package org.wecancodeit.reviews;

import javax.annotation.Resource;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;




@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)

public class ReviewControllerMockMvcTest {

	@Resource
	private MockMvc mvc;
	
	@Mock
	private Review review1;

	@Mock
	private Review review2;
	
	@MockBean
	private ReviewRepository repository;

	@Test
	public void shouldBeOkForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());

	}
	
	@Test
	public void shouldRouteToAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviews")));
	}
	
	@Test
	public void shouldPutAllReviewsInTheModel() throws Exception {
		Collection<Review>allReviews = asList(review1, review2);
		when(repository.findAll()).thenReturn(allReviews);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}
	
	@Test
	public void shouldBeOKFor1Review() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToOneReview() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void ShouldPutOneReviewInTheModel() throws Exception {
		when(repository.findOne(1L)).thenReturn(review1);
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("reviews", is(review1)));
	}
}
