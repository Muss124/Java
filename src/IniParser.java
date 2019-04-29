import java.io.*;
import java.util.*;

public class IniParser {
    private String path;
    private List<String> content = new ArrayList<String>();
    IniParser(String filePath){
        path = filePath;
    }
    public void read() throws Exception{
        FileReader file = new FileReader(path);
        Scanner scanner = new Scanner(file);
        List<String> newContent = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            content.add(scanner.nextLine());
        }

        for(String line: content){
            int pos = line.indexOf(';');
            String tmp = line;
            tmp = tmp.trim();
            if (pos != -1 ){ tmp = line.substring(0, pos);}
//            System.out.println("\"" + tmp + "\"");
            if (pos != 0) { newContent.add(tmp);}
//            if (pos != -1){
//                line.getChars(0, pos+1, dst, 0);
//                content.add(i, dst.toString());
//            }
//            System.out.println(content.get(i));
        }
        content = newContent;

        String currentSection = null;
        Map<String, String> sectionData = new HashMap<String, String>();
        Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
        for(String line: content){

            // переделать на регулярки для проверки секций
            int posOpen = line.indexOf('[');
            int posClose = line.indexOf(']');
            if (currentSection == null){
                if (posOpen != -1){
                    if (posClose != 0 && posClose > posOpen){
                        currentSection = line.substring(posOpen + 1, posClose);
                        System.out.println(currentSection);
                    } else {
                        // исключение ошибка синтаксиса секции
                    }
                } else {
                    // исключение отсутствие секции
                }
            } else {
                if (posOpen != -1){
                    if (posClose != 0 && posClose > posOpen){
                        // тут получить дату и записать секцию
                        currentSection = line.substring(posOpen + 1, posClose);
                        // System.out.println(currentSection);
                    } else {
                        // исключение
                    }
                } else {
                    int equal = line.indexOf(" = ");
                    String name = line.substring(0, equal);
                    System.out.println(name);
                    //sectionData.put();
                }
            }
        }

        file.close();
    }
    //public void
}
