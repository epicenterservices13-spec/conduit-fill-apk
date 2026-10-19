import { calculateFill } from './engine';
import { wireAreas, conduitAreas } from './necData';
import assert from 'assert';

// Mock data injection for testing purposes
wireAreas.push({ type: 'THHN', gauge: '12_AWG', areaSqInches: 0.0133 });
wireAreas.push({ type: 'THHN', gauge: '10_AWG', areaSqInches: 0.0211 });
conduitAreas.push({ type: 'EMT', size: '1/2', totalAreaSqInches: 0.304 });
conduitAreas.push({ type: 'EMT', size: '3/4', totalAreaSqInches: 0.533 });
conduitAreas.push({ type: 'EMT', size: '1', totalAreaSqInches: 0.864 });

function runTests() {
    console.log("Running Engine Tests...");

    const result1 = calculateFill('EMT', '1/2', 'THHN', '12_AWG', 4);
    assert.strictEqual(result1.pass, true, "Test 1 Failed: Should pass");
    assert.ok(Math.abs(result1.totalConductorArea - 0.0532) < 0.0001, "Test 1 Failed: Area mismatch");
    assert.strictEqual(result1.recommendedConduitSize, '1/2');
    console.log("Test 1 Passed");

    // 20x THHN 10 AWG (area 0.422) needs allowable area >= 0.422
    // 1" EMT area is 0.864. 40% of 0.864 is 0.3456 (not enough)
    // We don't have > 1" configured in mock data, so recommended size might be undefined
    const result2 = calculateFill('EMT', '1/2', 'THHN', '10_AWG', 20);
    assert.strictEqual(result2.pass, false, "Test 2 Failed: Should fail");
    assert.strictEqual(result2.recommendedConduitSize, undefined, "Test 2 Failed: Should not find size in mock data");
    console.log("Test 2 Passed");

    // Let's test a case where it fails 1/2" but passes 3/4"
    // 3/4" allowable is 0.4 * 0.533 = 0.2132
    // 12x THHN 12 AWG (0.0133) = 0.1596
    const result3 = calculateFill('EMT', '1/2', 'THHN', '12_AWG', 12);
    assert.strictEqual(result3.pass, false, "Test 3 Failed: Should fail 1/2\"");
    assert.strictEqual(result3.recommendedConduitSize, '3/4', "Test 3 Failed: Should recommend 3/4\"");
    console.log("Test 3 Passed");

    console.log("All Tests Passed!");
}

runTests();
