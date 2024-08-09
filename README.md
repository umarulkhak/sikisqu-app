# Sikisqu

🌟 **Sikisqu** is an Android-based mobile application designed to facilitate the booking of psychiatric guidance sessions with licensed professionals.

## Features
- **Easy Appointment Booking:** Schedule sessions with psychiatrists at your convenience.
- **Psychiatrist Profiles:** Browse and select from a list of available psychiatrists.
- **Session Reminders:** Receive notifications for upcoming appointments.
- **Secure Communication:** All data is encrypted to ensure user privacy and confidentiality.

## Tech Stack
- **Kotlin:** The primary language used for application development.
- **XML:** Used for designing user interfaces that are both intuitive and responsive.
- **CodeIgniter (CI):** Utilized for building the backend API to manage data and business logic.
- **MySQL:** The database system used to store user data, psychiatrist profiles, and appointment schedules.

## Installation

### Prerequisites
- Android Studio
- PHP environment (e.g., XAMPP, WAMP)
- MySQL database

### Steps
1. **Clone the repository:**
    ```bash
    git clone https://github.com/umarulkhak/sikisqu-app.git
    ```
   
2. **Backend Setup:**
   - Navigate to the `backend/` directory and place it within your PHP server's root directory (e.g., `htdocs` for XAMPP).
   - Import the MySQL database using the `sikisqu.sql` file located in the `backend/database/` directory.
   - Configure the database connection in the `backend/application/config/database.php` file with your MySQL credentials.

3. **Android App Setup:**
   - Open the `android/` directory in Android Studio.
   - Build the project and run it on an Android device or emulator.

## Usage
1. Register or log in to your account.
2. Browse available psychiatrists.
3. Select a psychiatrist and choose a suitable time for your session.
4. Confirm the appointment and receive a notification as the session time approaches.

## Contributing
We welcome contributions! Please fork this repository and submit a pull request with your changes. Ensure your code follows the project's coding standards and is well-documented.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any inquiries or support, please contact us at support@sikisqu.com.
