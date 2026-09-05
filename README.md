# Android Virtual Camera App

A complete Android Virtual Camera application with support for video/image replacement, frame manipulation, and app-specific camera routing.

## Features

✨ **Core Features:**
- Real-time camera frame interception and replacement
- Support for custom video files as camera feed
- Image capture replacement (BMP/JPEG support)
- Per-app camera configuration
- Adjustable resolution and frame rate
- Audio sync with video playback
- Horizontal flip and rotation support
- Material Design 3 UI with Jetpack Compose

🔧 **Technical Features:**
- Clean Architecture with MVVM pattern
- Hilt Dependency Injection
- Jetpack Compose for UI
- Kotlin Coroutines for async operations
- DataStore for persistent configuration
- CameraX for camera operations
- Media3 for video/audio handling

## Requirements

- Android 5.0+ (API 21+)
- Android Studio Flamingo or later
- Gradle 8.0+
- JDK 11+

## Installation

1. Clone the repository:
```bash
git clone https://github.com/meharimamily-creator/android-virtual-camera-app.git
cd android-virtual-camera-app
```

2. Open in Android Studio and sync Gradle

3. Build and run:
```bash
./gradlew build
./gradlew installDebug
```

## Project Structure

```
app/src/main/java/com/meharimamily/virtualcamera/
├── data/
│   ├── model/          # Data models
│   └── repository/     # Repository implementation
├── domain/
│   └── usecase/        # Business logic use cases
├── di/                 # Dependency Injection
├── service/            # Camera service
├── provider/           # Content provider
└── ui/
    ├── theme/          # Material Design 3 theme
    ├── viewmodel/      # MVVM ViewModels
    └── MainActivity.kt # Main UI
```

## Usage

### Creating a Camera Configuration

1. Open the app
2. Tap the (+) button to create a new configuration
3. Enter a name for the configuration
4. Select target video/image files
5. Configure resolution, frame rate, and effects
6. Select apps that will use this virtual camera
7. Save and activate

### Video Format Requirements

- **Format:** MP4 (H.264 codec recommended)
- **Resolution:** Match target app's camera resolution
- **Frame Rate:** 24-60 FPS
- **Audio:** Optional, enable in settings

### Image Format Requirements

- **Format:** BMP or JPEG
- **Filename:** `1000.bmp` or `1000.jpg`
- **Resolution:** Match app's camera capture resolution

## Permissions

The app requires the following permissions:
- `CAMERA` - Access device camera
- `RECORD_AUDIO` - Record audio from videos
- `READ_EXTERNAL_STORAGE` - Read video/image files
- `WRITE_EXTERNAL_STORAGE` - Cache processed frames
- `INTERNET` - Future cloud features

## Architecture

### Clean Architecture Layers

**Presentation Layer (UI):**
- Jetpack Compose for modern UI
- MVVM ViewModels for state management
- Material Design 3 components

**Domain Layer (Business Logic):**
- Use cases for camera operations
- Repository interfaces
- Independent of frameworks

**Data Layer (Persistence):**
- DataStore for configuration storage
- Repository implementation
- Local caching

## Technologies Used

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Architecture:** Clean Architecture + MVVM
- **DI:** Hilt
- **Async:** Coroutines
- **Storage:** DataStore
- **Camera:** CameraX
- **Media:** Media3
- **Logging:** Timber

## Building Release APK

```bash
./gradlew bundleRelease
# or
./gradlew assembleRelease
```

## Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Troubleshooting

### App crashes on startup
- Ensure all permissions are granted
- Check logcat for detailed error messages
- Verify Android SDK version compatibility

### Camera not replacing
- Verify video resolution matches app's camera output
- Check file paths in configuration
- Ensure video codec is H.264

### Audio out of sync
- Enable "Enable Sound" in settings
- Verify audio codec is AAC
- Check frame rate synchronization

## License

MIT License - see LICENSE file for details

## Support

For issues, questions, or feature requests, please open an issue on GitHub.

## Acknowledgments

- CameraX for modern camera handling
- Jetpack Compose for UI framework
- Hilt for dependency injection
- Material Design 3 for design guidelines

---

**Made with ❤️ for Android developers**
