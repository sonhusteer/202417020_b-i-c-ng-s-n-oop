package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCDToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfCost;
    private JTextField tfArtist;

    public AddCDToStoreScreen(Store store, StoreScreen storeScreen) {
        super("Add CD to Store", store, storeScreen);
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
        tfCost     = addRow(form, gbc, 3, "Cost ($):");
        tfArtist   = addRow(form, gbc, 4, "Artist:");

        return form;
    }

    @Override
    protected boolean onSubmit() {
        String title    = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String director = tfDirector.getText().trim();
        String costStr  = tfCost.getText().trim();
        String artist   = tfArtist.getText().trim();

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

        CompactDisc cd = new CompactDisc(title, category,
                director.isEmpty() ? null : director,
                cost,
                artist.isEmpty() ? "Unknown" : artist);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this,
                "CD \"" + title + "\" added to store.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}
