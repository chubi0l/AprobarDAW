package backend.main.service;

import backend.main.controller.model.FunkoState;
import backend.main.controller.repository.FunkoRepository;
import backend.main.dto.AddressMapper;
import backend.main.repository.AddressRepository;

@Service
public class SaleService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private FunkoRepository funkoRepository;

    @Autowired
    private AddressMapper mapper;

    public AddressDTO sellFunko(AddressDTO address, Long funkoId) {
        Funko funko = funkoRepository.findById(funkoId);
        funko.setState(FunkoState.SOLD);
        Address address = mapper.toDomain(address);
        address.setFunko(funko);
        return addressRepository.save(address);
    }
}
