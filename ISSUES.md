# Project Issues

This document tracks identified issues and feature requests for `conduit-fill-apk`.

---

## Issue 1: UI/UX Redesign & Modernization

**Title:** `[UX/UI] Overhaul Application User Interface & Visual Aesthetics`  
**URL:** https://github.com/epicenterservices13-spec/conduit-fill-apk/issues/1  
**Labels:** `enhancement`, `ui/ux`

### Description
The current user interface lacks modern design aesthetics, structured visual hierarchy, and clear UX patterns. A complete UI modernization is required to provide a polished, intuitive, and premium user experience.

### Key Problems
- Visual design lacks cohesion, modern typography, and standard layout styling.
- Interactive elements lack visual feedback, hover states, and smooth transitions.
- Inadequate spacing, alignment, and color palette harmonization across components.

### Action Items
- [ ] Establish a modern Design System with consistent color tokens, typography scales, and component spacing.
- [ ] Redesign application layout and primary views for improved visual hierarchy.
- [ ] Implement dynamic interaction feedback (hover effects, active states, smooth loading transitions).
- [ ] Ensure full responsiveness and accessibility compliance (contrast ratios, keyboard focus states).

---

## Issue 2: Documentation, User Onboarding & Feature Explanations

**Title:** `[Docs] Add Project Documentation, User Onboarding & In-App Explanations`  
**URL:** https://github.com/epicenterservices13-spec/conduit-fill-apk/issues/2  
**Labels:** `documentation`, `onboarding`

### Description
The project currently lacks comprehensive documentation and user-facing explanations, making it difficult for users and developers to navigate feature workflows, understand application behavior, or set up the project.

### Key Problems
- Missing repository `README.md` containing setup, installation, and architectural overview.
- Lack of inline tooltips, help text, or onboarding guides explaining key features to users.
- Undocumented inputs, outputs, and configuration options.

### Action Items
- [ ] Create a detailed `README.md` with installation guides, architecture overview, and usage examples.
- [ ] Implement user onboarding prompts, feature tooltips, and contextual explanations within the application UI.
- [ ] Provide clear error handling with helpful troubleshooting messages.
- [ ] Add inline code comments and module documentation for developer clarity.

---

## Issue 3: Gradle Build System Consolidation (v2)

**Title:** `[Build] Consolidate Gradle Configuration & Establish Single-Location Build System (v2)`  
**URL:** https://github.com/epicenterservices13-spec/conduit-fill-apk/issues/3  
**Labels:** `build`, `v2`

### Description
Version 2 (v2) requires consolidating all build configurations and Gradle setup into a single, standardized location within the project repository to ensure reliable and repeatable APK builds.

### Key Problems
- Project missing unified Gradle build structure and wrapper scripts in a single project location.
- Multi-location or uncentralized build configuration leads to inconsistent builds and difficulty reproducing target APK artifacts.

### Action Items
- [ ] Initialize standard single-location Gradle build system (`build.gradle`, `settings.gradle`, `gradle.properties`).
- [ ] Configure `app/` module build dependencies, Android SDK target versions, and manifest configuration.
- [ ] Set up Gradle Wrapper scripts (`gradlew` and `gradlew.bat`).
- [ ] Update documentation with unified build instructions (`./gradlew assembleRelease` / `./gradlew assembleDebug`).
