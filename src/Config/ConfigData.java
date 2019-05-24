package Config;

import java.util.Map;

public class ConfigData {
    private final Map<String, Map<String, String>> data;

    ConfigData(Map<String, Map<String, String>> data){
        this.data = data;
    }

    public int getIntValue(String section, String parameter) throws ParserException{
        getCheck(section, parameter);
        return Integer.parseInt(data.get(section).get(parameter));
    }
    public double getDoubleValue(String section, String parameter) throws ParserException {
        getCheck(section, parameter);
        return Double.parseDouble(data.get(section).get(parameter));
    }
    public String getStringValue(String section, String parameter) throws ParserException {
        getCheck(section, parameter);
        return data.get(section).get(parameter);
    }
    private void getCheck(String section,String parameter) throws ParserException{
        if (!data.containsKey(section)){
            throw new ParserException("Section" + section.toString() + "doesn't exist");
        }
        if (!data.get(section).containsKey(parameter)){
            throw new ParserException("Parametr "+ parameter.toString() + " in section " + section.toString() + " doesn't exist");
        }
    }

    public void print(){
        System.out.println(this.data.toString());
    }
}
