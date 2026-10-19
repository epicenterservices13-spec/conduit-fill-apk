export type ConduitType = 'EMT' | 'PVC_SCHEDULE_40' | 'PVC_SCHEDULE_80' | 'RMC' | 'IMC';
export type WireType = 'THHN' | 'THWN' | 'XHHW';
export type WireGauge = '14_AWG' | '12_AWG' | '10_AWG' | '8_AWG' | '6_AWG' | '4_AWG' | '3_AWG' | '2_AWG' | '1_AWG' | '1/0_AWG' | '2/0_AWG' | '3/0_AWG' | '4/0_AWG' | '250_kcmil' | '300_kcmil' | '350_kcmil' | '400_kcmil' | '500_kcmil' | '600_kcmil' | '750_kcmil' | '1000_kcmil';
export type ConduitSize = '1/2' | '3/4' | '1' | '1_1/4' | '1_1/2' | '2' | '2_1/2' | '3' | '3_1/2' | '4';

export interface WireArea {
    type: WireType;
    gauge: WireGauge;
    areaSqInches: number;
}

export interface ConduitArea {
    type: ConduitType;
    size: ConduitSize;
    totalAreaSqInches: number;
}

// Data sets to be populated later or retrieved from actual NEC Tables
export const wireAreas: WireArea[] = [];
export const conduitAreas: ConduitArea[] = [];

export function getWireArea(type: WireType, gauge: WireGauge): number {
    const wire = wireAreas.find(w => w.type === type && w.gauge === gauge);
    if (!wire) {
        throw new Error(`Wire area not found for type ${type} and gauge ${gauge}`);
    }
    return wire.areaSqInches;
}

export function getConduitArea(type: ConduitType, size: ConduitSize): number {
    const conduit = conduitAreas.find(c => c.type === type && c.size === size);
    if (!conduit) {
        throw new Error(`Conduit area not found for type ${type} and size ${size}`);
    }
    return conduit.totalAreaSqInches;
}
