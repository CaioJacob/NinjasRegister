package dev.java10x.ninjasregister.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // List all ninjas
    public List<NinjaDTO> listNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // List ninja by ID
    public NinjaDTO getNinjaById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.map(ninjaMapper::map).orElse(null);
    }

    //Add a ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja =  ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Delete Ninja
    public void deleteNinjasById(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Update Ninja
    public NinjaDTO updateNinja(NinjaDTO ninjaDTO, Long id) {
        Optional<NinjaModel> existingNinja = ninjaRepository.findById(id);
        if (existingNinja.isPresent()) {
            NinjaModel ninjaUpdated = ninjaMapper.map(ninjaDTO);
            ninjaUpdated.setId(id);
            NinjaModel ninjaSaved = ninjaRepository.save(ninjaUpdated);
            return ninjaMapper.map(ninjaSaved);
        }
        return null;

    }



}
