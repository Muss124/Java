package Config;
import java.util.*;

public class IniConfig {

    private ConfigData data = new ConfigData(new HashMap<String, Map<String, String>>());

    IniConfig(String filePath) throws Exception {
        parse(filePath);
    }

    public int getIntValue(String section, String parameter) throws ParserException {
        return data.getIntValue(section, parameter);
    }

    public double getDoubleValue(String section, String parameter) throws ParserException {
        return data.getDoubleValue(section, parameter);
    }

    public String getStringValue(String section, String parameter) throws ParserException {
        return data.getStringValue(section, parameter);
    }

    public void print() {
        data.print();
    }

    private void parse(String filePath) throws Exception {
        IniConfigParser parser = new IniConfigParser();
        this.data = parser.Parse(filePath);
    }
}