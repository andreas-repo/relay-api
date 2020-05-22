package org.watering.logic;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;

public class RelayControl {
    private GpioController gpio;

    final GpioPinDigitalOutput pin15;
    final GpioPinDigitalOutput pin16;
    final GpioPinDigitalOutput pin1;
    final GpioPinDigitalOutput pin0;

    public RelayControl(GpioController gpio) {
        this.gpio = gpio;
        int gpio1 = Gpio.wiringPiSetupSys();
        pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "Channel 1", PinState.LOW);
        pin16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "Channel 1", PinState.LOW);
        pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Channel 1", PinState.LOW);
        pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Channel 1", PinState.LOW);
        pin15.setShutdownOptions(true, PinState.LOW);
        pin16.setShutdownOptions(true, PinState.LOW);
        pin1.setShutdownOptions(true, PinState.LOW);
        pin0.setShutdownOptions(true, PinState.LOW);
    }

    public void relayOpen(int id) throws InterruptedException {
        switch(id) {
            case 1:
                pin0.high();
                break;
            case 2:
                pin1.high();
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
                pin0.low();
                break;
            case 2:
                pin1.low();
                break;
            case 3:
                pin16.low();
                break;
            case 4:
                pin15.low();
        }
    }
}
