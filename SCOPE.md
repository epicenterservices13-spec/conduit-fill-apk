# Project Scope: Conduit Fill APK

## 1. Overview
An Android application for electrical contractors and field electricians to calculate NEC (National Electrical Code) conduit fill percentages, conductor cross-sectional areas, and raceway capacities.

## 2. In-Scope Features
- **NEC Calculations**: Chapter 9 Tables 1, 4, and 5 conduit fill compliance (40% fill for 3+ conductors, 31% for 2, 53% for 1).
- **Conduit & Conductor Types**: EMT, PVC (Sch 40/80), RMC, FMC; THHN/THWN-2, XHHW, USE wire gauges.
- **Android Native UI**: Responsive single-activity mobile layout.

## 3. Out-of-Scope
- Cloud sync or mandatory network logins.
- Complex billing/invoicing modules (handled separately in field hub).

## 4. Technology Stack
- **Platform**: Android SDK / Gradle
- **Language**: Java / Android Native
- **Build**: Gradle (`./gradlew assembleDebug` or `assembleRelease`)
