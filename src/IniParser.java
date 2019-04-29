import java.io.*;
import java.util.*;

public class IniParser {
    private String path;
    private List<String> content = new ArrayList<String>();
    private String currentSection = null;
    private Map<String, String> sectionData = new HashMap<String, String>();
    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();


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



        for(String line: content){

            boolean isSection = getSection(line);
            if (currentSection == null){
                if (!isSection) {
                    // нету секции
                }
                if (!getParam(line)) {
                    //нету параметров
                }
            }
        }
        if (!sectionData.isEmpty()){
            data.put(currentSection, sectionData);
        }
        file.close();
    }
    private boolean getSection(String line){
        int posOpen = line.indexOf('[');
        int posClose = line.indexOf(']');
        if (posOpen != -1 && posClose != -1 && posClose > posOpen){
            line = line.substring(posOpen + 1, posClose);
            if (line.matches("[\\w+]")){
                if (currentSection == null ){
                    currentSection = line;
                } else {
                    data.put(currentSection, sectionData);
                    sectionData =  new HashMap<String, String>();
                }
                return true;
            }
        }
        return false;
    }
    private boolean getParam(String line){
        if (line.indexOf('=') != -1){
            String[] pairs = line.split("=");
            pairs[0] = pairs[0].trim();
            pairs[1] = pairs[1].trim();
            if (pairs[0].matches("^[a-zA-Z0-9]+") && pairs[1].matches("^[a-zA-Z0-9.]+")){
                sectionData.put(pairs[0],pairs[1]);
                return true;
            }
        }
        return false;
    }
    //public void
}
