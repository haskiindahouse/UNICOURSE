package unicourse.fourth_task;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

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
        _listOfPapers = new JList<String>();

        comps.add(new JLabel("Author"));
        comps.add(_authorTextField);

        comps.add(new JLabel("Title"));
        comps.add(_titleTextField);

        comps.add(new JLabel("Count"));
        comps.add(_countTextField);

        comps.add(new JLabel("Category"));
        comps.add(_categoryComboBox);

        //comps.add(addPaperBtn);
        add(comps);
    }

    private void addPaperButtonPressed()
    {
        System.out.println("hello");
    }

    private JTextField _authorTextField;
    private JTextField _titleTextField;
    private JTextField _countTextField;
    private JComboBox _categoryComboBox;
    private JList<String> _listOfPapers;
    static final String[] categories = {"WEB", "MOBILE", "BIG DATA", "EMBEDDED"};
}
