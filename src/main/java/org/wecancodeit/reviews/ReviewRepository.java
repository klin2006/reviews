package org.wecancodeit.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	
	public ReviewRepository() {
		Review becoming = new Review(2L, "Becoming", "Michelle Obama", "In \"Becoming,\" you hear firsthand "
				+ "what it's like to be Michelle Obama. She talks about her childhood, her first impressions of Barack, "
				+ "her adjustment to life in politics, and her time in the White House. Michelle actually narrates this "
				+ "book herself, so I definitely recommend the audiobook version if you are interested in reading this book.", 8.5, "MichelleObama", "non-fiction");
		Review circe = new Review(4L, "Circe", "Madeline Miller", "\"Circe\" centers around the Greek goddess by the same name. "
				+ "Circe is unloved and ignored by most of the other gods and goddesses, so she tries something drastic, which gets "
				+ "her banned to a deserted island. It is here where she is visited by Odysseus. Their encounter, which"
				+ " was made famous in \"The Odyssey,\" is told from Circe's point of view in this book. If you like"
				+ " Greek Mythology, I highly recommend this book.", 9, "Circe", "fiction");
		Review evelyn = new Review(6L, "7 1/2 Deaths of Evelyn Hardcastle", "Stuart Turton", "This book is difficult"
				+ " to describe, but essentially one character has to figure out who murdered Evelyn Hardcastle"
				+ " before midnight. The catch is, he gets to relive the day eight different times in eight different"
				+ " bodies. I found it extremely fast-paced, intriguing, and suspenseful. The one criticism is that "
				+ " it can get confusing, but if you pay attention, it is well worth the read. This is the"
				+ " only audiobook that I plan to go back and read as a paper book.", 9.5, "EvelynHardCastle", "fiction");
		Review badBlood = new Review(1L, "Bad Blood", "John Carreyrou", "John Carreyrou interviews more than"
				+ " 150 subjects in an effort to depict the rise and fall of Theranos, a multi-billion"
				+ " dollar company that promised results from hundreds of bloodtests with just a few drops of blood."
				+ " Carreyrou illustrates how Theranos' founder, Elizabeth Holmes, was able to get as far"
				+ " as she did without anyone suspecting that her technology didn't actually work...well, almost everyone."
				+ " Bad Blood is a quick and compelling read about this defunct startup.", 8, "BadBlood", "non-fiction");
		Review moscow = new Review(5L, "A Gentleman in Moscow", "Amor Towles", "This novel starts in Moscow in the 1920s and revolves"
				+ " around Count Alexander, an aristocrat who is imprisoned in a hotel by the Bolsheviks for the rest of his life. Although he is"
				+ " under house arrest, there is plenty afoot in the hotel and the novel spans more than 30 years. Towles' writing is absolutely delightful and there"
				+ " is also quite a bit of Russian history embedded in this novel. ", 9, "Moscow", "fiction");
		Review educated = new Review(3L, "Educated", "Tara Westover", "In this memoir, Tara Westover recounts her childhood and adolescence growing up in a"
				+ " survivalist family in the Idaho mountains and her early adult life when she leaves for college. She offers us a glimpse into her often shocking life,"
				+ " including her upbringing, education, and family dynamics. It was not until college that she learned that her father may have bipolar disorder, which for"
				+ " her explains many of his erratic decisions and behavior. Westover's account is beautifully constructed and will leave you reflecting on your"
				+ " own upbringing long after your finish it."
				+ "   ", 9, "Educated", "non-fiction");
		
		reviewList.put(becoming.getId(), becoming);
		reviewList.put(badBlood.getId(), badBlood);
		reviewList.put(educated.getId(), educated);
		reviewList.put(circe.getId(), circe);
		reviewList.put(evelyn.getId(), evelyn);	
		reviewList.put(moscow.getId(), moscow);
	}

	public ReviewRepository(Review... reviews) {
		for (Review review : reviews) {
			reviewList.put(review.getId(), review);
		}
	}

	public Review findOne(long id) {
		return reviewList.get(id);

	}

	public Collection<Review> findAll() {
		return reviewList.values();
	}

}
