# Notepad Application

A lightweight, simple notepad application built with Java. This project demonstrates basic desktop application development with file operations and observer pattern architecture.

## Features

- **Open Files**: Open text files from your file system
- **Save Files**: Save your documents with ease
- **Close Application**: Gracefully close the notepad window
- **Multilingual Support**: Available in English and Spanish
- **Always On Top**: Keep the notepad window above other windows

## Prerequisites

- **Java 8 or higher** - Required to run the application
- **Maven 3.6+** (optional) - For building from source

## Getting Started

### Building the Project

```bash
mvn clean package
```

### Running the Application

```bash
mvn exec:java -Dexec.mainClass="com.notepad.Application"
```

Or after building, run the generated JAR file:

```bash
java -cp target/classes com.notepad.Application
```

## Project Structure

```
notepad/
├── src/
│   ├── main/
│   │   ├── java/com/notepad/
│   │   │   ├── Application.java          # Application entry point
│   │   │   ├── Bootstrap.java            # Initialization logic
│   │   │   ├── Language.java             # Language configuration
│   │   │   ├── Notepad.java              # Main notepad logic
│   │   │   └── controllers/
│   │   │       ├── Editor.java           # Text editor component
│   │   │       ├── Frame.java            # Application window
│   │   │       ├── EditorObserver.java   # Editor observer interface
│   │   │       ├── FrameObserver.java    # Frame observer interface
│   │   │       └── actions/              # Action implementations
│   │   │           ├── Action.java
│   │   │           ├── OpenFileAction.java
│   │   │           ├── SaveFileAction.java
│   │   │           ├── CloseFrameAction.java
│   │   │           └── AlwaysOnTopAction.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── lang/                     # Language property files
│   │           ├── en_US.properties
│   │           └── es_ES.properties
│   └── test/
│       └── java/                         # Test files
└── pom.xml
```

## Usage

1. **Open a File**: Select "Open" from the menu and choose a text file from your computer
2. **Edit Text**: Type or edit the content in the editor window
3. **Save Changes**: Click "Save" to save your document or use Ctrl+S
4. **Close**: Click the close button or "Close" action to exit the application
5. **Stay On Top**: Use the "Always On Top" option to keep the window above others

## Architecture

This project uses:

- **Observer Pattern**: Decoupling between frame and editor components
- **MVC Architecture**: Separation of model, view, and controller logic
- **Action Pattern**: Encapsulation of user actions (Open, Save, Close, etc.)

## Language Support

The application supports multiple languages:
- English (en_US)
- Spanish (es_ES)

Language configuration can be changed in the `Language.java` file.

## License

This project is provided as-is for educational purposes.

## Author

Created as a simple Java desktop application demonstration.
