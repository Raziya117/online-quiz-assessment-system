# 📚 Online Quiz & Assessment System
## 📌 Project Description
This project is a console-based Online Quiz System developed using Core Java.It allows an admin to add questions and users to take quizzes with a timer.The system evaluates answers automatically and displays the final score along with performance feedback.

## 🚀 Features
- 👨‍💼 Admin Module
  - Add new questions and options
  - Store questions in a file (questions.txt)
- 👤 User Module
  - Attempt multiple-choice quiz
  - Timer-based questions (10 seconds per question)
  - Auto evaluation of answers
- 📊 Result Analysis
  - Displays score
  - Shows percentage
  - Performance feedback (Excellent/Good/Practice more)

## 🛠️ Technologies Used
- Java
- OOP concepts
   - Classes and objects
- Collections
   - ArrayList
- File Handling
   - FileWriter
   - BufferedReader
- Multithreading
   - Timer implementation using threads

## 📂 Project Structure
- QuizApp.java
- questions.txt
- README.md

## 📄 File Format (questions.txt)
Each question is stored in the following format:

Question
Option A
Option B
Option C
Option D
Correct Answer (A/B/C/D)

## ▶️ Execution
1. Compile the program
   ` javac QuizApp.java
2.Run the program
   ` java QuizApp
3.Choose:
- 1 -->Admin(Add questions)
- 2 -->User(Take quiz)

## 💡 Sample Output

Welcome to Online Quiz System
1. Admin
2. User
Enter your choice: 2

You have 10 seconds to answer each question...

Question 1: What is Java?
A. Programming Language
B. Operating System
C. Database
D. Browser

Time left: 5 sec
Correct!

...

Quiz Finished!
Your Score: 5/6
Excellent! You got all answers correct!

## 🔮 Future Enhancements

- Add GUI using Swing/JavaFX
- Use MySQL database instead of file
- Add user authentication
- Improve timer accuracy

## 📌 Conclusion
This project demonstrates the use of Core Java concepts, file handling, collections, and multithreading to build a real-world application like a quiz system.

## 👨‍💻 Author
Raziya Mohammad



  
