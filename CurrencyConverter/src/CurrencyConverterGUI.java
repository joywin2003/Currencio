import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


abstract class CurrencyConverter {
    public double rate;

    abstract void setRate(double rate);

    abstract double convert(double amount) ;

    abstract String getCurrencyName();
}
public class CurrencyConverterGUI extends JFrame {
    private static final String API_KEY = "b84ec73e3c8d5bc6bb471a88";
    private static final String API_ENDPOINT = "https://v6.exchangerate-api.com/v6/b84ec73e3c8d5bc6bb471a88/latest/USD";
    public static String[] CURRENCIES = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "NZD", "CHF", "HKD", "SGD"};
    public static final double[] RATES = new double[CURRENCIES.length];

    public static JFrame f;
    public static JLabel amountLabel,fromLabel,toLabel,lastUpdatedLabel;
    public static JComboBox<String> fromCurrencyBox,toCurrencyBox;
    public static JTextField AmountField;
    public static JPanel p;


    public static void main(String[] args) {
        f = new JFrame("CURENCIO");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 350);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(15, 10, 100, 34);

        AmountField = new JTextField("$1");
        AmountField.setBounds(10, 40, 180, 34);

        fromLabel = new JLabel("From");
        fromLabel.setBounds(15, 70, 80, 34);

        toLabel = new JLabel("To");
        toLabel.setBounds(15, 130, 80, 34);

        fromCurrencyBox = new JComboBox<>(CURRENCIES);
        fromCurrencyBox.setBounds(5, 105, 200, 25);

        toCurrencyBox = new JComboBox<>(CURRENCIES);
        toCurrencyBox.setBounds(5, 165, 200, 25);

        p = new JPanel();
        p.setLocation(300, 150);

        JButton converterButton = new JButton("Convert");
        converterButton.setBackground(Color.BLUE);
        converterButton.setBounds(10, 220, 280, 40);

        f.add(amountLabel);
        f.add(AmountField);
        f.add(fromLabel);
        f.add(toLabel);
        f.add(fromCurrencyBox);
        f.add(toCurrencyBox);
        f.add(converterButton);
        f.add(p);
        f.setVisible(true);
    }
}


