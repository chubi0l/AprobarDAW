package backend.main.controller;

import backend.main.controller.model.FunkoState;
import java.util.List;

import backend.main.controller.service.FunkoService;
import backend.main.dto.AddressDTO;
import backend.main.dto.FunkoDTO;
import backend.main.service.SaleService;

@RestController
@RequestMapping("api/v1/funkos")
public class FunkoController {

    @Autowired
    private FunkoService funkoService;

    @Autowired
    private SaleService saleService;

    @GetMapping("/")
    public List<FunkoDTO> getFunkos(@RequestParam (required = false) FunkoState status) {
        if((status != null) && status.equals(FunkoState.SOLD)) { // habria que añadir un else if si quiere buscar por DELIVERED o SENT
            return funkoService.findByOrderByPrice(FunkoState.SOLD);
        } else {
            return funkoService.findByOrderByPrice(FunkoState.FOR_SALE); // es para obtener los funkos en venta (los que salen en la página principal)
        }
    }

    @PostMapping("/{id}/address")
    public AddressDTO sellFunko(@RequestBody AddressDTO address, @PathVariable Long id) {
        return saleService.sellFunko(address, id);
    }   

    @PutMapping("/{id}")
    public FunkoDTO updateFunko(@PathVariable Long id, @RequestBody FunkoDTO funko) {
        if (funko.getState().equals(FunkoState.DELIVERED)) {
            return funkoService.setToDelivered(id);
        }
    }

    // O también:
    // @PutMapping("/{id}")
    // public FunkoDTO updateFunko(@RequestBody FunkoDTO funko) {
    //     if (funko.getState().equals(FunkoState.DELIVERED)) {
    //         return funkoService.setToDelivered(funko);
    //     }
    // }
}