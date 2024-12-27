package com.beginner.springbootmaster.coding.part1;

import java.util.HashMap;
import java.util.List;

public class TournamentWinner {
    public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
        HashMap<String, Integer> competitionsCount = new HashMap<String, Integer>();
        String winner = "";
        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 0) {
                competitionsCount.put(competitions.get(i).get(1), competitionsCount.getOrDefault(competitions.get(i).get(1), 0) + results.size());
            } else {
                competitionsCount.put(competitions.get(i).get(0), competitionsCount.getOrDefault(competitions.get(i).getFirst(), 0) + results.size());
            }
        }

        for (String competition : competitionsCount.keySet()) {
            if (competitionsCount.get(competition) > competitionsCount.getOrDefault(winner, 0)) {
                winner = competition;
            }
        }

        return winner;

    }

    public static void main(String[] args) {
        List<List<String>> competitions = List.of(
                List.of("HTML", "C#"),
                List.of("C#", "Python"),
                List.of("Python", "HTML")
        );
        List<Integer> results = List.of(0, 0, 1);
        String winner = tournamentWinner(competitions, results);
        System.out.println(winner);
    }
}
