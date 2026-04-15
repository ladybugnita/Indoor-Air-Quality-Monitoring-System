package com.IAQMS.IAQMS.Service;


import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HealthRecommendationService {


    private static final String[] RECOMMENDATIONS = {
            "Wear a mask when air quality is poor",
            "Use an air purifier indoors",
            "Drink more water to stay hydrated",
            "Avoid outdoor exercise during high pollution",
            "Sinus patients should avoid exposure to smoke, strong perfumes, and dust.",
            "Asthma patients should keep inhalers ready",
            "Allergy patients should keep windows closed"
    };

    public List<String> getRecommendations(String userProfile) {
        userProfile = userProfile.toLowerCase();

        Map<String, Double> scores = new HashMap<>();

        for (String item : RECOMMENDATIONS) {
            double similarity = cosineSimilarity(userProfile, item.toLowerCase());
            scores.put(item, similarity);
        }

        List<String> sorted = scores.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey)
                .toList();

        return sorted.stream().limit(3).toList();
    }

    private double cosineSimilarity(String text1, String text2) {
        Map<String, Integer> freq1 = getWordFrequency(text1);
        Map<String, Integer> freq2 = getWordFrequency(text2);

        Set<String> allWords = new HashSet<>(freq1.keySet());
        allWords.addAll(freq2.keySet());

        int dot = 0, mag1 = 0, mag2 = 0;
        for (String word : allWords) {
            int x = freq1.getOrDefault(word, 0);
            int y = freq2.getOrDefault(word, 0);
            dot += x * y;
            mag1 += x * x;
            mag2 += y * y;
        }

        if (mag1 == 0 || mag2 == 0) return 0.0;
        return dot / (Math.sqrt(mag1) * Math.sqrt(mag2));
    }

    private Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : text.split("\\s+")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }
}


