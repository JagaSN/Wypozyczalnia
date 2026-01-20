package citybike.service;

import citybike.domain.*;

public class ReportingService {
    // Generuje raport CSV – używa polimorfizmu

    public String generateCsv(DockingStation station) {
        StringBuilder sb = new StringBuilder();
        sb.append("id,type,info,status\n");

        for (Vehicle v : station.getAllVehicles()) {
            if (v instanceof Exportable e) {
                sb.append(e.toCsv()).append("\n");
            }
        }
        return sb.toString();
    }
}