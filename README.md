# CU Faculty Finder App 

[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](https://www.android.com)
[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.0-6DB33F.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> A smart Android application for Chandigarh University students to easily locate faculty members across departments.

## 📊 Key Metrics

- 🏆 **Adoption Rate**: Used by over **70% of 3rd-year students** (as of July 19, 2024)
- ⚡ **Response Time**: < 1.5 seconds for search results
- 🔄 **Daily API Calls**: ~2,500 unique requests

## ✨ Features

<table>
  <tr>
    <td>
      <h3>🔍 Smart Search</h3>
      <p>Find faculty by name, department, or designation with intelligent fuzzy matching</p>
    </td>
    <td>
      <h3>🏢 Detailed Profiles</h3>
      <p>Complete information including contact details, expertise, and precise cabin location</p>
    </td>
  </tr>
  <tr>
    <td>
      <h3>🧭 Intuitive UI</h3>
      <p>Clean, modern interface designed for quick access and minimal learning curve</p>
    </td>
    <td>
      <h3>📡 Real-time Updates</h3>
      <p>Automatic synchronization with university database for the latest information</p>
    </td>
  </tr>
</table>

## 🖼️ App Screenshots

<div align="center">
  <img src="https://github.com/user-attachments/assets/9e0fefcd-6f55-4556-8101-a6146140db15" width="18%" />
  <img src="https://github.com/user-attachments/assets/84b129c7-f88d-4045-b72f-ea096311a314" width="18%" />
  <img src="https://github.com/user-attachments/assets/faccdae1-8e6c-4b85-a07e-ff61b9ab6c20" width="18%" />
  <img src="https://github.com/user-attachments/assets/491c50df-69fd-482c-84a9-d544220bf031" width="18%" />
</div>

## 🛠️ Technology Stack

<table>
  <tr>
    <th>Layer</th>
    <th>Technology</th>
    <th>Purpose</th>
  </tr>
  <tr>
    <td><b>Frontend</b></td>
    <td>Java + XML (Android)</td>
    <td>Native Android application development</td>
  </tr>
  <tr>
    <td><b>Backend</b></td>
    <td>Spring Boot (REST API)</td>
    <td>Server-side processing and data management</td>
  </tr>
  <tr>
    <td><b>Networking</b></td>
    <td>Retrofit</td>
    <td>HTTP API communication</td>
  </tr>
  <tr>
    <td><b>Data Parsing</b></td>
    <td>GSON</td>
    <td>JSON serialization/deserialization</td>
  </tr>
  <tr>
    <td><b>UI Components</b></td>
    <td>Material Design</td>
    <td>Modern visual elements and interactions</td>
  </tr>
</table>

## 📱 App Architecture

```
com.abhishek.cufacultyfinder/
├── api/                  # API service interfaces & models
├── database/             # Local caching implementation
├── di/                   # Dependency injection modules
├── ui/                   # Activities, fragments & adapters
│   ├── home/             # Home screen
│   ├── search/           # Search functionality
│   ├── details/          # Faculty details
│   └── settings/         # User preferences
├── utils/                # Helper classes & extensions
└── CUFacultyApp.java     # Application class
```

## ⚙️ Setup Instructions

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- JDK 8+
- Gradle 8.0+
- Spring Boot 2.7+ (for API)

### Clone & Build

```bash
# Clone the repository
git clone https://github.com/abhishekraj099/cu-faculty-finder.git
cd cu-faculty-finder

# Build Android app
./gradlew assembleDebug

# Run Spring Boot API (in separate terminal)
cd faculty-api
./mvnw spring-boot:run
```

### Configuration

1. Open `api/src/main/resources/application.properties`
2. Update the database connection:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/faculty_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## 🤝 Contributing

We welcome contributions to improve the CU Faculty Finder App!

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add some amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📫 Contact

<table>
  <tr>
    <td><img src="/api/placeholder/80/80" alt="Developer Photo" style="border-radius:50%"/></td>
    <td>
      <h3>Abhishek Raj</h3>
      <p>📍 Patna, Bihar</p>
      <p>
        <a href="https://linkedin.com/in/abhishekraj099">LinkedIn</a> •
        <a href="mailto:abhishekraj099@gmail.com">Email</a> •
        <a href="https://github.com/abhishekraj099">GitHub</a>
      </p>
    </td>
  </tr>
</table>

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

<div align="center">
  <sub>⭐ If you find this project helpful, please consider giving it a star on GitHub! ⭐</sub>
</div>
