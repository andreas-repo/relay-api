package org.watering.impl;

import com.pi4j.io.gpio.*;
import org.watering.logic.RelayControl;
import org.watering.resource.RelayResource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RelayResourceImpl implements RelayResource {
    final GpioController gpio = GpioFactory.getInstance();
    RelayControl relay = new RelayControl(gpio);

    @Override
    public Response start(int id) {
        String response = null;
        try {
            relay.relayOpen(id);
            response = "Relay " +id +" closed. Water is being pumped.";
        } catch (InterruptedException e) {
            response = e.getMessage();
        }
        return Response.ok(response).build();
    }

    @Override
    public Response stop(int id) {
        String response = null;
        try {
            relay.relayClose(id);
            response = "Relay " +id +" opened. Water is not pumped";
        } catch (InterruptedException e) {
            response = e.getMessage();
        }
        return Response.ok(response).build();
    }
}
