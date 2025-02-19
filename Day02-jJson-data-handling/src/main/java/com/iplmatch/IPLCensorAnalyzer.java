package com.iplmatch;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.csv.*;
public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInputFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\ipl_match.json";
        String csvInputFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\ipl_match.csv";

        String jsonOutputFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\censored_iplmatches.json";
        String csvOutputFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\censored_ipl_match.csv";

        try {
            List<IPLMatch> jsonMatches = readJSON(jsonInputFile);
            jsonMatches.forEach(IPLMatch::applyCensorship);
            writeJSON(jsonOutputFile, jsonMatches);

            List<IPLMatch> csvMatches = readCSV(csvInputFile);
            csvMatches.forEach(IPLMatch::applyCensorship);
            writeCSV(csvOutputFile, csvMatches);

            System.out.println("Censored JSON and CSV files generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<IPLMatch> readJSON(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<IPLMatch>>() {});
    }

    private static void writeJSON(String filePath, List<IPLMatch> matches) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(new File(filePath), matches);
    }

    private static List<IPLMatch> readCSV(String filePath) throws IOException {
        List<IPLMatch> matches = new ArrayList<>();
        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                IPLMatch match = new IPLMatch(
                        Integer.parseInt(record.get("match_id")),
                        record.get("team1"),
                        record.get("team2"),
                        Integer.parseInt(record.get("score_team1")),
                        Integer.parseInt(record.get("score_team2")),
                        record.get("winner"),
                        record.get("player_of_match")
                );
                matches.add(match);
            }
        }
        return matches;
    }

    private static void writeCSV(String filePath, List<IPLMatch> matches) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("match_id", "team1", "team2", "score_team1", "score_team2", "winner", "player_of_match"))) {
            for (IPLMatch match : matches) {
                csvPrinter.printRecord(
                        match.match_id,
                        match.team1,
                        match.team2,
                        match.score.get(match.team1),
                        match.score.get(match.team2),
                        match.winner,
                        match.player_of_match
                );
            }
        }
    }
}
