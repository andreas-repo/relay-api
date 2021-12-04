package org.homegarden.logic;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

public class RelayLogic {
    GpioPinDigitalOutput pin15;
    GpioPinDigitalOutput pin16;
    GpioPinDigitalOutput pin01;
    GpioPinDigitalOutput pin00;

    public RelayLogic(GpioPinDigitalOutput pin15, GpioPinDigitalOutput pin16, GpioPinDigitalOutput pin01, GpioPinDigitalOutput pin00) {
        this.pin15 = pin15;
        this.pin16 = pin16;
        this.pin01 = pin01;
        this.pin00 = pin00;

        pin15.setShutdownOptions(true, PinState.LOW);
        pin16.setShutdownOptions(true, PinState.LOW);
        pin01.setShutdownOptions(true, PinState.LOW);
        pin00.setShutdownOptions(true, PinState.LOW);
    }

    public void relayOpen(int id) throws InterruptedException {
        switch(id) {
            case 1:
                pin00.high();
                break;
            case 2:
                pin01.high();
                break;
            case 3:
                pin16.high();
                break;
            case 4:
                pin15.high();
        }
    }

    public void relayClose(int id) throws InterruptedException {
        switch(id) {
            case 1:
                pin00.low();
                break;
            case 2:
                pin01.low();
                break;
            case 3:
                pin16.low();
                break;
            case 4:
                pin15.low();
        }
    }
}
