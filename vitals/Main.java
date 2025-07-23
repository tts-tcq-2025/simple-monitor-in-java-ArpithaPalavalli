package vitals;

public class Main
{

    static boolean batteryIsOk(float temperature, float soc, float chargeRate)
    {
        return validateBattery(temperature, soc, chargeRate);}
}

static boolean validateBattery(float temperature, float soc, float chargeRate)
{
    String validationMessage = validateBatteryParameters(temperature, soc, chargeRate);
    if (validationMessage != null)
    {
        System.out.println(validationMessage);
        return false;
    }
    return true;
}

static String validateBatteryParameters(float temperature, float soc, float chargeRate)
{
    String returnVal = null;
    if (isTemperatureOutOfRange(temperature) || isSocOutOfRange(soc) || isChargeRateOutOfRange(chargeRate))
    {
        returnVal = "Battery not OK!!";
    }

    return returnVal; // All parameters are valid
}
static boolean isTemperatureOutOfRange(float temperature)
{
    return temperature < 0 || temperature > 45;
}

static boolean isSocOutOfRange(float soc)
{
    return soc < 20 || soc > 80;
}

static boolean isChargeRateOutOfRange(float chargeRate)
{
    return chargeRate > 0.8;
}

public static void main(String[] args)
{
    assert(batteryIsOk(25, 70, 0.7f) == true);
    assert(batteryIsOk(50, 85, 0.0f) == false);
    System.out.println("Some more tests needed");
}
