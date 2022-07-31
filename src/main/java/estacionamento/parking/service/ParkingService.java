package estacionamento.parking.service;

import estacionamento.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static final Map<String, Parking> parkingMap = new HashMap();
    static {

        var id  = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "DF", "320I", "BRANCA");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
