package extras;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ElectricalSwitchTest {

    @Test
    public void スイッチをONに出来る事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.on();
    }

    @Test
    public void スイッチをOFFに出来る事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.off();
    }

    @Test
    public void 電気のスイッチがONになっているか確認できる事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.on();
        boolean isOn = electricalSwitch.isOn();
        assertThat(isOn, is(true));
    }

    @Test
    public void 電気のスイッチがOFFになっているか確認できる事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.off();
        boolean isOn = electricalSwitch.isOn();
        assertThat(isOn, is(false));
    }

    @Test
    public void 電気のスイッチがOFFになっているか確認できる事2() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.on();
        electricalSwitch.off();
        boolean isOn = electricalSwitch.isOn();
        assertThat(isOn, is(false));
    }

    @Test
    public void 電球が存在しているか確認できる事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        LightBulb lightBulb = new LightBulb();
        electricalSwitch.setLightBulb(lightBulb);
        boolean isExistLighBulb = electricalSwitch.isExistLightBulb();
        assertThat(isExistLighBulb, is(true));
    }

    @Test
    public void 電球が存在してないか確認できる事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        boolean isExistLighBulb = electricalSwitch.isExistLightBulb();
        assertThat(isExistLighBulb, is(false));
    }

    @Test
    public void 電気のステータスが初期値になっている事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        ElectricalStatus status = electricalSwitch.getStatus();
        assertThat(status, is(ElectricalStatus.INIT));
    }

    @Test
    public void 電気のステータスがOFFになっている事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.off();
        ElectricalStatus status = electricalSwitch.getStatus();
        assertThat(status, is(ElectricalStatus.OFF));
    }

    @Test
    public void 電気のステータスがONになっている事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch(new Malfunction() {
            @Override
            public boolean isMalfunction() {
                return false;
            }
        });
        electricalSwitch.setLightBulb(new LightBulb());
        electricalSwitch.on();
        ElectricalStatus status = electricalSwitch.getStatus();
        //ランダム性によりテストが失敗する場合がある
        assertThat(status, is(ElectricalStatus.ON));
    }

    @Test
    public void 電気のステータスが故障中になっている事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch(new Malfunction() {
            @Override
            public boolean isMalfunction() {
                return true;
            }
        });
        electricalSwitch.setLightBulb(new LightBulb());
        electricalSwitch.on();
        ElectricalStatus status = electricalSwitch.getStatus();
        //ランダム性によりテストが失敗する場合がある
        assertThat(status, is(ElectricalStatus.MALFUNCTION));
    }

    @Test
    public void 電気のステータスが電球無しになっている事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.on();
        ElectricalStatus status = electricalSwitch.getStatus();
        assertThat(status, is(ElectricalStatus.NOT_EXISTS_LIGHT_BULB));
    }

    @Test(expected = AlreadySwicthOnRuntimeException.class)
    public void ONの場合にさらにONした場合例外が発生する事() throws Exception {
        ElectricalSwitch electricalSwitch = new ElectricalSwitch();
        electricalSwitch.on();
        electricalSwitch.on();
    }

}
