import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Expenses extends JFrame{
	private final int WIDTH = 500;
    private final int HEIGHT = 500;
    JPanel panel = new JPanel();
    private JLabel numberOfDaysLabel;
    private JLabel amountAirfareLabel;
    private JLabel amontRentalFeeLabel;
    private JLabel numberMilesLabel;
    private JLabel parkingFeeLabel;
    private JLabel seminarFeeLabel;
    private JLabel lodgingFeeLabel;
    private JTextField daysField;
    private JTextField amountAirfareField;
    private JTextField rentalFeeField;
    private JTextField milesDrivenField;
    private JTextField parkingFeeField;
    private JTextField smeinarFeeField;
    private JTextField lodgingFeeField;
    private JButton calculateButton;
 
    public Expenses() {
        setTitle("Travel Expenses");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
 
    }
 
    private void buildPanel() {
 
        numberOfDaysLabel = new JLabel("Number of days on the trip: ");
        daysField = new JTextField(10);
 
        amountAirfareLabel = new JLabel("Amount of airfare: ");
        amountAirfareField = new JTextField(10);
 
        amontRentalFeeLabel = new JLabel("Amount of car rental fee: ");
        rentalFeeField = new JTextField(10);
 
        numberMilesLabel = new JLabel("Number of miles driven: ");
        milesDrivenField = new JTextField(10);
 
        parkingFeeLabel = new JLabel("Amount of parking fees: ");
        parkingFeeField = new JTextField(10);
 
 
        seminarFeeLabel = new JLabel("Conference or seminar registration fees: ");
        smeinarFeeField = new JTextField(10);
 
        lodgingFeeLabel = new JLabel("Lodging charges, per night");
        lodgingFeeField = new JTextField(10);
 
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new buttonListener());
        panel = new JPanel(new GridLayout(9, 2, 5, 10));
 
        panel.add(numberOfDaysLabel);
        panel.add(daysField);
        panel.add(amountAirfareLabel);
        panel.add(amountAirfareField);
        panel.add(amontRentalFeeLabel);
        panel.add(rentalFeeField);
        panel.add(numberMilesLabel);
        panel.add(milesDrivenField);
        panel.add(parkingFeeLabel);
        panel.add(parkingFeeField);
        panel.add(seminarFeeLabel);
        panel.add(smeinarFeeField);
        panel.add(lodgingFeeLabel);
        panel.add(lodgingFeeField);
        panel.add(calculateButton);
 
    }
 
    public class buttonListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            String stringDay, stringAirfare, stringCarRental, stringMilesDriven, stringParkingFee, stringTaxiCharges, stringSeminarFee, stringLodgingFee;
            double totalAllowed, totalOwe, totalSaved, totalExpenses, numberDays, AirFare, CarRental, MilesDriven, ParkingFee, TaxiCharges, seminarFee, lodgingFee;
            final double dayMeal = 37.00;
            final double parkingFee = 10.00;
            final double lodgingCharge = 95.00;
            final double rentCar = 0.27;
            double totalMilesDriven;
 
            stringDay = daysField.getText();
            numberDays = Double.parseDouble(stringDay);
 
            stringAirfare = amountAirfareField.getText();
            AirFare = Double.parseDouble(stringAirfare);
 
            stringCarRental = rentalFeeField.getText();
            CarRental = Double.parseDouble(stringCarRental);
 
            stringMilesDriven = milesDrivenField.getText();
            MilesDriven = Double.parseDouble(stringMilesDriven);
 
            stringParkingFee = parkingFeeField.getText();
            ParkingFee = Double.parseDouble(stringParkingFee);
 
 
            stringSeminarFee = smeinarFeeField.getText();
            seminarFee = Double.parseDouble(stringSeminarFee);
 
            stringLodgingFee = lodgingFeeField.getText();
            lodgingFee = Double.parseDouble(stringLodgingFee);
 
            totalMilesDriven = MilesDriven * rentCar;
            totalExpenses = AirFare * CarRental * MilesDriven * ParkingFee * seminarFee * lodgingFee;
            totalAllowed = numberDays * dayMeal * parkingFee * lodgingCharge * rentCar * totalMilesDriven;
 
            if (totalExpenses > totalAllowed) {
                totalOwe = totalExpenses - totalAllowed;
            } else {
                totalOwe = 0;
            }
 
            if (totalAllowed > totalExpenses) {
                totalSaved = totalAllowed - totalExpenses;
            } else {
                totalSaved = 0;
            }
 

            System.out.println("The total expenses for the trip are " + totalExpenses
                    + " \nThe total allowed to spend is " + totalAllowed + "\nThe total you owe is "
                    + totalOwe + "\nTotal saved is " + totalSaved);
 
        }
    }
}
