package unicourse.seventh_task;

//import org.json.simple.JSONObject;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaperJSON extends JSONObject
{
    enum Properties
    {
        Title,
        Author,
        Count,
        Category,
        KeyWords
    }

    private String _title;
    public String title()
    {
        return _title;
    }

    private String _author;
    public String author()
    {
        return _author;
    }

    private int _count;
    public int count()
    {
        return _count;
    }
    private ArrayList<String> _keywords;
    public ArrayList<String> keywords()
    { return _keywords;}

    public Object propertyValueByKey(Properties prop)
    {
        return switch (prop) {
            case Title -> _title;
            case Author -> _author;
            case Count -> _count;
            case Category -> _category;
            case KeyWords -> _keywords;
        };
    }

    String _category;
    public String category()
    {
        return _category;
    }

    PaperJSON(String author, String title, int count, String category, ArrayList<String> keywords)
    {
        _author = author;
        _title = title;
        _count = count;
        _category = category;
        _keywords = keywords;
    }
    @Override
    public String toString()
    {
        Map<String, Object> serializeMap = new HashMap<String, Object>();
        for (Properties prop : Properties.values())
            serializeMap.put(prop.name(), propertyValueByKey(prop));

        return serializeMap.toString();
    }

}
