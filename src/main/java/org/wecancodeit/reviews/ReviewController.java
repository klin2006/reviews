package org.wecancodeit.reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepository;

	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepository.findAll());
		return "reviews";
	}

	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("reviews", reviewRepository.findOne(id));
		return "review";

	}

}
