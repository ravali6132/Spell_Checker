import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.HashSet;

public class AdvancedSpellingCheckerGUI extends JFrame {

    private final HashSet<String> dictionary = new HashSet<>();

    private JTextArea inputArea;
    private JTextArea resultArea;
    private JLabel statusBar;

    public AdvancedSpellingCheckerGUI() {

        loadDictionary("dictionary.txt");

        // Frame Settings
        setTitle("Advanced Spelling Checker");
        setSize(750, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // Title
        JLabel title = new JLabel("Advanced Spelling Checker");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(new Color(33, 150, 243));

        mainPanel.add(title, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        centerPanel.setBackground(Color.WHITE);

        // Input Area
        inputArea = new JTextArea();
        inputArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);

        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputScroll.setBorder(BorderFactory.createTitledBorder("Enter Text"));

        // Result Area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultScroll.setBorder(BorderFactory.createTitledBorder("Results"));

        centerPanel.add(inputScroll);
        centerPanel.add(resultScroll);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        JButton checkButton = createButton(
                "Check Spelling",
                new Color(76, 175, 80)
        );

        JButton clearButton = createButton(
                "Clear",
                new Color(244, 67, 54)
        );

        JButton darkModeButton = createButton(
                "Dark Mode",
                new Color(55, 71, 79)
        );

        buttonPanel.add(checkButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(darkModeButton);

        // Status Bar
        statusBar = new JLabel(" Ready");
        statusBar.setForeground(Color.GRAY);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(statusBar, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Button Actions
        checkButton.addActionListener(this::checkSpelling);

        clearButton.addActionListener(e -> {
            inputArea.setText("");
            resultArea.setText("");
            statusBar.setText(" Cleared");
        });

        darkModeButton.addActionListener(e -> toggleDarkMode(mainPanel));

        // Live Word Count
        inputArea.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                updateStatus();
            }

            public void removeUpdate(DocumentEvent e) {
                updateStatus();
            }

            public void changedUpdate(DocumentEvent e) {
                updateStatus();
            }
        });
    }

    // Load Dictionary
    private void loadDictionary(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String word;

            while ((word = br.readLine()) != null) {
                dictionary.add(word.trim().toLowerCase());
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Dictionary file not found!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            System.exit(1);
        }
    }

    // Spell Checking
    private void checkSpelling(ActionEvent e) {

        String text = inputArea.getText().trim();

        if (text.isEmpty()) {
            resultArea.setText("Please enter text.");
            return;
        }

        String[] words = text.split("\\s+");

        StringBuilder output = new StringBuilder();

        int mistakes = 0;

        for (String word : words) {

            String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (!cleanWord.isEmpty()) {

                if (dictionary.contains(cleanWord)) {

                    output.append("✔ ").append(word)
                            .append(" -> Correct\n");

                } else {

                    mistakes++;

                    output.append("❌ ").append(word)
                            .append(" -> Incorrect\n");

                    output.append("Suggestion: ")
                            .append(getSuggestion(cleanWord))
                            .append("\n\n");
                }
            }
        }

        output.append("\nTotal Mistakes: ").append(mistakes);

        resultArea.setText(output.toString());

        statusBar.setText(" Spell check completed");
    }

    // Suggestion Algorithm
    private String getSuggestion(String word) {

        int minDistance = Integer.MAX_VALUE;
        String closestWord = "No suggestion found";

        for (String dictWord : dictionary) {

            int distance = levenshteinDistance(word, dictWord);

            if (distance < minDistance) {

                minDistance = distance;
                closestWord = dictWord;
            }
        }

        return closestWord;
    }

    // Levenshtein Distance Algorithm
    private int levenshteinDistance(String a, String b) {

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= a.length(); i++) {

            for (int j = 1; j <= b.length(); j++) {

                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                        Math.min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1
                        ),
                        dp[i - 1][j - 1] + cost
                );
            }
        }

        return dp[a.length()][b.length()];
    }

    // Button Styling
    private JButton createButton(String text, Color color) {

        JButton button = new JButton(text);

        button.setFont(new Font("SansSerif", Font.BOLD, 15));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    // Dark Mode
    private void toggleDarkMode(JPanel panel) {

        Color dark = new Color(33, 33, 33);

        panel.setBackground(dark);

        inputArea.setBackground(new Color(50, 50, 50));
        inputArea.setForeground(Color.WHITE);

        resultArea.setBackground(new Color(50, 50, 50));
        resultArea.setForeground(Color.WHITE);

        statusBar.setForeground(Color.WHITE);
    }

    // Status Update
    private void updateStatus() {

        String text = inputArea.getText().trim();

        if (text.isEmpty()) {
            statusBar.setText(" Words: 0");
            return;
        }

        int words = text.split("\\s+").length;

        statusBar.setText(" Words: " + words);
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AdvancedSpellingCheckerGUI app =
                    new AdvancedSpellingCheckerGUI();

            app.setVisible(true);
        });
    }
}