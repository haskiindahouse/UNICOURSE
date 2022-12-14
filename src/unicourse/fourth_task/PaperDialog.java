package unicourse.fourth_task;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import unicourse.seventh_task.PaperJSON;

import org.json.JSONTokener;
import javax.swing.*;
import java.awt.*;
import org.json.JSONArray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

public class PaperDialog extends JFrame
{
    public PaperDialog()
    {
        super("Редактор статей");
        createUi();
        pack();
        setVisible(true);
    }

    private void createUi()
    {
        GridLayout mainLayout = new GridLayout(5, 2);
        final JPanel comps = new JPanel();

        JButton b = new JButton("Just fake button");
        final int maxGap = 20;
        Dimension buttonSize = b.getPreferredSize();
        comps.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));

        comps.setLayout(mainLayout);
        JButton addPaperBtn = new JButton("addPaper");
        addPaperBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPaperButtonPressed();
            }
        });

        _authorTextField = new JTextField("Петров");
        _titleTextField = new JTextField("HTML + CSS + JS");
        _countTextField = new JTextField("500");
        _categoryComboBox = new JComboBox(categories);
        _modeListOfPapers = new DefaultListModel<String>();
        _listOfPapers = new JList<String>(_modeListOfPapers);

        comps.add(new JLabel("Author"));
        comps.add(_authorTextField);

        comps.add(new JLabel("Title"));
        comps.add(_titleTextField);

        comps.add(new JLabel("Count"));
        comps.add(_countTextField);

        comps.add(new JLabel("Category"));
        comps.add(_categoryComboBox);
        comps.add(addPaperBtn);
        comps.add(_listOfPapers);
        //comps.add(addPaperBtn);
        add(comps);
    }

    private void loadFromFile()
    {
        JSONParser tokener = new JSONParser("test.json");
        JSONObject root = new JSONObject(tokener);

    }


    private void addPaperButtonPressed()
    {

        var author = _authorTextField.getText();
        var title = _titleTextField.getText();
        var count = Integer.valueOf(_countTextField.getText());
        var keywords = _categoryComboBox.getSelectedItem().toString();
        var paper = new PaperJSON(author, title, count, keywords, new ArrayList<String>(Arrays.asList(keywords)));
        try (FileWriter file = new FileWriter("test.json")) {
            file.write(paper.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        _modeListOfPapers.addElement(paper.toViewString());
    }

    private JTextField _authorTextField;
    private JTextField _titleTextField;
    private JTextField _countTextField;
    private JComboBox _categoryComboBox;
    private JList<String> _listOfPapers;
    private DefaultListModel<String> _modeListOfPapers;
    static final String[] categories = {"WEB", "MOBILE", "BIG DATA", "EMBEDDED"};
}
