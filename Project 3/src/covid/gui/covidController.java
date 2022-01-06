package covid.gui;

import covid.model.ReadFile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import java.io.File;

public class covidController {
    @FXML
    BorderPane pane;

    @FXML
    ImageView map3;

    @FXML
    Slider slider;

    @FXML
    TextField WA;

    @FXML
    TextField OR;

    @FXML
    TextField CA;

    @FXML
    TextField AK;

    @FXML
    TextField HI;

    @FXML
    TextField ID;

    @FXML
    TextField NV;

    @FXML
    TextField AZ;

    @FXML
    TextField UT;

    @FXML
    TextField CO;

    @FXML
    TextField NM;

    @FXML
    TextField WY;

    @FXML
    TextField MT;

    @FXML
    TextField ND;

    @FXML
    TextField SD;

    @FXML
    TextField NE;

    @FXML
    TextField KS;

    @FXML
    TextField OK;

    @FXML
    TextField TX;

    @FXML
    TextField LA;

    @FXML
    TextField AR;

    @FXML
    TextField MO;

    @FXML
    TextField IA;

    @FXML
    TextField MN;

    @FXML
    TextField WI;

    @FXML
    TextField IL;

    @FXML
    TextField MS;

    @FXML
    TextField AL;

    @FXML
    TextField GA;

    @FXML
    TextField FL;

    @FXML
    TextField TN;

    @FXML
    TextField KY;

    @FXML
    TextField IN;

    @FXML
    TextField OH;

    @FXML
    TextField MI;

    @FXML
    TextField SC;

    @FXML
    TextField NC;

    @FXML
    TextField VA;

    @FXML
    TextField WV;

    @FXML
    TextField PA;

    @FXML
    TextField NY;

    @FXML
    TextField ME;

    @FXML
    TextField VT;

    @FXML
    TextField NH;

    @FXML
    TextField MA;

    @FXML
    TextField RI;

    @FXML
    TextField CT;

    @FXML
    TextField NJ;

    @FXML
    TextField DE;

    @FXML
    TextField MD;

    public void setSlider() throws Exception {
        ReadFile.num = (int) slider.getValue();
        setStates(ReadFile.num);
        System.out.println(slider.getValue());
    }

    @FXML
    public void initialize() throws Exception {
        setmap();

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                try { setSlider(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        });

        WA = new TextField();
        OR = new TextField();
        CA = new TextField();
        AK = new TextField();
        HI = new TextField();
        ID = new TextField();
        NV = new TextField();
        AZ = new TextField();
        UT = new TextField();
        CO = new TextField();
        NM = new TextField();
        WY = new TextField();
        MT = new TextField();
        ND = new TextField();
        SD = new TextField();
        NE = new TextField();
        KS = new TextField();
        OK = new TextField();
        TX = new TextField();
        LA = new TextField();
        AR = new TextField();
        MO = new TextField();
        IA = new TextField();
        MN = new TextField();
        WI = new TextField();
        IL = new TextField();
        MS = new TextField();
        AL = new TextField();
        GA = new TextField();
        FL = new TextField();
        TN = new TextField();
        KY = new TextField();
        IN = new TextField();
        OH = new TextField();
        MI = new TextField();
        SC = new TextField();
        NC = new TextField();
        VA = new TextField();
        WV = new TextField();
        PA = new TextField();
        NY = new TextField();
        ME = new TextField();
        VT = new TextField();
        NH = new TextField();
        MA = new TextField();
        RI = new TextField();
        CT = new TextField();
        NJ = new TextField();
        DE = new TextField();
        MD = new TextField();
        TX = new TextField();

    }

    @FXML
    public void setStates(int num) throws Exception {
        AL.setText((ReadFile.readCellData("AL", num)));
        AK.setText((ReadFile.readCellData("AK", num)));
        AZ.setText((ReadFile.readCellData("AZ", num)));
        AR.setText((ReadFile.readCellData("AR", num)));
        CA.setText((ReadFile.readCellData("CA", num)));
        CO.setText((ReadFile.readCellData("CO", num)));
        CT.setText((ReadFile.readCellData("CT", num)));
        DE.setText((ReadFile.readCellData("DE", num)));
        FL.setText((ReadFile.readCellData("FL", num)));
        GA.setText((ReadFile.readCellData("GA", num)));
        HI.setText((ReadFile.readCellData("HI", num)));
        ID.setText((ReadFile.readCellData("ID", num)));
        IL.setText((ReadFile.readCellData("IL", num)));
        IN.setText((ReadFile.readCellData("IN", num)));
        IA.setText((ReadFile.readCellData("IA", num)));
        KS.setText((ReadFile.readCellData("KS", num)));
        KY.setText((ReadFile.readCellData("KY", num)));
        LA.setText((ReadFile.readCellData("LA", num)));
        ME.setText((ReadFile.readCellData("ME", num)));
        MD.setText((ReadFile.readCellData("MD", num)));
        MA.setText((ReadFile.readCellData("MA", num)));
        MI.setText((ReadFile.readCellData("MI", num)));
        MN.setText((ReadFile.readCellData("MN", num)));
        MS.setText((ReadFile.readCellData("MS", num)));
        MO.setText((ReadFile.readCellData("MO", num)));
        MT.setText((ReadFile.readCellData("MT", num)));
        NV.setText((ReadFile.readCellData("NV", num)));
        NE.setText((ReadFile.readCellData("NE", num)));
        NH.setText((ReadFile.readCellData("NH", num)));
        NJ.setText((ReadFile.readCellData("NJ", num)));
        NM.setText((ReadFile.readCellData("NM", num)));
        NY.setText((ReadFile.readCellData("NY", num)));
        NC.setText((ReadFile.readCellData("NC", num)));
        ND.setText((ReadFile.readCellData("ND", num)));
        OH.setText((ReadFile.readCellData("OH", num)));
        OK.setText((ReadFile.readCellData("OK", num)));
        OR.setText((ReadFile.readCellData("OR", num)));
        PA.setText((ReadFile.readCellData("PA", num)));
        RI.setText((ReadFile.readCellData("RI", num)));
        SC.setText((ReadFile.readCellData("SC", num)));
        SD.setText((ReadFile.readCellData("SD", num)));
        TN.setText((ReadFile.readCellData("TN", num)));
        TX.setText((ReadFile.readCellData("TX", num)));
        UT.setText((ReadFile.readCellData("UT", num)));
        VT.setText((ReadFile.readCellData("VT", num)));
        VA.setText((ReadFile.readCellData("VA", num)));
        WA.setText((ReadFile.readCellData("WA", num)));
        WV.setText((ReadFile.readCellData("WV", num)));
        WI.setText((ReadFile.readCellData("WI", num)));
        WY.setText((ReadFile.readCellData("WY", num)));

    }

    public void setmap() throws Exception {
        System.out.println("Looking for Image " + "covid/resources/map3.png");
        File f = new File("src/covid/resources/map3.png");
        map3.setImage(new Image(f.toURI().toString()));
        setStates(ReadFile.num);
    }
}