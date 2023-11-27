package pl.slaszu.gpw.admin.service;

import jakarta.annotation.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LoggingFileReader {
    private String path;

    public LoggingFileReader(String path) {
        this.path = path;
    }

    public List<String> getContent(@Nullable String slug) throws IOException {

        BufferedReader bufferedReader = null;
        List<String> lines;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.path + "spring.log"));
            lines = bufferedReader.lines().collect(Collectors.toList());

        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        Collections.reverse(lines);

        if (slug != null && !slug.isEmpty()) {
            lines = lines.stream().filter(s -> s.indexOf(slug) > 0).collect(Collectors.toList());
        }

        if (lines.size() > 1000) {
            lines = lines.subList(0, 1000);
        }

        return lines;
    }
}
