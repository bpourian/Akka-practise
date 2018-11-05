package com.myapp.listener;

import akka.actor.UntypedActor;
import com.myapp.message.PiApproximation;

public class Listener extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof PiApproximation) {
            PiApproximation approximation = (PiApproximation) message;
            System.out.println(String.format("\n\tMain approximation: \t\t%s\n\n\tCalculation time: \t\t\t%s",
                    approximation.getPi(), approximation.getDuration()));
            getContext().system().shutdown();
        } else {
            unhandled(message);
        }

    }
}
