## ConduitPro Journal

## 2026-10-17 - Architectural Contracts for NEC Data

**Learning:**
The Version 2 project is currently empty of logic. Hardcoding unverified NEC dimensions (like EMT areas or THHN sizes) or fill percentages creates significant safety and compliance risks. We must not invent electrical code data.

**Action:**
Future work should rely on strict interfaces (`ConduitFillEngine`, `NecValidator`) and domain models (`Conduit`, `Conductor`, `FillCalculation`, `NecValidationResult`). This establishes a foundation that can safely consume verified NEC data from external or future internal sources without compromising the integrity of the application.
