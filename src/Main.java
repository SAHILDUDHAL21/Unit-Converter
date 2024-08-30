import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            UnitConverter converter = new UnitConverter();
            converter.setVisible(true);
        });
    }
}