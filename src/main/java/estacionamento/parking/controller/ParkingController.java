package estacionamento.parking.controller;

import estacionamento.parking.controller.dto.ParkingDTO;
import estacionamento.parking.controller.mapper.ParkingMapper;
import estacionamento.parking.model.Parking;
import estacionamento.parking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;
        /*for (Parking parking : parkingList) {
            ParkingDTO dto = new ParkingDTO();
            dto.setId(parking.getId());
        }*/
            

    }

}
