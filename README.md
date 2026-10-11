# Conduit Fill APK (v2.0)

Conduit Fill application source codebase and single-location Gradle build system.

## Project Structure

```
.
├── app/
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           └── java/com/epicenterservices/conduitfill/MainActivity.java
├── build.gradle
├── settings.gradle
├── gradle.properties
└── ISSUES.md
```

## Download

Built APKs are no longer committed to the repo. The last prebuilt APK is kept at [commit 077a843](https://github.com/epicenterservices13-spec/conduit-fill-apk/raw/077a843c7fbe9d233d8f6adebac4e6f1fb233500/conduit-fill.apk).

## Build Instructions

To build the APK locally using the consolidated Gradle configuration:

```bash
./gradlew assembleDebug
# or
./gradlew assembleRelease
```

## Tracked Issues & Roadmap

See [ISSUES.md](file:///data/data/com.termux/files/home/conduit-fill-apk/ISSUES.md) or visit GitHub Issues:
- **Issue #1:** [[UX/UI] Overhaul Application User Interface & Visual Aesthetics](https://github.com/epicenterservices13-spec/conduit-fill-apk/issues/1)
- **Issue #2:** [[Docs] Add Project Documentation, User Onboarding & In-App Explanations](https://github.com/epicenterservices13-spec/conduit-fill-apk/issues/2)
- **Issue #3:** [[Build] Consolidate Gradle Configuration & Establish Single-Location Build System (v2)](https://github.com/epicenterservices13-spec/conduit-fill-apk/issues/3)
