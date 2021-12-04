package org.homegarden.impl;

import com.pi4j.io.gpio.*;
import org.homegarden.api.RelayResource;
import org.homegarden.logic.RelayLogic;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RelayResourceImpl implements RelayResource {
    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "Channel 1", PinState.LOW);
    final GpioPinDigitalOutput pin16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "Channel 1", PinState.LOW);
    final GpioPinDigitalOutput pin01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Channel 1", PinState.LOW);
    final GpioPinDigitalOutput pin00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Channel 1", PinState.LOW);

    RelayLogic relayLogic = new RelayLogic(pin15, pin16, pin01, pin00);

    @Override
    public Response start(int id) {
        Response response = Response.status(400).build();
        try{
            relayLogic.relayOpen(id);
            response = Response.ok("Relay " +id +" closed. Water is flowing.").status(200).build();
        } catch (InterruptedException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response stop(int id) {
        Response response = Response.status(400).build();
        try{
            relayLogic.relayClose(id);
            response = Response.ok("Relay " +id +" opened. Water isn't flowing.").status(200).build();
        } catch (InterruptedException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return response;
    }
}
