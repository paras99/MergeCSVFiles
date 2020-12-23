import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeCSV {
    public static void main(String[] args) throws IOException {
        List<Path> paths = Arrays.asList(Paths.get("C:\\Users\\PaRaS\\IdeaProjects\\MergeCSV\\src\\first.csv"), Paths.get("C:\\Users\\PaRaS\\IdeaProjects\\MergeCSV\\src\\second.csv"));
        List<String> mergedLines = getMergedLines(paths);
        Path target = Paths.get("C:\\Users\\PaRaS\\IdeaProjects\\MergeCSV\\src\\Merged.csv");
        Files.write(target, mergedLines);
    }
    private static List<String> getMergedLines(List<Path> paths) throws IOException {
        List<String> mergedLines = new ArrayList<>();
        for (Path p : paths) {
            List<String> lines = Files.readAllLines(p);
            if (!lines.isEmpty()) {
                if (mergedLines.isEmpty()) {
                    mergedLines.add(lines.get(0)); //add header only once
                }
                mergedLines.addAll(lines.subList(1, lines.size()));
            }
        }
        System.out.println(mergedLines);
        return mergedLines;
    }
}