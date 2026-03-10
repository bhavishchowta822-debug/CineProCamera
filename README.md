# CinePro Camera

A professional cinematic camera application for Android, inspired by high-end cinema camera interfaces. This app provides advanced manual controls and professional monitoring tools for video recording.

## Features

- **Manual Camera Controls**: Full control over ISO, Shutter Speed, Manual Focus, White Balance, and Exposure Compensation.
- **Cinematic UI**: A dark, professional interface designed for minimal distraction and maximum efficiency.
- **Real-time Monitoring**: Includes a live histogram, grid lines (rule of thirds), and support for focus peaking and zebra stripes.
- **Video Recording**: High-quality video recording in 4K, 1080p, and 720p with adjustable bitrate and FPS options (24, 30, 60 fps).
- **File Management**: Integrated video gallery for playback and management.
- **Pro Features**: In-app purchase system to unlock 4K recording and professional LUT filters.

## Project Structure

- `app/src/main/java/com/cinepro/camera`: Contains the Kotlin source code.
  - `MainActivity.kt`: The main entry point and camera interface logic.
  - `CameraManager.kt`: Logic for interacting with the Android Camera2 API.
  - `HistogramView.kt`: Custom view for the live histogram overlay.
  - `GridView.kt`: Custom view for the rule-of-thirds grid.
  - `GalleryActivity.kt`: Manages the in-app video gallery.
  - `BillingManager.kt`: Handles in-app purchases for the Pro version.
- `app/src/main/res/layout`: XML layouts for the UI.
- `app/src/main/res/values`: Resource files for themes, colors, and strings.

## How to Build

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/YOUR_GITHUB_USERNAME/CineProCamera.git
   ```
2. **Open in Android Studio**:
   - Open Android Studio and select "Open an Existing Project".
   - Navigate to the `CineProCamera` directory and click "OK".
3. **Sync Gradle**:
   - Wait for Android Studio to sync the Gradle files and download dependencies.
4. **Build and Run**:
   - Connect an Android device or use an emulator.
   - Click the "Run" button (green play icon) in the toolbar.
   - To build a signed APK, go to `Build > Generate Signed Bundle / APK`.

## Requirements

- **Android SDK**: Version 26 (Android 8.0) or higher.
- **Camera2 API Support**: Most modern Android devices support this.
- **Permissions**: The app requires CAMERA, RECORD_AUDIO, and storage permissions to function correctly.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
