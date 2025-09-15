# Literary-Delights: An Online Bookshop Project

Completed by: Tutul Majumder  
Semester: Fall 2023-24

This repository features the "Literary-Delights" online bookshop project developed in Java, completed under the guidance of my faculty advisor during the Fall 2023-24 semester.

## Project Structure

```
.
├── Main.java
├── Main.class
├── README.md
├── desktop.ini
├── U_LiteraryDelights.pdf.zip
├── AllTextFiles/
│   ├── BookInfo.txt
│   ├── employee.txt
│   └── UserInfo.txt
├── classes/
│   ├── AboutUs.java/.class
│   ├── Admin.java/.class
│   ├── Book.java/.class
│   ├── BuyF.java
│   ├── Cart.java/.class
│   ├── ContactUs.java/.class
│   ├── DramaF.java/.class
│   ├── HomePage.java/.class
│   ├── Login.java/.class
│   ├── MysteryF.java/.class
│   ├── Payment.java/.class
│   ├── PaymentFrame.java/.class
│   ├── PoetryF.java/.class
│   ├── Profile.java/.class
│   ├── ShortStoryF.java/.class
│   ├── SplashScreenFrame.java/.class
│   ├── ThrillerF.java/.class
│   ├── UponashF.java/.class
│   └── ... (other class files)
├── Images/
│   ├── logo.jpg
│   ├── B7.JPG, B8.JPG, ... (book cover images)
│   └── ... (other images)
```

### Folder Details

- **AllTextFiles/**  
  Contains text files for persistent data storage:
  - `BookInfo.txt`: List of books with details (name, author, price, image path).
  - `employee.txt`: Employee/user data for admin management.
  - `UserInfo.txt`: User profile information.

- **classes/**  
  Contains all Java source files and compiled `.class` files for the application:
  - GUI frames for different book categories (`DramaF`, `PoetryF`, `ThrillerF`, `ShortStoryF`, `MysteryF`, `UponashF`).
  - Core logic for user authentication (`Login`), shopping cart (`Cart`), payment (`Payment`, `PaymentFrame`), and admin management (`Admin`).
  - Utility and navigation frames (`HomePage`, `AboutUs`, `ContactUs`, `Profile`, `SplashScreenFrame`).
  - Book model (`Book.java`).

- **Images/**  
  Contains all image assets used in the application:
  - Book cover images (e.g., `B7.JPG`, `B8.JPG`, etc.).
  - Logo and other UI graphics.

### How to Run

1. **Download and unzip** the project files.
2. **Open `Main.java`** in your Java editor (IntelliJ, Eclipse, Notepad++, or VS Code).
3. **Compile and run** using the terminal:
   ```sh
   javac Main.java && java Main
   ```
4. **Explore the application** using the GUI.

### Features

- Browse books by category (Drama, Poetry, Thriller, Short Story, Mystery, Uponash).
- Add books to cart and proceed to payment.
- User authentication and profile management.
- Admin panel for employee management.
- Persistent storage using text files.
- Rich GUI with images and navigation.

---

**Happy Reading!**  
The Literary Delights Team