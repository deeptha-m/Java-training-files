package extras;

/**
 * 電気のスイッチクラス.
 *
 * @author tito
 * @version 2019/09/25
 */
public class ElectricalSwitch {

    private ElectricalStatus status = ElectricalStatus.INIT;
    private boolean isOn;
    private LightBulb lightBulb;
    private Malfunction malfunction;

    public ElectricalSwitch() {
        this.malfunction = new MalfunctionImpl();
    }

    public ElectricalSwitch(Malfunction malfunction) {
        this.malfunction = malfunction;
    }

    public void on() {
        if (this.isOn() == true) {
            throw new AlreadySwicthOnRuntimeException();
        }
        this.isOn = true;
        if (this.isExistLightBulb() == false) {
            this.status = ElectricalStatus.NOT_EXISTS_LIGHT_BULB;
            return;
        }
        if (malfunction.isMalfunction() == true) {
            this.status = ElectricalStatus.MALFUNCTION;
            return;
        }
        this.status = ElectricalStatus.ON;
    }

    public ElectricalStatus getStatus() {
        return status;
    }

    public void off() {
        this.status = ElectricalStatus.OFF;
        this.isOn = false;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void setLightBulb(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    public boolean isExistLightBulb() {
        if (this.lightBulb == null) {
            return false;
        }
        return true;
    }

}
