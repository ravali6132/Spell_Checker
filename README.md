# 📝 Advanced Spelling Checker

## 📌 Project Overview

Advanced Spelling Checker is a modern Java-based desktop application developed using Java Swing that helps users identify spelling mistakes and generate intelligent correction suggestions.

The application provides a user-friendly graphical interface where users can enter single words or complete sentences for spell checking. The system validates entered words against a dictionary file and identifies incorrect spellings. For incorrect words, the application generates the closest matching suggestions using the Levenshtein Distance Algorithm.

This project demonstrates concepts such as GUI development, file handling, event-driven programming, dynamic programming algorithms, and efficient data lookup using HashSet.

---

# 🚀 Features

## ✅ Core Features

* Spell checking for words and sentences
* Modern Java Swing graphical user interface
* Fast dictionary lookup using HashSet
* Intelligent spelling suggestions
* Real-time word counting
* Clear input functionality
* Dark mode support
* Multi-word sentence validation
* Error highlighting through result display

---

# 🛠️ Technologies Used

| Technology                     | Purpose                           |
| ------------------------------ | --------------------------------- |
| Java                           | Core programming language         |
| Java Swing                     | GUI development                   |
| File Handling                  | Reading dictionary file           |
| HashSet                        | Fast word lookup                  |
| Event Handling                 | User interaction handling         |
| Levenshtein Distance Algorithm | Suggestion generation             |
| Dynamic Programming            | Distance calculation optimization |

---

# 🧠 Concepts Used

This project demonstrates the following programming concepts:

* Object-Oriented Programming
* GUI Design
* Event-Driven Programming
* Dynamic Programming
* Data Structures
* String Manipulation
* File Handling
* Algorithm Design

---

# 📂 Project Structure

```plaintext
AdvancedSpellingChecker/
│
├── AdvancedSpellingCheckerGUI.java
├── dictionary.txt
├── README.md
└── screenshots/
    └── home.png
```

---

# ⚙️ System Workflow

```plaintext
User enters text
        ↓
Application splits text into words
        ↓
Words are cleaned and normalized
        ↓
Each word is searched in dictionary
        ↓
Correct words are validated
        ↓
Incorrect words detected
        ↓
Levenshtein algorithm generates suggestions
        ↓
Results displayed to user
```

---

# 🔍 How Spell Checking Works

The application reads words from a dictionary file and stores them inside a HashSet.

HashSet provides:

* fast lookup
* efficient searching
* constant time complexity for search operations

When the user enters text:

1. The text is split into words.
2. Symbols and special characters are removed.
3. Each word is converted to lowercase.
4. The word is searched inside the dictionary.
5. If not found, the word is marked incorrect.
6. Suggestions are generated.

---

# 🧮 Suggestion Generation Algorithm

## Levenshtein Distance Algorithm

The application uses the Levenshtein Distance algorithm to generate spelling suggestions.

This algorithm calculates the minimum number of operations required to transform one word into another.

Operations include:

* insertion
* deletion
* substitution

---

## Example

```plaintext
scence → science
intilligence → intelligence
machne → machine
```

---

# 📖 Dictionary File Format

The dictionary file should contain one valid word per line.

Example:

```plaintext
hello
world
java
computer
science
artificial
intelligence
machine
learning
application
```

---

# ⚙️ Installation Guide

## Step 1: Install Java

Install JDK 8 or higher.

Verify installation:

```bash
java -version
javac -version
```

---

## Step 2: Clone Repository

```bash
git clone <your-github-repository-link>
```

---

## Step 3: Open Project Folder

```bash
cd AdvancedSpellingChecker
```

---

## Step 4: Compile the Program

```bash
javac AdvancedSpellingCheckerGUI.java
```

---

## Step 5: Run the Application

```bash
java AdvancedSpellingCheckerGUI
```

---

# 🖥️ User Interface Components

## Input Area

Allows users to enter words or sentences.

---

## Results Area

Displays:

* correct words
* incorrect words
* suggestions
* mistake count

---

## Buttons

### Check Spelling

Checks spelling and generates suggestions.

### Clear

Clears input and output fields.

### Dark Mode

Switches application theme to dark mode.

---

## Status Bar

Displays:

* word count
* application status
* completion messages

---

# 📸 Screenshots
<img width="720" height="535" alt="image" src="https://github.com/user-attachments/assets/e9284ab8-020d-406d-9a48-1f8a7b7777ae" />

# 🔥 Sample Input

```plaintext
scence
intilligence
machne
```

---

# 🔥 Sample Output

```plaintext
❌ scence -> Incorrect
Suggestion: science

❌ intilligence -> Incorrect
Suggestion: intelligence

❌ machne -> Incorrect
Suggestion: machine

Total Mistakes: 3
```

---

# 📊 Time Complexity

| Operation         | Complexity |
| ----------------- | ---------- |
| Dictionary Lookup | O(1)       |
| Suggestion Search | O(n × m)   |

Where:

* n = number of dictionary words
* m = word length

---

# 🎯 Learning Outcomes

Through this project, the following skills were developed:

* GUI development using Java Swing
* File handling in Java
* Event handling mechanisms
* Dynamic programming implementation
* Efficient data searching using HashSet
* String processing and validation
* User interface design

---

# 🚧 Challenges Faced

* Managing GUI layouts properly
* Implementing efficient suggestion generation
* Handling user input validation
* Optimizing word lookup performance
* Designing clean UI components

---

# 🔮 Future Enhancements

The following improvements can be added in future versions:

* Grammar checking
* Real-time spell highlighting
* Auto-correction feature
* Voice input support
* Multi-language support
* AI-based smart suggestions
* Cloud dictionary integration
* File upload support
* Paragraph correction support

---

# 💡 Possible Real-World Applications

* Educational software
* Text editors
* Writing assistance tools
* Learning applications
* Email validation systems
* Content writing platforms

---

# 📌 Why This Project Is Important

This project demonstrates:

* strong Java fundamentals
* problem-solving skills
* algorithm implementation
* GUI development experience
* understanding of data structures
* real-world application development

---

# 🤝 Contribution

Contributions are welcome.

You can improve:

* UI design
* algorithm optimization
* grammar correction
* suggestion accuracy
* performance improvements

---

# 📜 License

This project is developed for educational and learning purposes.

---

# 👨‍💻 Author

Ravali Koppisetti

---

# ⭐ Support

If you found this project useful, consider giving it a star on GitHub.
