import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;



abstract class CurrencyConverter {
    public double rate;

    abstract void setRate(double rate);

    abstract double convert(double amount,String fromCurrency,String toCurrency) ;


}

public class CurrencyConverterGUI extends JFrame implements ActionListener {
    private static final String API_KEY = "b84ec73e3c8d5bc6bb471a88";
    private static final String API_ENDPOINT = "https://v6.exchangerate-api.com/v6/b84ec73e3c8d5bc6bb471a88/latest/USD";
    public static String[] CURRENCIES = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "NZD", "CHF", "HKD", "SGD"};
    public static final double[] RATES = new double[CURRENCIES.length];

    public static JFrame f;
    public static JLabel amountLabel, fromLabel, toLabel, resultLabel;
    public static JComboBox<String> fromCurrencyBox, toCurrencyBox;
    public static JTextField AmountField;
    public static JPanel p;

    public void main(String[] args) {
        f = new JFrame("CURENCIO");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 350);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        amountLabel.setBounds(15, 10, 100, 34);

        AmountField = new JTextField("$1");
        AmountField.setBounds(10, 40, 180, 34);

        fromLabel = new JLabel("From");
        fromLabel.setFont(new Font("Arial", Font.BOLD, 16));
        fromLabel.setBounds(15, 70, 80, 34);

        toLabel = new JLabel("To");
        toLabel.setFont(new Font("Arial", Font.BOLD, 16));
        toLabel.setBounds(15, 130, 80, 34);

        fromCurrencyBox = new JComboBox<>(CURRENCIES);
        fromCurrencyBox.setBounds(5, 105, 200, 25);

        toCurrencyBox = new JComboBox<>(CURRENCIES);
        toCurrencyBox.setBounds(5, 165, 200, 25);

        p = new JPanel();
        p.setLocation(300, 150);

        JButton converterButton = new JButton("Convert");
        converterButton.setBackground(Color.RED);
        converterButton.setBounds(10, 220, 280, 40);
        CurrencyConverterGUI cg = new CurrencyConverterGUI();
        converterButton.addActionListener(cg);
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
    void setRate(double rate) {
    }

    public double convert(double amount,String fromCurrency,String toCurrency){
        double usd = 1, ind = 83, rateTo = 20;
        double rateFrom = usd / ind;
        double result = rateFrom * rateTo;
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (e.getSource() == s) {
            double amount = Double.parseDouble(AmountField.getText());
            System.out.println(amount);
            String fromCurrency = (String) fromCurrencyBox.getSelectedItem();
            String toCurrency = (String) toCurrencyBox.getSelectedItem();
            double result = convert(amount,fromCurrency,toCurrency);

            resultLabel = new JLabel(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
            resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
            resultLabel.setForeground(Color.BLUE);
            resultLabel.setBounds(10, 200, 280, 20);
            f.add(resultLabel);
            f.revalidate();
        }

    }
}



