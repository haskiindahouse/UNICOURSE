package unicourse.seventh_task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        var author = "TestAuthor";
        var title = "Заголовок";
        var count = 100;
        var category = "Book";
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("1");
        keywords.add("2");
        PaperJSON test = new PaperJSON(author, title, count, category, keywords);


        try (FileWriter file = new FileWriter("test.json")) {
            file.write(test.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(test);

    }
}
