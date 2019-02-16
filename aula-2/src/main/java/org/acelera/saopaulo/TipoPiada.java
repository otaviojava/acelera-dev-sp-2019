package org.acelera.saopaulo;

import java.util.function.Supplier;

public enum  TipoPiada implements ReacaoPiada {
    RUIM{
        @Override
        public String reagir() {
            return "Nossa, repudio :`(";
        }
    },BOA{
        @Override
        public String reagir() {
            return "ha ha ha lol";
        }
    };


}
