package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDVDToStoreScreen(Store store, StoreScreen storeScreen) {
        super("Add DVD to Store", store, storeScreen);
    }

    @Override
    protected JPanel createForm() {
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        tfTitle    = addRow(form, gbc, 0, "Title:");
        tfCategory = addRow(form, gbc, 1, "Category:");
        tfDirector = addRow(form, gbc, 2, "Director:");
        tfLength   = addRow(form, gbc, 3, "Length (minutes):");
        tfCost     = addRow(form, gbc, 4, "Cost ($):");

        return form;
    }

    @Override
    protected boolean onSubmit() {
        String title    = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String director = tfDirector.getText().trim();
        String lenStr   = tfLength.getText().trim();
        String costStr  = tfCost.getText().trim();

        if (title.isEmpty() || category.isEmpty() || costStr.isEmpty()) {
            showError("Title, Category and Cost are required.");
            return false;
        }

        float cost;
        try {
            cost = Float.parseFloat(costStr);
            if (cost < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            showError("Cost must be a non-negative number.");
            return false;
        }

        int length = 0;
        if (!lenStr.isEmpty()) {
            try {
                length = Integer.parseInt(lenStr);
                if (length < 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                showError("Length must be a non-negative integer.");
                return false;
            }
        }

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                title, category,
                director.isEmpty() ? null : director,
                length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this,
                "DVD \"" + title + "\" added to store.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}
