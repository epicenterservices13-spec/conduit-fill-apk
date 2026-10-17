import { ConduitType, ConduitSize, WireType, WireGauge, getWireArea, getConduitArea } from './necData';

export interface FillCalculationResult {
    totalConductorArea: number;
    allowableFillArea: number;
    fillPercentage: number;
    pass: boolean;
    recommendedConduitSize?: ConduitSize;
}

const standardConduitSizes: ConduitSize[] = ['1/2', '3/4', '1', '1_1/4', '1_1/2', '2', '2_1/2', '3', '3_1/2', '4'];

export function calculateFill(
    conduitType: ConduitType,
    conduitSize: ConduitSize,
    wireType: WireType,
    wireGauge: WireGauge,
    quantity: number
): FillCalculationResult {
    // 1. Get wire area and compute total conductor area
    const singleWireArea = getWireArea(wireType, wireGauge);
    const totalConductorArea = singleWireArea * quantity;

    // 2. Get conduit total area
    const conduitTotalArea = getConduitArea(conduitType, conduitSize);

    // 3. Compute allowable fill area
    let fillMultiplier = 0.40; // Default over 2
    if (quantity === 1) {
        fillMultiplier = 0.53;
    } else if (quantity === 2) {
        fillMultiplier = 0.31;
    }
    const allowableFillArea = conduitTotalArea * fillMultiplier;

    // 4. Compute fill percentage
    const fillPercentage = (totalConductorArea / conduitTotalArea) * 100;

    // 5. Determine pass/fail
    const pass = totalConductorArea <= allowableFillArea;

    // 6. Find recommended conduit size
    let recommendedConduitSize: ConduitSize | undefined = undefined;
    for (const size of standardConduitSizes) {
        try {
            const area = getConduitArea(conduitType, size);
            if (totalConductorArea <= (area * fillMultiplier)) {
                recommendedConduitSize = size;
                break;
            }
        } catch (e) {
            // Ignore if data is missing for a particular size
        }
    }

    return {
        totalConductorArea,
        allowableFillArea,
        fillPercentage,
        pass,
        recommendedConduitSize
    };
}
