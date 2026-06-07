package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, StoreScreen storeScreen) {
        super("Add Book to Store", store, storeScreen);
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
        tfCost     = addRow(form, gbc, 2, "Cost ($):");
        tfAuthors  = addRow(form, gbc, 3, "Authors (comma-separated):");

        return form;
    }

    @Override
    protected boolean onSubmit() {
        String title    = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr  = tfCost.getText().trim();
        String authors  = tfAuthors.getText().trim();

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

        Book book = new Book(title, category, cost);
        if (!authors.isEmpty()) {
            for (String a : authors.split(",")) {
                book.addAuthor(a.trim());
            }
        }
        store.addMedia(book);
        JOptionPane.showMessageDialog(this,
                "Book \"" + title + "\" added to store.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}
