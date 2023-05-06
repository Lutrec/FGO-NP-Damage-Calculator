package com.example.damagecalculator;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class Controller implements Initializable {

    //variables for the damageFormula method
    private int servantAttack;
    private double npMultiplier;
    private double cardDamageModifier;
    private double cardBuffs;
    private double cardDebuffs;
    private double classAttackModifier;
    private double advantageModifier;
    private double attributeModifier;
    private double attackBuffs;
    private double attackDebuffs;
    private double defenceDebuffs;
    private double defenceBuffs;
    private double damageReductionModifier;
    private double specialAttackBuffs;
    private double specialDefenceBuffs;
    private double npDamageBuffs;
    private double npDamageDebuffs;
    private double npExtraDamageModifier;
    private int flatDamageBuffs;
    private int damageCutBuffs;

    //editable textfields
    @FXML
    private TextField servantAttack_txf;
    @FXML
    private TextField npMultiplier_txf;
    @FXML
    private TextField attackBuffs_txf;
    @FXML
    private TextField attackDebuffs_txf;
    @FXML
    private TextField cardBuffs_txf;
    @FXML
    private TextField cardDebuffs_txf;
    @FXML
    private TextField npDamageBuffs_txf;
    @FXML
    private TextField npDamageDebuffs_txf;
    @FXML
    private TextField specialAttackBuffs_txf;
    @FXML
    private TextField specialDefenceBuffs_txf;
    @FXML
    private TextField flatDamageBuffs_txf;
    @FXML
    private TextField damageCutBuffs_txf;
    @FXML
    private TextField defenceDebuffs_txf;
    @FXML
    private TextField defenceBuffs_txf;
    @FXML
    private TextField npExtraDamage_txf;
    @FXML
    private TextField damageReduction_txf;
    @FXML
    private TextField enemyHP_txf;

    //non-editable textfields
    @FXML
    private TextField damageDisplayLOW_txf;
    @FXML
    private TextField damageDisplayAVERAGE_txf;
    @FXML
    private TextField damageDisplayHIGH_txf;
    @FXML
    private TextField hpDisplayLOW_txf;
    @FXML
    private TextField hpDisplayAVERAGE_txf;
    @FXML
    private TextField hpDisplayHIGH_txf;


    //comboboxes for the class, class advantage and attribute
    @FXML
    private ComboBox<String> class_cbx;

    @FXML
    private ComboBox<String> advantage_cbx;

    @FXML
    private ComboBox<String> attribute_cbx;

    //method to populate the comboboxes
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        class_cbx.setItems(FXCollections.observableArrayList("Saber (1,0x)", "Archer (0,95x)", "Lancer (1,05x)", "Rider (1,0x)", "Caster (0,9x)", "Assassin (0,9x)", "Berserker (1,1x)", "Ruler (1,1x)", "Avenger (1,1x)", "Moon Cancer (1,0x)", "Alter Ego (1,0x)", "Foreigner (1,0x)", "Pretender (1,0x)", "Beast (1,0x)"));
        advantage_cbx.setItems(FXCollections.observableArrayList("Neutral", "Yes (2x)", "No (0,5x)", "Berserker, Alter Ego, Pretender, Beast (1,5x)"));
        attribute_cbx.setItems(FXCollections.observableArrayList("Neutral", "Yes (1,1x)", "No (0,9x)"));
    }

    @FXML
    private ToggleGroup cardColour_tgb;

    /*methods to make the first two groups persistent (so there's always a button selected). It doesn't work quite well,
         if you click for the first time the button selected by default (in the first method the "first attack" button) it gets deselected
        */
    @FXML
    private void cardColourPersistentChoice() {
        cardColour_tgb.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> {
            if (newVal == null)
                oldVal.setSelected(true);
        });
    }

    //togglebuttons for the selection of the type of attack
    @FXML
    ToggleButton buster_btn;
    @FXML
    ToggleButton arts_btn;
    @FXML
    ToggleButton quick_btn;

    private void cardDamageModifierSelection() {
        if (buster_btn.isSelected()) {
            cardDamageModifier = 1.5;
        } else if (arts_btn.isSelected()) {
            cardDamageModifier = 1;
        } else if (quick_btn.isSelected()) {
            cardDamageModifier = 0.8;
        }
    }

    //formatter for the textfields, only numbers from 0 to 9 are accepted
    UnaryOperator<TextFormatter.Change> integerFilter = change -> {
        String newText = change.getControlNewText();
        if (newText.matches("([0-9]*)")) {
            return change;
        }
        return null;
    };

    //method to format and validate the inputs coming from the textfields, don't know if there's a better and cleaner way to do it.
    @FXML
    private void servantAttackInputCheck() {
        servantAttack_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void npMultiplierInputCheck() {
        npMultiplier_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void attackBuffsInputCheck() {
        attackBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void attackDebuffsInputCheck() {
        attackDebuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void cardBuffsInputCheck() {
        cardBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void cardDebuffsInputCheck() {
        cardDebuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void npDamageBuffsInputCheck() {
        npDamageBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void npDamageDebuffsInputCheck() {
        npDamageDebuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void specialAttackBuffsInputCheck() {
        specialAttackBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void specialDefenceBuffsInputCheck() {
        specialDefenceBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void flatDamageBuffsInputCheck() {
        flatDamageBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void damageCutBuffsInputCheck() {
        damageCutBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void defenceDebuffsInputCheck() {
        defenceDebuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void defenceBuffsInputCheck() {
        defenceBuffs_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void npExtraDamageInputCheck() {
        npExtraDamage_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void damageReductionInputCheck() {
        damageReduction_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    private void enemyHPInputCheck() {
        enemyHP_txf.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    }

    //method for the selection of the classAttackModifier
    @FXML
    private void classSelection() {
        int class_select = class_cbx.getSelectionModel().getSelectedIndex();

        if (class_select == 0 || class_select == 3 || class_select == 9 || class_select == 10 || class_select == 11 || class_select == 12 || class_select == 13) {
            classAttackModifier = 1; //saber, rider, moon cancer, alter ego, foreigner, pretender, beast class modifier
        } else if (class_select == 1) {
            classAttackModifier = 0.95; //archer class modifier
        } else if (class_select == 2) {
            classAttackModifier = 1.05; //lancer class modifier
        } else if (class_select == 4 || class_select == 5) {
            classAttackModifier = 0.9; //caster, assassin class modifier
        } else if (class_select == 6 || class_select == 7 || class_select == 8) {
            classAttackModifier = 1.1; //berserker, ruler, avenger class modifier
        }
    }

    //method for the selection of the advantageModifier
    @FXML
    private void advantageSelection() {
        int advantage_select = advantage_cbx.getSelectionModel().getSelectedIndex();

        if (advantage_select == 0) {
            advantageModifier = 1; //neutral damage
        } else if (advantage_select == 1) {
            advantageModifier = 2; //double damage
        } else if (advantage_select == 2) {
            advantageModifier = 0.5; //half damage
        } else if (advantage_select == 3) {
            advantageModifier = 1.5; //one and a half damage
        }
    }

    //method for the selection of the attributeModifier
    @FXML
    private void attributeSelection() {
        int attribute_select = attribute_cbx.getSelectionModel().getSelectedIndex();

        if (attribute_select == 0) {
            attributeModifier = 1;
        } else if (attribute_select == 1) {
            attributeModifier = 1.1;
        } else if (attribute_select == 2) {
            attributeModifier = 0.9;
        }
    }

    //method for the caculate button
    @FXML
    private void displayCalculationResults() {

        damageDisplayLOW_txf.setText(String.format("%,2d", npDamageFormula(0.9)));
        damageDisplayAVERAGE_txf.setText(String.format("%,2d", npDamageFormula(1)));
        damageDisplayHIGH_txf.setText(String.format("%,2d", npDamageFormula(1.1)));
        hpRemainDisplay();
    }

    //method for the main reset button
    @FXML
    private void resetCalculationResults() {

        damageDisplayLOW_txf.setText(null);
        damageDisplayAVERAGE_txf.setText(null);
        damageDisplayHIGH_txf.setText(null);
        hpDisplayLOW_txf.setText(null);
        hpDisplayAVERAGE_txf.setText(null);
        hpDisplayHIGH_txf.setText(null);

        servantAttack_txf.setText("");
        npMultiplier_txf.setText("");
        attackBuffs_txf.setText("");
        attackDebuffs_txf.setText("");
        cardBuffs_txf.setText("");
        cardDebuffs_txf.setText("");
        npDamageBuffs_txf.setText("");
        npDamageDebuffs_txf.setText("");
        specialAttackBuffs_txf.setText("");
        specialDefenceBuffs_txf.setText("");
        flatDamageBuffs_txf.setText("");
        damageCutBuffs_txf.setText("");
        defenceDebuffs_txf.setText("");
        defenceBuffs_txf.setText("");
        npExtraDamage_txf.setText("");
        damageReduction_txf.setText("");

        class_cbx.valueProperty().set(null);
        advantage_cbx.valueProperty().set(null);
        attribute_cbx.valueProperty().set(null);
    }

    //method for the refresh button
    @FXML
    private void refreshEnemyHPCalculations() {
        hpRemainDisplay();
    }

    //method to calculate the fgo np damage formula
    private int npDamageFormula(double randomModifier) {

        cardDamageModifierSelection();
        servantAttackGetValue();
        npMultiplierGetValue();
        attackBuffsGetValue();
        attackDebuffsGetValue();
        cardBuffsGetValue();
        cardDebuffsGetValue();
        npDamageBuffsGetValue();
        npDamageDebuffsGetValue();
        specialAttackBuffsGetValue();
        specialDefenceBuffsGetValue();
        defenceDebuffsGetValue();
        defenceBuffsGetValue();
        flatDamageBuffsGetValue();
        damageCutBuffsGetValue();
        npExtraDamageGetValue();
        damageReductionGetValue();

        /*
         damage = [servantAtk * npMultiplier * {firstCardBusterModifier + [cardDamageModifier * (1 + cardBuffs - cardDebuffs)]} *
           classAtkModifier * advantageModifier * attributeModifier * randomModifier * 0.23 *
         (1 + attackBuffs - attackDebuffs + defenceDebuffs - defenceBuffs ) * critModifier * [(1 + extraCardBuffs) * extraCardModifier] *
         (1 - damageReduction) * {1 + specialAttackBuffs - specialDefenceBuffs + [(critDamageBuffs - critDamageDebuffs) * isCrit] +
         [(npDamageBuffs - npDamageDebuffs) * isNP]} * (1 + npExtraDamageModifier)] + flatDamageBuffs - damageCutBuffs + (servantAtk * busterChainModifier)
        */

        //damage formula
        int npDamage = (int) (servantAttack * npMultiplier * (cardDamageModifier * (1 + cardBuffs - cardDebuffs)) *
                classAttackModifier * advantageModifier * attributeModifier * randomModifier * 0.23 *
                (1 + attackBuffs - attackDebuffs + defenceDebuffs - defenceBuffs) * (1 - damageReductionModifier) *
                (1 + specialAttackBuffs - specialDefenceBuffs + npDamageBuffs - npDamageDebuffs) *
                (1 + npExtraDamageModifier)) + flatDamageBuffs - damageCutBuffs;

        return npDamage;
    }

    private void hpRemainDisplay() {
        int enemyHP;
        if (enemyHP_txf.getText().isEmpty()) {
            enemyHP = 0;
        } else {
            enemyHP = Integer.parseInt(enemyHP_txf.getText());
        }
        int hpLeftLOW = enemyHP - npDamageFormula(0.9);
        int hpLeftAVERAGE = enemyHP - npDamageFormula(1);
        int hpLeftHIGH = enemyHP - npDamageFormula(1.1);
        if (hpLeftLOW > 0) {
            hpDisplayLOW_txf.setText(String.format("%,2d", hpLeftLOW));
        } else {
            hpDisplayLOW_txf.setText("0");
        }
        if (hpLeftAVERAGE > 0) {
            hpDisplayAVERAGE_txf.setText(String.format("%,2d", hpLeftAVERAGE));
        } else {
            hpDisplayAVERAGE_txf.setText("0");
        }
        if (hpLeftHIGH > 0) {
            hpDisplayHIGH_txf.setText(String.format("%,2d", hpLeftHIGH));
        } else {
            hpDisplayHIGH_txf.setText("0");
        }
    }


    //methods for obtaining the editable textfields' inputs, if they're empty the default value (the prompt text's one) is used
    private void servantAttackGetValue() {
        if (servantAttack_txf.getText().isEmpty()) {
            servantAttack = 0;
        } else {
            servantAttack = Integer.parseInt(servantAttack_txf.getText());
        }
    }

    private void npMultiplierGetValue() {
        if (npMultiplier_txf.getText().isEmpty()) {
            npMultiplier = 0;
        } else {
            npMultiplier = Double.parseDouble(npMultiplier_txf.getText()) / 100;
        }
    }

    private void attackBuffsGetValue() {
        if (attackBuffs_txf.getText().isEmpty()) {
            attackBuffs = 0;
        } else {
            attackBuffs = Double.parseDouble(attackBuffs_txf.getText()) / 100;
        }
    }

    private void attackDebuffsGetValue() {
        if (attackDebuffs_txf.getText().isEmpty()) {
            attackDebuffs = 0;
        } else {
            attackDebuffs = Double.parseDouble(attackDebuffs_txf.getText()) / 100;
        }
    }

    private void cardBuffsGetValue() {
        if (cardBuffs_txf.getText().isEmpty()) {
            cardBuffs = 0;
        } else {
            cardBuffs = Double.parseDouble(cardBuffs_txf.getText()) / 100;
        }
    }

    private void cardDebuffsGetValue() {
        if (cardDebuffs_txf.getText().isEmpty()) {
            cardDebuffs = 0;
        } else {
            cardDebuffs = Double.parseDouble(cardDebuffs_txf.getText()) / 100;
        }
    }

    private void npDamageBuffsGetValue() {
        if (npDamageBuffs_txf.getText().isEmpty()) {
            npDamageBuffs = 0;
        } else {
            npDamageBuffs = Double.parseDouble(npDamageBuffs_txf.getText()) / 100;
        }
    }

    private void npDamageDebuffsGetValue() {
        if (npDamageDebuffs_txf.getText().isEmpty()) {
            npDamageDebuffs = 0;
        } else {
            npDamageDebuffs = Double.parseDouble(npDamageDebuffs_txf.getText()) / 100;
        }
    }

    private void specialAttackBuffsGetValue() {
        if (specialAttackBuffs_txf.getText().isEmpty()) {
            specialAttackBuffs = 0;
        } else {
            specialAttackBuffs = Double.parseDouble(specialAttackBuffs_txf.getText()) / 100;
        }
    }

    private void specialDefenceBuffsGetValue() {
        if (specialDefenceBuffs_txf.getText().isEmpty()) {
            specialDefenceBuffs = 0;
        } else {
            specialDefenceBuffs = Double.parseDouble(specialDefenceBuffs_txf.getText()) / 100;
        }
    }

    private void defenceDebuffsGetValue() {
        if (defenceDebuffs_txf.getText().isEmpty()) {
            defenceDebuffs = 0;
        } else {
            defenceDebuffs = Double.parseDouble(defenceDebuffs_txf.getText()) / 100;
        }
    }

    private void defenceBuffsGetValue() {
        if (defenceBuffs_txf.getText().isEmpty()) {
            defenceBuffs = 0;
        } else {
            defenceBuffs = Double.parseDouble(defenceBuffs_txf.getText()) / 100;
        }
    }

    private void flatDamageBuffsGetValue() {
        if (flatDamageBuffs_txf.getText().isEmpty()) {
            flatDamageBuffs = 0;
        } else {
            flatDamageBuffs = Integer.parseInt(flatDamageBuffs_txf.getText());
        }
    }

    private void damageCutBuffsGetValue() {
        if (damageCutBuffs_txf.getText().isEmpty()) {
            damageCutBuffs = 0;
        } else {
            damageCutBuffs = Integer.parseInt(damageCutBuffs_txf.getText());
        }
    }

    private void npExtraDamageGetValue() {
        if (npExtraDamage_txf.getText().isEmpty()) {
            npExtraDamageModifier = 0;
        } else {
            npExtraDamageModifier = Double.parseDouble(npExtraDamage_txf.getText()) / 100;
        }
    }

    private void damageReductionGetValue() {
        if (damageReduction_txf.getText().isEmpty()) {
            damageReductionModifier = 0;
        } else {
            damageReductionModifier = Double.parseDouble(damageReduction_txf.getText()) / 100;
        }
    }
}