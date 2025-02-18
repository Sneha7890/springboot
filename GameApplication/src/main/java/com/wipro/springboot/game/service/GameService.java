package com.wipro.springboot.game.service;

import com.wipro.springboot.game.model.Score;
import com.wipro.springboot.game.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class GameService {

    @Autowired
    private ScoreRepository scoreRepository;

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Optional<Score> existingScore = scoreRepository.findByName(name);

        if (existingScore.isPresent()) {
            System.out.println("Welcome back, " + name + "! Your previous best score was " + existingScore.get().getAttempts() + " attempts.");
        }

        int targetNumber = (int) (Math.random() * 100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("Guess a number between 1 and 100!");

        while (guess != targetNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations, " + name + "! You guessed it in " + attempts + " attempts.");

                if (existingScore.isPresent()) {
                    Score score = existingScore.get();
                    if (attempts < score.getAttempts()) {
                        System.out.println("New high score! Updating your best score.");
                        score.setAttempts(attempts);
                        scoreRepository.save(score);
                    } else {
                        System.out.println("Your previous best score remains.");
                    }
                } else {
                    scoreRepository.save(new Score(name, attempts));
                    System.out.println("Your score has been saved to the database!");
                }
            }
        }
        scanner.close();
    }
}
