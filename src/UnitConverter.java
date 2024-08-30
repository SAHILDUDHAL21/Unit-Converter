import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame
{

    JComboBox<String> fuc;
    JComboBox<String> tuc;
    JTextField ifld;
    JTextField rf;

    String[] units = {"Meters", "Kilometers", "Centimeters", "Miles", "Inches", "Feet", "Yards"};

    public UnitConverter()
    {
        setTitle("Simple Unit Converter");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);

        JLabel fl = new JLabel("From:");
        fl.setBounds(20, 20, 80, 25);
        add(fl);

        fuc = new JComboBox<>(units);
        fuc.setBounds(100, 20, 160, 25);
        add(fuc);

        JLabel tl = new JLabel("To:");
        tl.setBounds(20, 50, 80, 25);
        add(tl);

        tuc = new JComboBox<>(units);
        tuc.setBounds(100, 50, 160, 25);
        add(tuc);

        JLabel il = new JLabel("Value:");
        il.setBounds(20, 80, 80, 25);
        add(il);

        ifld = new JTextField();
        ifld.setBounds(100, 80, 160, 25);
        add(ifld);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(100, 110, 160, 25);
        convertButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                convertUnits();
            }
        });
        add(convertButton);

        rf = new JTextField();
        rf.setBounds(100, 140, 160, 25);
        rf.setEditable(false);
        add(rf);
    }

    void convertUnits()
    {
        try
        {
            double iV = Double.parseDouble(ifld.getText());
            String fU = (String) fuc.getSelectedItem();
            String tU = (String) tuc.getSelectedItem();
            double rV = convert(fU, tU, iV);
            rf.setText(String.format("%.4f", rV));
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    double convert(String fU, String tU, double value)
    {
        double valueInMeters = switch (fU)
        {
            case "Meters" -> value;
            case "Kilometers" -> value * 1000;
            case "Centimeters" -> value / 100;
            case "Miles" -> value * 1609.34;
            case "Inches" -> value * 0.0254;
            case "Feet" -> value * 0.3048;
            case "Yards" -> value * 0.9144;
            default -> 0;
        };

        return switch (tU)
        {
            case "Meters" -> valueInMeters;
            case "Kilometers" -> valueInMeters / 1000;
            case "Centimeters" -> valueInMeters * 100;
            case "Miles" -> valueInMeters / 1609.34;
            case "Inches" -> valueInMeters / 0.0254;
            case "Feet" -> valueInMeters / 0.3048;
            case "Yards" -> valueInMeters / 0.9144;
            default -> 0;
        };
    }


}
