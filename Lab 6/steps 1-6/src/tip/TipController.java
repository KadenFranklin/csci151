package tip;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TipController {

    @FXML
    private TextField bill;

    @FXML
    private ChoiceBox<Service> tips;

    @FXML
    private TextField total;

    @FXML
    private TextField people;

    @FXML
    private TextField individual;

    @FXML
    public void initialize() {
        bill.setEditable(true);
        total.setEditable(false);
        people.setEditable(true);
        individual.setEditable(false);
        for (Service s: Service.values()) {
            tips.getItems().add(s);
        }
        tips.getSelectionModel().select(Service.GOOD);
    }

    @FXML
    public void calculate() {
        double billEntered = Double.parseDouble(bill.getText());
        int numPeople = Integer.parseInt(people.getText());
        Service level = tips.getSelectionModel().getSelectedItem();
        double totalAmount = level.computeTotal(billEntered);
        total.setText(String.format("%7.2f", totalAmount));
        double n = totalAmount / numPeople;
        individual.setText(String.format("%7.2f", n));
    }
}