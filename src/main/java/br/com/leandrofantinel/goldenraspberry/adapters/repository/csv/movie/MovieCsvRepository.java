package br.com.leandrofantinel.goldenraspberry.adapters.repository.csv.movie;

import br.com.leandrofantinel.goldenraspberry.util.StringUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class MovieCsvRepository {

    public List<MovieCsv> load(InputStream is) {
        try (
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                CSVParser csvParser = new CSVParser(fileReader,
                CSVFormat.DEFAULT
                    .withDelimiter(';')
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim()
            )
        ) {

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            return StreamSupport.stream(csvRecords.spliterator(), false)
                    .map(e -> new MovieCsv(
                        e.get("year"),
                        e.get("title"),
                        e.get("studios"),
                        e.get("producers"),
                        StringUtil.coalesce(e.get("winner"), "no").toUpperCase()
                    )).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
