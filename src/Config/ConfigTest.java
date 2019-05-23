package Config;
public class ConfigTest {
    public static void main(String[] args) throws ParserException {
        try {
            IniConfig parser = new IniConfig("C:\\Users\\CrazyOnionMan\\IdeaProjects\\untitled\\src\\Config\\config.ini");
            parser.print();
            System.out.println(parser.getDoubleValue("COMMON", "ttsad"));
            String t = new String("sasd");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
