package backend.main.controller.service;

import java.util.List;

import backend.main.dto.FunkoDTO;
import backend.main.dto.FunkoMapper;
import backend.main.model.FunkoState;
import backend.main.repository.FunkoRepository;

@Service
public class FunkoService {
    @Autowired
    private FunkoRepository funkoRepository;

    @Autowired
    private FunkoMapper mapper;

    public List<FunkoDTO> findByOrderByPrice(FunkoState status) {
        return mapper.toDTOs(funkoRepository.findByStatusOrderByPrice((status)));
    }

    public FunkoDTO setToDelivered(Long id) {
        Funko funko = funkoRepository.findById(funkoDTO);
        funko.setState(FunkoState.DELIVERED);
        return mapper.toDTOs(funkoRepository.save(funko));
    }

    // También se puede:
    // public FunkoDTO setToDelivered(FunkoDTO funkoDTO) {
    //     Funko funko = mapper.toDomain(funkoDTO);
    //     funko.setState(FunkoState.DELIVERED);
    //     return mapper.toDTOs(funkoRepository.save(funko));
    // }
}
