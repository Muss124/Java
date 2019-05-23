package Config;
import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.util.*;


/*
to do
имя класса
1 return в конце функций, а в начале проверка валидности
убрать дитч из полей и оставитьб только дату.
конструктор с вызовом парсинга (возможно вынести в отдельный класс, но можно забить)
*/
public class IniConfig {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();

    /*
    IniConfig(String filePath) throws Exception {
        data = IniConfigParser.Parse(filePath);
    }
    */
    public int getIntValue(String section, String parameter) throws ParserException {
        if (data.containsKey(section)) {
            if (data.get(section).containsKey(parameter)) {
                return Integer.parseInt(data.get(section).get(parameter));
            } else {
                throw new ParserException("Parametr doesn't exist");
            }
        } else {
            throw new ParserException("Section doesn't exist");
        }
    }

    public double getDoubleValue(String section, String parameter) throws ParserException {
        if (data.containsKey(section)) {
            if (data.get(section).containsKey(parameter)) {
                return Double.parseDouble(data.get(section).get(parameter));
            } else {
                throw new ParserException("Parametr doesn't exist");
            }
        } else {
            throw new ParserException("Section doesn't exist");
        }
    }

    public String getStringValue(String section, String parameter) throws ParserException {
        if (data.containsKey(section)) {
            if (data.get(section).containsKey(parameter)) {
                return data.get(section).get(parameter);
            } else {
                throw new ParserException("Parametr doesn't exist");
            }
        } else {
            throw new ParserException("Section doesn't exist");
        }
    }

    public void print() {
        System.out.println(data.toString());
    }

}