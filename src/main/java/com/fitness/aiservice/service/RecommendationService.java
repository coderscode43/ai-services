package com.fitness.aiservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fitness.aiservice.modals.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

	private final RecommendationRepository recommendationRepository;

	public List<Recommendation> getUserRecommendation(String userId) {

		return recommendationRepository.findByUserId(userId);
	}

	public Recommendation getActivityRecommendation(String activityId) {
		// System.out.println("No recommendation found for this activity");
		return recommendationRepository.findByActivityId(activityId)
				.orElseThrow(() -> new RuntimeException("No recommendation found for this activity " + activityId));

	}

}
