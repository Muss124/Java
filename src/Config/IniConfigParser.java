package Config;
import java.io.FileReader;
import java.util.*;

public class IniConfigParser {
    private List<String> content = new ArrayList<String>();
    private String currentSection = null;
    private Map<String, String> sectionData = new HashMap<String, String>();
    //public static Map<String, Map<String, String>> Parse(String filePath) throws Exception {

}

        /*
        Map<String, Map<String, String>> parsedData = new HashMap<String, Map<String, String>>();


        FileReader file = new FileReader(filePath);
        Scanner scanner = new Scanner(file);
        List<String> newContent = new ArrayList<String>();


        while (scanner.hasNextLine()) {
            content.add(scanner.nextLine());
        }

        for (String line : content) {
            int pos = line.indexOf(';');
            String tmp = line;
            tmp = tmp.trim();
            if (pos != -1) {
                tmp = line.substring(0, pos);
            }

            if (pos != 0) {
                newContent.add(tmp);
            }

        }
        content = newContent;

        for (String line : content) {

            boolean isSection = getSection(line);
            if (!isSection) {
                if (currentSection == null) {
                    //неправильная секция
                    throw new ParserException("Section error " + line);
                }
                if (!getParam(line)) {
                    //неправильные параметры
                    throw new ParserException("Params error " + line);
                }
            }
        }
        if (!sectionData.isEmpty()) {
            parsedData.put(currentSection, sectionData);
        }

        file.close();

        return parsedData;
    }
    private static boolean getSection(String line) {
        int posOpen = line.indexOf('[');
        int posClose = line.indexOf(']');
        if (posOpen != -1 && posClose != -1 && posClose > posOpen) {
            line = line.substring(posOpen + 1, posClose);
            if (line.matches("[\\w]+")) {
                if (currentSection == null) {
                    currentSection = line;
                } else {
                    data.put(currentSection, sectionData);
                    currentSection = line;
                    sectionData = new HashMap<String, String>();
                }
                return true;
            }
        }
        return false;
    }
    private static boolean getParam(String line) {
        if (line.indexOf('=') != -1) {
            String[] pairs = line.split("=");
            pairs[0] = pairs[0].trim();
            pairs[1] = pairs[1].trim();
            if (pairs[0].matches("^[a-zA-Z0-9]+") && pairs[1].matches("^[a-zA-Z0-9./]+")) {
                sectionData.put(pairs[0], pairs[1]);
                return true;
            }
        }
        return false;
    }
}
*/