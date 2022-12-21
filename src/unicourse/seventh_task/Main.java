package unicourse.seventh_task;

import com.beust.ah.A;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.awt.print.Paper;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        var author = "TestAuthor";
        var title = "Заголовок";
        var count = 100;
        var category = "Book";
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("1");
        keywords.add("2");
        PaperJSON test = new PaperJSON(author, title, count, category, keywords);
        PaperJSON test2 = new PaperJSON("Test2", title, count, category, keywords);
        PaperJSON test3 = new PaperJSON("Test3", title, count, category, keywords);
        ArrayList<PaperJSON> writeTest = new ArrayList<PaperJSON>();
        writeTest.add(test);
        writeTest.add(test2);
        writeTest.add(test3);

        try (FileWriter file = new FileWriter("test.json")) {
            file.write("{\n");
            for (int i = 0; i < writeTest.size(); ++i)
            {
                var key = Integer.toString(i);
                file.write(key + " :\n");
                file.write(writeTest.get(i).toString() + ",\n");
            }
            file.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new FileReader("test.json"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        ArrayList<PaperJSON> readTest = new ArrayList<PaperJSON>();
        String content = stringBuilder.toString();
        var list = content.split(",");
        boolean startNew = false;
        HashMap<String, Object> deserializeMap = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> jsonObjects = new ArrayList<HashMap<String, Object>>();
        String lastProp = new String();
        ArrayList<Integer> keyWords = new ArrayList<Integer>();
        for (var splitted : list)
        {
            int newIndex = splitted.indexOf(':');
            if (newIndex != -1)
            {
                startNew = true;
                jsonObjects.add(deserializeMap);
                deserializeMap.clear();
                keyWords.clear();
                continue;
            }
            else if (!startNew) continue;

            int propValue = splitted.indexOf('=');
            if (propValue == -1 && lastProp.isEmpty())
            {
                startNew = false;
                continue;
            }

            if (propValue != -1)
            {
                var propSplited = splitted.split("=");
                lastProp = propSplited[0];
                if (Objects.equals(lastProp.trim(), "KeyWords"))
                {
                    keyWords.add(Integer.valueOf(propSplited[1].replace("[", "").trim()));
                    continue;
                }

                deserializeMap.put(lastProp, propSplited[1]);
            }

            int findClose = splitted.indexOf("]");
            if (Objects.equals(lastProp.trim(), "KeyWords"))
            {
                if (findClose == -1)
                    keyWords.add(Integer.valueOf(splitted.replace(",", "").trim()));
                else
                {
                    keyWords.add(Integer.valueOf(splitted.replace("]", "").replace("}", "").trim()));
                    deserializeMap.put(lastProp, keyWords);
                    lastProp = new String();
                }
            }
        }

        System.out.println(jsonObjects);
        System.out.println("-------");
    }
}
